
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
 * 景点门票订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingdianOrder")
public class JingdianOrderController {
    private static final Logger logger = LoggerFactory.getLogger(JingdianOrderController.class);

    private static final String TABLE_NAME = "jingdianOrder";

    @Autowired
    private JingdianOrderService jingdianOrderService;


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
    private MeishiOrderService meishiOrderService;//美食订单
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
        PageUtils page = jingdianOrderService.queryPage(params);

        //字典表数据转换
        List<JingdianOrderView> list =(List<JingdianOrderView>)page.getList();
        for(JingdianOrderView c:list){
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
        JingdianOrderEntity jingdianOrder = jingdianOrderService.selectById(id);
        if(jingdianOrder !=null){
            //entity转view
            JingdianOrderView view = new JingdianOrderView();
            BeanUtils.copyProperties( jingdianOrder , view );//把实体数据重构到view中
            //级联表 景点
            //级联表
            JingdianEntity jingdian = jingdianService.selectById(jingdianOrder.getJingdianId());
            if(jingdian != null){
            BeanUtils.copyProperties( jingdian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJingdianId(jingdian.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jingdianOrder.getYonghuId());
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
    public R save(@RequestBody JingdianOrderEntity jingdianOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingdianOrder:{}",this.getClass().getName(),jingdianOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jingdianOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        jingdianOrder.setCreateTime(new Date());
        jingdianOrder.setInsertTime(new Date());
        jingdianOrderService.insert(jingdianOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingdianOrderEntity jingdianOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingdianOrder:{}",this.getClass().getName(),jingdianOrder.toString());
        JingdianOrderEntity oldJingdianOrderEntity = jingdianOrderService.selectById(jingdianOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jingdianOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jingdianOrderService.updateById(jingdianOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingdianOrderEntity> oldJingdianOrderList =jingdianOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jingdianOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<JingdianOrderEntity> jingdianOrderList = new ArrayList<>();//上传的东西
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
                            JingdianOrderEntity jingdianOrderEntity = new JingdianOrderEntity();
//                            jingdianOrderEntity.setJingdianOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            jingdianOrderEntity.setJingdianId(Integer.valueOf(data.get(0)));   //景点 要改的
//                            jingdianOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jingdianOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买张数 要改的
//                            jingdianOrderEntity.setJingdianOrderTime(sdf.parse(data.get(0)));          //预定日期 要改的
//                            jingdianOrderEntity.setJingdianOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            jingdianOrderEntity.setJingdianOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            jingdianOrderEntity.setJingdianOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            jingdianOrderEntity.setInsertTime(date);//时间
//                            jingdianOrderEntity.setCreateTime(date);//时间
                            jingdianOrderList.add(jingdianOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("jingdianOrderUuidNumber")){
                                    List<String> jingdianOrderUuidNumber = seachFields.get("jingdianOrderUuidNumber");
                                    jingdianOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingdianOrderUuidNumber = new ArrayList<>();
                                    jingdianOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingdianOrderUuidNumber",jingdianOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<JingdianOrderEntity> jingdianOrderEntities_jingdianOrderUuidNumber = jingdianOrderService.selectList(new EntityWrapper<JingdianOrderEntity>().in("jingdian_order_uuid_number", seachFields.get("jingdianOrderUuidNumber")));
                        if(jingdianOrderEntities_jingdianOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingdianOrderEntity s:jingdianOrderEntities_jingdianOrderUuidNumber){
                                repeatFields.add(s.getJingdianOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingdianOrderService.insertBatch(jingdianOrderList);
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
        PageUtils page = jingdianOrderService.queryPage(params);

        //字典表数据转换
        List<JingdianOrderView> list =(List<JingdianOrderView>)page.getList();
        for(JingdianOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingdianOrderEntity jingdianOrder = jingdianOrderService.selectById(id);
            if(jingdianOrder !=null){


                //entity转view
                JingdianOrderView view = new JingdianOrderView();
                BeanUtils.copyProperties( jingdianOrder , view );//把实体数据重构到view中

                //级联表
                    JingdianEntity jingdian = jingdianService.selectById(jingdianOrder.getJingdianId());
                if(jingdian != null){
                    BeanUtils.copyProperties( jingdian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJingdianId(jingdian.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jingdianOrder.getYonghuId());
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
    public R add(@RequestBody JingdianOrderEntity jingdianOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jingdianOrder:{}",this.getClass().getName(),jingdianOrder.toString());
            JingdianEntity jingdianEntity = jingdianService.selectById(jingdianOrder.getJingdianId());
            if(jingdianEntity == null){
                return R.error(511,"查不到该景点");
            }
            // Double jingdianNewMoney = jingdianEntity.getJingdianNewMoney();

            if(false){
            }
            else if(jingdianEntity.getJingdianNewMoney() == null){
                return R.error(511,"现价/张不能为空");
            }
            else if((jingdianEntity.getJingdianKucunNumber() -1)<0){
                return R.error(511,"房间数量不够此次预定");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - jingdianEntity.getJingdianNewMoney()*jingdianOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            jingdianOrder.setJingdianOrderTypes(101); //设置订单状态为已购买门票
            jingdianOrder.setJingdianOrderTruePrice(jingdianEntity.getJingdianNewMoney()*jingdianOrder.getBuyNumber()); //设置实付价格
            jingdianOrder.setYonghuId(userId); //设置订单支付人id
            jingdianOrder.setJingdianOrderUuidNumber(String.valueOf(new Date().getTime()));
            jingdianOrder.setJingdianOrderPaymentTypes(1);
            jingdianOrder.setInsertTime(new Date());
            jingdianOrder.setCreateTime(new Date());
                jingdianEntity.setJingdianKucunNumber( jingdianEntity.getJingdianKucunNumber() -jingdianOrder.getBuyNumber());
                jingdianService.updateById(jingdianEntity);
                jingdianOrderService.insert(jingdianOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);

            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(jingdianEntity.getShangjiaId());
            shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney()+jingdianOrder.getJingdianOrderTruePrice());//动态计算金额
            shangjiaService.updateById(shangjiaEntity);

            return R.ok();
    }


    /**
    * 取消购买
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            JingdianOrderEntity jingdianOrder = jingdianOrderService.selectById(id);//当前表service
            Integer buyNumber = jingdianOrder.getBuyNumber();
            Integer jingdianOrderPaymentTypes = jingdianOrder.getJingdianOrderPaymentTypes();
            Integer jingdianId = jingdianOrder.getJingdianId();
            if(jingdianId == null)
                return R.error(511,"查不到该景点");
            JingdianEntity jingdianEntity = jingdianService.selectById(jingdianId);
            if(jingdianEntity == null)
                return R.error(511,"查不到该景点");
            //获取商家信息
            Integer shangjiaId = jingdianEntity.getShangjiaId();
            ShangjiaEntity shangjiaEntity = shangjiaService.selectById(shangjiaId);//商家
            Double jingdianNewMoney = jingdianEntity.getJingdianNewMoney();
            if(jingdianNewMoney == null)
                return R.error(511,"景点价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

            //判断是什么支付方式 1代表余额 2代表积分
            if(jingdianOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = jingdianEntity.getJingdianNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


                //修改商家余额
                shangjiaEntity.setNewMoney(shangjiaEntity.getNewMoney() - money);
            }

            jingdianEntity.setJingdianKucunNumber(jingdianEntity.getJingdianKucunNumber() + 1);

            jingdianOrder.setJingdianOrderTypes(102);//设置订单状态为已取消购买
            jingdianOrderService.updateAllColumnById(jingdianOrder);//根据id更新
            shangjiaService.updateById(shangjiaEntity);
            yonghuService.updateById(yonghuEntity);//更新用户信息
            jingdianService.updateById(jingdianEntity);//更新订单中景点的信息

            return R.ok();
    }

    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer jingdianCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            JingdianOrderEntity jingdianOrder = jingdianOrderService.selectById(id);
        if(jingdianOrder == null)
            return R.error(511,"查不到该订单");
        Integer jingdianId = jingdianOrder.getJingdianId();
        if(jingdianId == null)
            return R.error(511,"查不到该景点");

        JingdianCommentbackEntity jingdianCommentbackEntity = new JingdianCommentbackEntity();
            jingdianCommentbackEntity.setId(id);
            jingdianCommentbackEntity.setJingdianId(jingdianId);
            jingdianCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            jingdianCommentbackEntity.setJingdianCommentbackText(commentbackText);
            jingdianCommentbackEntity.setInsertTime(new Date());
            jingdianCommentbackEntity.setReplyText(null);
            jingdianCommentbackEntity.setUpdateTime(null);
            jingdianCommentbackEntity.setCreateTime(new Date());
            jingdianCommentbackService.insert(jingdianCommentbackEntity);

            jingdianOrder.setJingdianOrderTypes(105);//设置订单状态为已评价
            jingdianOrderService.updateById(jingdianOrder);//根据id更新
            return R.ok();
    }

    /**
     * 检票
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        JingdianOrderEntity  jingdianOrderEntity = jingdianOrderService.selectById(id);
        jingdianOrderEntity.setJingdianOrderTypes(103);//设置订单状态为已检票
        jingdianOrderService.updateById( jingdianOrderEntity);

        return R.ok();
    }


}

