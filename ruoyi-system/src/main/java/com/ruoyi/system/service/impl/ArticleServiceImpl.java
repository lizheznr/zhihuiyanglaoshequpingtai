package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ArticleMapper;
import com.ruoyi.system.domain.Article;
import com.ruoyi.system.service.IArticleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章信息Service业务层处理
 * 
 * @author 谢浩东
 * @date 2021-02-08
 */
@Service
public class ArticleServiceImpl implements IArticleService 
{
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询文章信息
     * 
     * @param articleId 文章信息ID
     * @return 文章信息
     */
    @Override
    public Article selectArticleById(Long articleId)
    {
        return articleMapper.selectArticleById(articleId);
    }

    /**
     * 查询文章信息列表
     * 
     * @param article 文章信息
     * @return 文章信息
     */
    @Override
    public List<Article> selectArticleList(Article article)
    {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增文章信息
     * 
     * @param article 文章信息
     * @return 结果
     */
    @Override
    public int insertArticle(Article article)
    {
        return articleMapper.insertArticle(article);
    }

    /**
     * 修改文章信息
     * 
     * @param article 文章信息
     * @return 结果
     */
    @Override
    public int updateArticle(Article article)
    {
        return articleMapper.updateArticle(article);
    }

    /**
     * 删除文章信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(String ids)
    {
        return articleMapper.deleteArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章信息信息
     * 
     * @param articleId 文章信息ID
     * @return 结果
     */
    @Override
    public int deleteArticleById(Long articleId)
    {
        return articleMapper.deleteArticleById(articleId);
    }
}
