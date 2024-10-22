package com.dao;

import com.entity.MeishiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishiCommentbackView;

/**
 * 美食评价 Dao 接口
 *
 * @author 
 */
public interface MeishiCommentbackDao extends BaseMapper<MeishiCommentbackEntity> {

   List<MeishiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
