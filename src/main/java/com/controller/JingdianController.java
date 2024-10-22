
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
 * 景点
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingdian")
public class JingdianController {
    private static final Logger logger = LoggerFactory.getLogger(JingdianController.class);

    private static final String TABLE_NAME = "jingdian";

    @Autowired
    private JingdianService jingdianService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private AddressService addressService;//收货地址
    @Autowired
    private DictionaryService dictionaryService;//字典表
    @Autowired
    private GonggaoService gonggaoService;//公告信息
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
        params.put("jingdianDeleteStart",1);params.put("jingdianDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jingdianService.queryPage(params);

        //字典表数据转换
        List<JingdianView> list =(List<JingdianView>)page.getList();
        for(JingdianView c:list){
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
        JingdianEntity jingdian = jingdianService.selectById(id);
        if(jingdian !=null){
            //entity转view
            JingdianView view = new JingdianView();
            BeanUtils.copyProperties( jingdian , view );//把实体数据重构到view中
            //级联表 商家
            //级联表
            ShangjiaEntity shangjia = shangjiaService.selectById(jingdian.getShangjiaId());
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
    public R save(@RequestBody JingdianEntity jingdian, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingdian:{}",this.getClass().getName(),jingdian.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("商家".equals(role))
            jingdian.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JingdianEntity> queryWrapper = new EntityWrapper<JingdianEntity>()
            .eq("shangjia_id", jingdian.getShangjiaId())
            .eq("jingdian_name", jingdian.getJingdianName())
            .eq("jingdian_video", jingdian.getJingdianVideo())
            .eq("jingdian_address", jingdian.getJingdianAddress())
            .eq("zan_number", jingdian.getZanNumber())
            .eq("cai_number", jingdian.getCaiNumber())
            .eq("jingdian_types", jingdian.getJingdianTypes())
            .eq("jingdian_kucun_number", jingdian.getJingdianKucunNumber())
            .eq("shangxia_types", jingdian.getShangxiaTypes())
            .eq("jingdian_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingdianEntity jingdianEntity = jingdianService.selectOne(queryWrapper);
        if(jingdianEntity==null){
            jingdian.setZanNumber(1);
            jingdian.setCaiNumber(1);
            jingdian.setJingdianClicknum(1);
            jingdian.setShangxiaTypes(1);
            jingdian.setJingdianDelete(1);
            jingdian.setInsertTime(new Date());
            jingdian.setCreateTime(new Date());
            jingdianService.insert(jingdian);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingdianEntity jingdian, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingdian:{}",this.getClass().getName(),jingdian.toString());
        JingdianEntity oldJingdianEntity = jingdianService.selectById(jingdian.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("商家".equals(role))
//            jingdian.setShangjiaId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jingdian.getJingdianPhoto()) || "null".equals(jingdian.getJingdianPhoto())){
                jingdian.setJingdianPhoto(null);
        }
        if("".equals(jingdian.getJingdianVideo()) || "null".equals(jingdian.getJingdianVideo())){
                jingdian.setJingdianVideo(null);
        }
        if("".equals(jingdian.getJingdianContent()) || "null".equals(jingdian.getJingdianContent())){
                jingdian.setJingdianContent(null);
        }

            jingdianService.updateById(jingdian);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingdianEntity> oldJingdianList =jingdianService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JingdianEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JingdianEntity jingdianEntity = new JingdianEntity();
            jingdianEntity.setId(id);
            jingdianEntity.setJingdianDelete(2);
            list.add(jingdianEntity);
        }
        if(list != null && list.size() >0){
            jingdianService.updateBatchById(list);
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
            List<JingdianEntity> jingdianList = new ArrayList<>();//上传的东西
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
                            JingdianEntity jingdianEntity = new JingdianEntity();
//                            jingdianEntity.setShangjiaId(Integer.valueOf(data.get(0)));   //商家 要改的
//                            jingdianEntity.setJingdianName(data.get(0));                    //景点名称 要改的
//                            jingdianEntity.setJingdianUuidNumber(data.get(0));                    //景点编号 要改的
//                            jingdianEntity.setJingdianPhoto("");//详情和图片
//                            jingdianEntity.setJingdianVideo(data.get(0));                    //视频介绍 要改的
//                            jingdianEntity.setJingdianAddress(data.get(0));                    //景点位置 要改的
//                            jingdianEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jingdianEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jingdianEntity.setJingdianTypes(Integer.valueOf(data.get(0)));   //景点类型 要改的
//                            jingdianEntity.setJingdianKucunNumber(Integer.valueOf(data.get(0)));   //剩余门票数 要改的
//                            jingdianEntity.setJingdianOldMoney(data.get(0));                    //景点原价 要改的
//                            jingdianEntity.setJingdianNewMoney(data.get(0));                    //现价/张 要改的
//                            jingdianEntity.setJingdianClicknum(Integer.valueOf(data.get(0)));   //景点热度 要改的
//                            jingdianEntity.setJingdianContent("");//详情和图片
//                            jingdianEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jingdianEntity.setJingdianDelete(1);//逻辑删除字段
//                            jingdianEntity.setInsertTime(date);//时间
//                            jingdianEntity.setCreateTime(date);//时间
                            jingdianList.add(jingdianEntity);


                            //把要查询是否重复的字段放入map中
                                //景点编号
                                if(seachFields.containsKey("jingdianUuidNumber")){
                                    List<String> jingdianUuidNumber = seachFields.get("jingdianUuidNumber");
                                    jingdianUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingdianUuidNumber = new ArrayList<>();
                                    jingdianUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingdianUuidNumber",jingdianUuidNumber);
                                }
                        }

                        //查询是否重复
                         //景点编号
                        List<JingdianEntity> jingdianEntities_jingdianUuidNumber = jingdianService.selectList(new EntityWrapper<JingdianEntity>().in("jingdian_uuid_number", seachFields.get("jingdianUuidNumber")).eq("jingdian_delete", 1));
                        if(jingdianEntities_jingdianUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingdianEntity s:jingdianEntities_jingdianUuidNumber){
                                repeatFields.add(s.getJingdianUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [景点编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingdianService.insertBatch(jingdianList);
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
        List<JingdianView> returnJingdianViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("jingdianYesnoTypes",2);
        PageUtils pageUtils = jingdianOrderService.queryPage(params1);
        List<JingdianOrderView> orderViewsList =(List<JingdianOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(JingdianOrderView orderView:orderViewsList){
            Integer jingdianTypes = orderView.getJingdianTypes();
            if(typeMap.containsKey(jingdianTypes)){
                typeMap.put(jingdianTypes,typeMap.get(jingdianTypes)+1);
            }else{
                typeMap.put(jingdianTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("jingdianTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("jingdianYesnoTypes",2);
            PageUtils pageUtils1 = jingdianService.queryPage(params2);
            List<JingdianView> jingdianViewList =(List<JingdianView>)pageUtils1.getList();
            returnJingdianViewList.addAll(jingdianViewList);
            if(returnJingdianViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("jingdianYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = jingdianService.queryPage(params);
        if(returnJingdianViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnJingdianViewList.size();//要添加的数量
            List<JingdianView> jingdianViewList =(List<JingdianView>)page.getList();
            for(JingdianView jingdianView:jingdianViewList){
                Boolean addFlag = true;
                for(JingdianView returnJingdianView:returnJingdianViewList){
                    if(returnJingdianView.getId().intValue() ==jingdianView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnJingdianViewList.add(jingdianView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnJingdianViewList = returnJingdianViewList.subList(0, limit);
        }

        for(JingdianView c:returnJingdianViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnJingdianViewList);
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
        PageUtils page = jingdianService.queryPage(params);

        //字典表数据转换
        List<JingdianView> list =(List<JingdianView>)page.getList();
        for(JingdianView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingdianEntity jingdian = jingdianService.selectById(id);
            if(jingdian !=null){

                //点击数量加1
                jingdian.setJingdianClicknum(jingdian.getJingdianClicknum()+1);
                jingdianService.updateById(jingdian);

                //entity转view
                JingdianView view = new JingdianView();
                BeanUtils.copyProperties( jingdian , view );//把实体数据重构到view中

                //级联表
                    ShangjiaEntity shangjia = shangjiaService.selectById(jingdian.getShangjiaId());
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
    public R add(@RequestBody JingdianEntity jingdian, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jingdian:{}",this.getClass().getName(),jingdian.toString());
        Wrapper<JingdianEntity> queryWrapper = new EntityWrapper<JingdianEntity>()
            .eq("shangjia_id", jingdian.getShangjiaId())
            .eq("jingdian_name", jingdian.getJingdianName())
            .eq("jingdian_uuid_number", jingdian.getJingdianUuidNumber())
            .eq("jingdian_video", jingdian.getJingdianVideo())
            .eq("jingdian_address", jingdian.getJingdianAddress())
            .eq("zan_number", jingdian.getZanNumber())
            .eq("cai_number", jingdian.getCaiNumber())
            .eq("jingdian_types", jingdian.getJingdianTypes())
            .eq("jingdian_kucun_number", jingdian.getJingdianKucunNumber())
            .eq("jingdian_clicknum", jingdian.getJingdianClicknum())
            .eq("shangxia_types", jingdian.getShangxiaTypes())
            .eq("jingdian_delete", jingdian.getJingdianDelete())
//            .notIn("jingdian_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingdianEntity jingdianEntity = jingdianService.selectOne(queryWrapper);
        if(jingdianEntity==null){
                jingdian.setZanNumber(1);
                jingdian.setCaiNumber(1);
            jingdian.setJingdianClicknum(1);
            jingdian.setJingdianDelete(1);
            jingdian.setInsertTime(new Date());
            jingdian.setCreateTime(new Date());
        jingdianService.insert(jingdian);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

