package com.dizewei.cms.dao;

import java.util.List;

import com.dizewei.cms.pojo.Article;

public interface ArticleDao extends BaseDao<Article>{
	
	List<Article> selectIsHot();
	
}
