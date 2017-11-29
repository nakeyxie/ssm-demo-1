package com.zhou.ssm.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhou.ssm.dao.ArticleDao;
import com.zhou.ssm.entity.Article;
import com.zhou.ssm.service.ArticleService;


@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleDao articleDao;

    public List<Article> findArticle(Map<String, Object> map) {
        return articleDao.findArticles(map);
    }

    public Long getTotalArticle(Map<String, Object> map) {
        return articleDao.getTotalArticles(map);
    }

    public int addArticle(Article article) {
        
        return articleDao.insertArticle(article);
    }

    public int updateArticle(Article article) {
        
        return articleDao.updArticle(article);
    }

    public int deleteArticle(String id) {
        return articleDao.delArticle(id);
    }

    public Article findById(String id) {
        return articleDao.getArticleById(id);
    }

}
