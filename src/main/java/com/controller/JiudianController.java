
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
 * 酒店
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiudian")
public class JiudianController {
    private static final Logger logger = LoggerFactory.getLogger(JiudianController.class);

    private static final String TABLE_NAME = "jiudian";

    @Autowired
    private JiudianService jiudianService;


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
        params.put("jiudianDeleteStart",1);params.put("jiudianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiudianService.queryPage(params);

        //字典表数据转换
        List<JiudianView> list =(List<JiudianView>)page.getList();
        for(JiudianView c:list){
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
        JiudianEntity jiudian = jiudianService.selectById(id);
        if(jiudian !=null){
            //entity转view
            JiudianView view = new JiudianView();
            BeanUtils.copyProperties( jiudian , view );//把实体数据重构到view中
            //级联表 商家
            //级联表
            ShangjiaEntity shangjia = shangjiaService.selectById(jiudian.getShangjiaId());
            if(shangjia != null){
            BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "shangjiaId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setShangjiaId(shangjia.getId());
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
    public R save(@RequestBody JiudianEntity jiudian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiudian:{}",this.getClass().getName(),jiudian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("商家".equals(role))
            jiudian.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiudianEntity> queryWrapper = new EntityWrapper<JiudianEntity>()
            .eq("shangjia_id", jiudian.getShangjiaId())
            .eq("jiudian_name", jiudian.getJiudianName())
            .eq("jiudian_address", jiudian.getJiudianAddress())
            .eq("jiudian_tese", jiudian.getJiudianTese())
            .eq("zan_number", jiudian.getZanNumber())
            .eq("cai_number", jiudian.getCaiNumber())
            .eq("jiudian_types", jiudian.getJiudianTypes())
            .eq("jiudian_kucun_number", jiudian.getJiudianKucunNumber())
            .eq("shangxia_types", jiudian.getShangxiaTypes())
            .eq("jiudian_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiudianEntity jiudianEntity = jiudianService.selectOne(queryWrapper);
        if(jiudianEntity==null){
            jiudian.setZanNumber(1);
            jiudian.setCaiNumber(1);
            jiudian.setJiudianClicknum(1);
            jiudian.setShangxiaTypes(1);
            jiudian.setJiudianDelete(1);
            jiudian.setInsertTime(new Date());
            jiudian.setCreateTime(new Date());
            jiudianService.insert(jiudian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiudianEntity jiudian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiudian:{}",this.getClass().getName(),jiudian.toString());
        JiudianEntity oldJiudianEntity = jiudianService.selectById(jiudian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("商家".equals(role))
//            jiudian.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiudian.getJiudianPhoto()) || "null".equals(jiudian.getJiudianPhoto())){
                jiudian.setJiudianPhoto(null);
        }
        if("".equals(jiudian.getJiudianContent()) || "null".equals(jiudian.getJiudianContent())){
                jiudian.setJiudianContent(null);
        }

            jiudianService.updateById(jiudian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiudianEntity> oldJiudianList =jiudianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiudianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiudianEntity jiudianEntity = new JiudianEntity();
            jiudianEntity.setId(id);
            jiudianEntity.setJiudianDelete(2);
            list.add(jiudianEntity);
        }
        if(list != null && list.size() >0){
            jiudianService.updateBatchById(list);
        }

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
            List<JiudianEntity> jiudianList = new ArrayList<>();//上传的东西
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
                            JiudianEntity jiudianEntity = new JiudianEntity();
//                            jiudianEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //商家 要改的
//                            jiudianEntity.setJiudianName(data.get(0));                    //房间名称 要改的
//                            jiudianEntity.setJiudianUuidNumber(data.get(0));                    //房间编号 要改的
//                            jiudianEntity.setJiudianPhoto("");//详情和图片
//                            jiudianEntity.setJiudianAddress(data.get(0));                    //酒店位置 要改的
//                            jiudianEntity.setJiudianTese(data.get(0));                    //特色 要改的
//                            jiudianEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jiudianEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jiudianEntity.setJiudianTypes(Integer.valueOf(data.get(0)));   //房型 要改的
//                            jiudianEntity.setJiudianKucunNumber(Integer.valueOf(data.get(0)));   //剩余房间数 要改的
//                            jiudianEntity.setJiudianOldMoney(data.get(0));                    //房间原价 要改的
//                            jiudianEntity.setJiudianNewMoney(data.get(0));                    //现价/天 要改的
//                            jiudianEntity.setJiudianClicknum(Integer.valueOf(data.get(0)));   //房间热度 要改的
//                            jiudianEntity.setJiudianContent("");//详情和图片
//                            jiudianEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jiudianEntity.setJiudianDelete(1);//逻辑删除字段
//                            jiudianEntity.setInsertTime(date);//时间
//                            jiudianEntity.setCreateTime(date);//时间
                            jiudianList.add(jiudianEntity);


                            //把要查询是否重复的字段放入map中
                                //房间编号
                                if(seachFields.containsKey("jiudianUuidNumber")){
                                    List<String> jiudianUuidNumber = seachFields.get("jiudianUuidNumber");
                                    jiudianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiudianUuidNumber = new ArrayList<>();
                                    jiudianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiudianUuidNumber",jiudianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //房间编号
                        List<JiudianEntity> jiudianEntities_jiudianUuidNumber = jiudianService.selectList(new EntityWrapper<JiudianEntity>().in("jiudian_uuid_number", seachFields.get("jiudianUuidNumber")).eq("jiudian_delete", 1));
                        if(jiudianEntities_jiudianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiudianEntity s:jiudianEntities_jiudianUuidNumber){
                                repeatFields.add(s.getJiudianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [房间编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiudianService.insertBatch(jiudianList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<JiudianView> returnJiudianViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("jiudianYesnoTypes",2);
        PageUtils pageUtils = jiudianOrderService.queryPage(params1);
        List<JiudianOrderView> orderViewsList =(List<JiudianOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JiudianOrderView orderView:orderViewsList){
            Integer jiudianTypes = orderView.getJiudianTypes();
            if(typeMap.containsKey(jiudianTypes)){
                typeMap.put(jiudianTypes,typeMap.get(jiudianTypes)+1);
            }else{
                typeMap.put(jiudianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jiudianTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("jiudianYesnoTypes",2);
            PageUtils pageUtils1 = jiudianService.queryPage(params2);
            List<JiudianView> jiudianViewList =(List<JiudianView>)pageUtils1.getList();
            returnJiudianViewList.addAll(jiudianViewList);
            if(returnJiudianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("jiudianYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jiudianService.queryPage(params);
        if(returnJiudianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJiudianViewList.size();//要添加的数量
            List<JiudianView> jiudianViewList =(List<JiudianView>)page.getList();
            for(JiudianView jiudianView:jiudianViewList){
                Boolean addFlag = true;
                for(JiudianView returnJiudianView:returnJiudianViewList){
                    if(returnJiudianView.getId().intValue() ==jiudianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJiudianViewList.add(jiudianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJiudianViewList = returnJiudianViewList.subList(0, limit);
        }

        for(JiudianView c:returnJiudianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJiudianViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiudianService.queryPage(params);

        //字典表数据转换
        List<JiudianView> list =(List<JiudianView>)page.getList();
        for(JiudianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiudianEntity jiudian = jiudianService.selectById(id);
            if(jiudian !=null){

                //点击数量加1
                jiudian.setJiudianClicknum(jiudian.getJiudianClicknum()+1);
                jiudianService.updateById(jiudian);

                //entity转view
                JiudianView view = new JiudianView();
                BeanUtils.copyProperties( jiudian , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(jiudian.getShangjiaId());
                if(shangjia != null){
                    BeanUtils.copyProperties( shangjia , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "shangjiaId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangjiaId(shangjia.getId());
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
    public R add(@RequestBody JiudianEntity jiudian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiudian:{}",this.getClass().getName(),jiudian.toString());
        Wrapper<JiudianEntity> queryWrapper = new EntityWrapper<JiudianEntity>()
            .eq("shangjia_id", jiudian.getShangjiaId())
            .eq("jiudian_name", jiudian.getJiudianName())
            .eq("jiudian_uuid_number", jiudian.getJiudianUuidNumber())
            .eq("jiudian_address", jiudian.getJiudianAddress())
            .eq("jiudian_tese", jiudian.getJiudianTese())
            .eq("zan_number", jiudian.getZanNumber())
            .eq("cai_number", jiudian.getCaiNumber())
            .eq("jiudian_types", jiudian.getJiudianTypes())
            .eq("jiudian_kucun_number", jiudian.getJiudianKucunNumber())
            .eq("jiudian_clicknum", jiudian.getJiudianClicknum())
            .eq("shangxia_types", jiudian.getShangxiaTypes())
            .eq("jiudian_delete", jiudian.getJiudianDelete())
//            .notIn("jiudian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiudianEntity jiudianEntity = jiudianService.selectOne(queryWrapper);
        if(jiudianEntity==null){
                jiudian.setZanNumber(1);
                jiudian.setCaiNumber(1);
            jiudian.setJiudianClicknum(1);
            jiudian.setJiudianDelete(1);
            jiudian.setInsertTime(new Date());
            jiudian.setCreateTime(new Date());
        jiudianService.insert(jiudian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

