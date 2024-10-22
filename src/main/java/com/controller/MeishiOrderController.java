
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 美食订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meishiOrder")
public class MeishiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(MeishiOrderController.class);

    private static final String TABLE_NAME = "meishiOrder";

    @Autowired
    private MeishiOrderService meishiOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
    @Autowired
    private JingdianService jingdianService;//景点
    @Autowired
    private JingdianCollectionService jingdianCollectionService;//景点收藏
    @Autowired
    private JingdianCommentbackService jingdianCommentbackService;//景点评价
    @Autowired
    private JingdianOrderService jingdianOrderService;//景点门票订单
    @Autowired
    private JiudianService jiudianService;//酒店
    @Autowired
    private JiudianCollectionService jiudianCollectionService;//房间收藏
    @Autowired
    private JiudianCommentbackService jiudianCommentbackService;//酒店评价
    @Autowired
    private JiudianOrderService jiudianOrderService;//酒店订单
    @Autowired
    private MeishiService meishiService;//美食
    @Autowired
    private MeishiCollectionService meishiCollectionService;//美食收藏
    @Autowired
    private MeishiCommentbackService meishiCommentbackService;//美食评价
    @Autowired
    private ShangjiaService shangjiaService;//商家
    @Autowired
    private ShangpinService shangpinService;//商品
    @Autowired
    private ShangpinCollectionService shangpinCollectionService;//商品收藏
    @Autowired
    private ShangpinCommentbackService shangpinCommentbackService;//商品评价
    @Autowired
    private ShangpinOrderService shangpinOrderService;//商品订单
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("商家".equals(role))
            params.put("shangjiaId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = meishiOrderService.queryPage(params);

        //字典表数据转换
        List<MeishiOrderView> list =(List<MeishiOrderView>)page.getList();
        for(MeishiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeishiOrderEntity meishiOrder = meishiOrderService.selectById(id);
        if(meishiOrder !=null){
            //entity转view
            MeishiOrderView view = new MeishiOrderView();
            BeanUtils.copyProperties( meishiOrder , view );//把实体数据重构到view中
            //级联表 收货地址
            //级联表
            AddressEntity address = addressService.selectById(meishiOrder.getAddressId());
            if(address != null){
            BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setAddressId(address.getId());
            }
            //级联表 美食
            //级联表
            MeishiEntity meishi = meishiService.selectById(meishiOrder.getMeishiId());
            if(meishi != null){
            BeanUtils.copyProperties( meishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setMeishiId(meishi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(meishiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MeishiOrderEntity meishiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meishiOrder:{}",this.getClass().getName(),meishiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            meishiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        meishiOrder.setCreateTime(new Date());
        meishiOrder.setInsertTime(new Date());
        meishiOrderService.insert(meishiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeishiOrderEntity meishiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meishiOrder:{}",this.getClass().getName(),meishiOrder.toString());
        MeishiOrderEntity oldMeishiOrderEntity = meishiOrderService.selectById(meishiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            meishiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            meishiOrderService.updateById(meishiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeishiOrderEntity> oldMeishiOrderList =meishiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        meishiOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<MeishiOrderEntity> meishiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MeishiOrderEntity meishiOrderEntity = new MeishiOrderEntity();
//                            meishiOrderEntity.setMeishiOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            meishiOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //收货地址 要改的
//                            meishiOrderEntity.setMeishiId(Integer.valueOf(data.get(0)));   //美食 要改的
//                            meishiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            meishiOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买数量 要改的
//                            meishiOrderEntity.setMeishiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            meishiOrderEntity.setMeishiOrderCourierName(data.get(0));                    //派送人 要改的
//                            meishiOrderEntity.setMeishiOrderCourierNumber(data.get(0));                    //联系方式 要改的
//                            meishiOrderEntity.setMeishiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            meishiOrderEntity.setMeishiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            meishiOrderEntity.setInsertTime(date);//时间
//                            meishiOrderEntity.setCreateTime(date);//时间
                            meishiOrderList.add(meishiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("meishiOrderUuidNumber")){
                                    List<String> meishiOrderUuidNumber = seachFields.get("meishiOrderUuidNumber");
                                    meishiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> meishiOrderUuidNumber = new ArrayList<>();
                                    meishiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("meishiOrderUuidNumber",meishiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<MeishiOrderEntity> meishiOrderEntities_meishiOrderUuidNumber = meishiOrderService.selectList(new EntityWrapper<MeishiOrderEntity>().in("meishi_order_uuid_number", seachFields.get("meishiOrderUuidNumber")));
                        if(meishiOrderEntities_meishiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MeishiOrderEntity s:meishiOrderEntities_meishiOrderUuidNumber){
                                repeatFields.add(s.getMeishiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        meishiOrderService.insertBatch(meishiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = meishiOrderService.queryPage(params);

        //字典表数据转换
        List<MeishiOrderView> list =(List<MeishiOrderView>)page.getList();
        for(MeishiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeishiOrderEntity meishiOrder = meishiOrderService.selectById(id);
            if(meishiOrder !=null){


                //entity转view
                MeishiOrderView view = new MeishiOrderView();
                BeanUtils.copyProperties( meishiOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(meishiOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    MeishiEntity meishi = meishiService.selectById(meishiOrder.getMeishiId());
                if(meishi != null){
                    BeanUtils.copyProperties( meishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setMeishiId(meishi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(meishiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody MeishiOrderEntity meishiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meishiOrder:{}",this.getClass().getName(),meishiOrder.toString());
            MeishiEntity meishiEntity = meishiService.selectById(meishiOrder.getMeishiId());
            if(meishiEntity == null){
                return R.error(511,"查不到该美食");
            }
            // Double meishiNewMoney = meishiEntity.getMeishiNewMoney();

            if(false){
            }
            else if(meishiEntity.getMeishiNewMoney() == null){
                return R.error(511,"现价/份不能为空");
            }
            else if((meishiEntity.getMeishiKucunNumber() -meishiOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - meishiEntity.getMeishiNewMoney()*meishiOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            meishiOrder.setMeishiOrderTypes(101); //设置订单状态为已下单
            meishiOrder.setMeishiOrderTruePrice(meishiEntity.getMeishiNewMoney()*meishiOrder.getBuyNumber()); //设置实付价格
            meishiOrder.setYonghuId(userId); //设置订单支付人id
            meishiOrder.setMeishiOrderUuidNumber(String.valueOf(new Date().getTime()));
            meishiOrder.setMeishiOrderPaymentTypes(1);
            meishiOrder.setInsertTime(new Date());
            meishiOrder.setCreateTime(new Date());
                meishiEntity.setMeishiKucunNumber( meishiEntity.getMeishiKucunNumber() -meishiOrder.getBuyNumber());
                meishiService.updateById(meishiEntity);
                meishiOrderService.insert(meishiOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);

            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(meishiEntity.getShangjiaId());
            shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+meishiOrder.getMeishiOrderTruePrice());//动态计算金额
            shangjiaService.updateById(shangjiaEntity);

            return R.ok();
    }


    /**
    * 取消支付
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            MeishiOrderEntity meishiOrder = meishiOrderService.selectById(id);//当前表service
            Integer buyNumber = meishiOrder.getBuyNumber();
            Integer meishiOrderPaymentTypes = meishiOrder.getMeishiOrderPaymentTypes();
            Integer meishiId = meishiOrder.getMeishiId();
            if(meishiId == null)
                return R.error(511,"查不到该美食");
            MeishiEntity meishiEntity = meishiService.selectById(meishiId);
            if(meishiEntity == null)
                return R.error(511,"查不到该美食");
            //获取商家信息
            Integer shangjiaId = meishiEntity.getShangjiaId();
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(shangjiaId);//商家
            Double meishiNewMoney = meishiEntity.getMeishiNewMoney();
            if(meishiNewMoney == null)
                return R.error(511,"美食价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(meishiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = meishiEntity.getMeishiNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


                //修改商家余额
                shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney() - money);
            }

            meishiEntity.setMeishiKucunNumber(meishiEntity.getMeishiKucunNumber() + buyNumber);

            meishiOrder.setMeishiOrderTypes(102);//设置订单状态为已取消支付
            meishiOrderService.updateAllColumnById(meishiOrder);//根据id更新
            shangjiaService.updateById(shangjiaEntity);
            yonghuService.updateById(yonghuEntity);//更新用户信息
            meishiService.updateById(meishiEntity);//更新订单中美食的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer meishiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            MeishiOrderEntity meishiOrder = meishiOrderService.selectById(id);
        if(meishiOrder == null)
            return R.error(511,"查不到该订单");
        Integer meishiId = meishiOrder.getMeishiId();
        if(meishiId == null)
            return R.error(511,"查不到该美食");

        MeishiCommentbackEntity meishiCommentbackEntity = new MeishiCommentbackEntity();
            meishiCommentbackEntity.setId(id);
            meishiCommentbackEntity.setMeishiId(meishiId);
            meishiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            meishiCommentbackEntity.setMeishiCommentbackText(commentbackText);
            meishiCommentbackEntity.setInsertTime(new Date());
            meishiCommentbackEntity.setReplyText(null);
            meishiCommentbackEntity.setUpdateTime(null);
            meishiCommentbackEntity.setCreateTime(new Date());
            meishiCommentbackService.insert(meishiCommentbackEntity);

            meishiOrder.setMeishiOrderTypes(105);//设置订单状态为已评价
            meishiOrderService.updateById(meishiOrder);//根据id更新
            return R.ok();
    }

    /**
     * 派送订单
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ,String meishiOrderCourierNumber, String meishiOrderCourierName , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        MeishiOrderEntity  meishiOrderEntity = meishiOrderService.selectById(id);
        meishiOrderEntity.setMeishiOrderTypes(103);//设置订单状态为已派送订单
        meishiOrderEntity.setMeishiOrderCourierNumber(meishiOrderCourierNumber);
        meishiOrderEntity.setMeishiOrderCourierName(meishiOrderCourierName);
        meishiOrderService.updateById( meishiOrderEntity);

        return R.ok();
    }


    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        MeishiOrderEntity  meishiOrderEntity = meishiOrderService.selectById(id);
        meishiOrderEntity.setMeishiOrderTypes(104);//设置订单状态为收货
        meishiOrderService.updateById( meishiOrderEntity);
        return R.ok();
    }

}

