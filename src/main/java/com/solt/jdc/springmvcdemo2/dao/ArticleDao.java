package com.solt.jdc.springmvcdemo2.dao;

import com.solt.jdc.springmvcdemo2.model.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends CrudRepository<Article,Integer> {
}
