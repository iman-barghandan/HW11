package services;

import domains.Article;
import domains.Tag;
import repositories.ArticleRepositoryDAO;
import repositories.CategotyRepositoryDAO;
import repositories.UserRepositoryDAO;

import java.util.Date;
import java.util.List;

public class ArticleService {
    ArticleRepositoryDAO articleRepositoryDAO = ArticleRepositoryDAO.getInstance();

    public void selectArticles()
    {
        List<Article> articleList = articleRepositoryDAO.selectAll();
        if (articleList.size()>0)
        {
            for (Article item : articleList)
            {
                if (item.getPublished())
                {
                    System.out.println("Id: " + item.getId());
                    System.out.println("Title: " + item.getTitle());
                    System.out.println("Brief: " +item.getBrief());
                    System.out.println("--------------");
                }
            }
        }
    }

    public void selectById(long id)
    {
        Article article = articleRepositoryDAO.selectById(id);
        if (article.getPublished())
        {
            System.out.println("Category: " + article.getCategory().getTitle());
            System.out.println("Id: " + article.getId());
            System.out.println("Title: " + article.getTitle());
            System.out.println("Brief: " + article.getBrief());
            System.out.println("Content: " +article.getContent());
            System.out.println("CreateDate: " + article.getCreateDate());
            System.out.println("PublishDate: " + article.getPublishDate());
            System.out.println("LastUpdateDate: "+ article.getLastUpdateDate());
            System.out.println("Writer: " + article.getUser().getUsername());
            List<Tag> listTag =  article.getTagList();
            for (Tag item : listTag)
            {
                System.out.println("Tag Id: " + item.getId());
                System.out.println("Tag Title: " + item.getTitle());
            }

        }
    }

//    public void insertArticle(String title,String brief,String content)
//    {
//        Article article = new Article();
//        article.setTitle(title);
//        article.setBrief(brief);
//        article.setContent(content);
//        article.setCreateDate(new Date());
//        article.setPublished(false);
//        articleRepositoryDAO.save(article);
//    }


}
