package services;

import domains.Article;
import domains.Tag;
import repositories.ArticleRepositoryDAO;
import repositories.TagRepositoryDAO;

import java.util.ArrayList;
import java.util.List;

public class TagService {
    ArticleRepositoryDAO articleRepositoryDAO = ArticleRepositoryDAO.getInstance();
    TagRepositoryDAO tagRepositoryDAO = TagRepositoryDAO.getInstance();


    public void tagOnArticle(long articleId,String tagOnArticle){
        Article article = articleRepositoryDAO.selectById(articleId);
        if (article!=null)
        {
            Tag tag = new Tag();
            tag.setTitle(tagOnArticle);
            tag.setArticle(article);
            tagRepositoryDAO.save(tag);
        }

    }
}
