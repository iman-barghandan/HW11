package services;

import domains.Article;
import domains.Category;
import domains.Tag;
import domains.User;
import repositories.ArticleRepositoryDAO;
import repositories.CategotyRepositoryDAO;
import repositories.UserRepositoryDAO;

import java.util.Date;
import java.util.List;

public class ArticleService {
    ArticleRepositoryDAO articleRepositoryDAO = ArticleRepositoryDAO.getInstance();
    CategotyRepositoryDAO categotyRepositoryDAO = CategotyRepositoryDAO.getInstance();
    UserRepositoryDAO userRepositoryDAO = UserRepositoryDAO.getInstance();

    public void selectArticles() {
        List<Article> articleList = articleRepositoryDAO.selectAll();
        if (articleList.size() > 0) {
            for (Article item : articleList) {
                if (item.getPublished()) {
                    System.out.println("Id: " + item.getId());
                    System.out.println("Title: " + item.getTitle());
                    System.out.println("Brief: " + item.getBrief());
                    System.out.println("--------------");
                }
            }
        } else System.out.println("No article has been published yet");
    }


    public void selectPublishedAndUnpublishedArticle() {
        List<Article> articleList = articleRepositoryDAO.selectAll();
        if (articleList.size() > 0) {
            for (Article item : articleList) {
                System.out.println("Category: " + item.getCategory().getTitle());
                System.out.println("Id: " + item.getId());
                System.out.println("Title: " + item.getTitle());
                System.out.println("Brief: " + item.getBrief());
                System.out.println("Publish State: " + item.getPublished());
                System.out.println("PublishDate: " + item.getPublishDate());
                System.out.println("--------------");
            }
        } else System.out.println("No article has been published yet");

    }

    public void selectById(long id) {
        Article article = articleRepositoryDAO.selectById(id);
        if (article != null && article.getPublished()) {
            System.out.println("Category: " + article.getCategory().getTitle());
            System.out.println("Id: " + article.getId());
            System.out.println("Title: " + article.getTitle());
            System.out.println("Brief: " + article.getBrief());
            System.out.println("Content: " + article.getContent());
            System.out.println("CreateDate: " + article.getCreateDate());

            System.out.println("PublishDate: " + article.getPublishDate());
            System.out.println("LastUpdateDate: " + article.getLastUpdateDate());

            System.out.println("Writer: " + article.getUser().getUsername());
            List<Tag> listTag = article.getTagList();
            if (listTag.size() > 0) {
                for (Tag item : listTag) {
                    System.out.println("Tag Id: " + item.getId());
                    System.out.println("Tag Title: " + item.getTitle());
                    System.out.println("####################");
                }
            }

        } else System.out.println("You do not have access to this article");
    }

    public void insertArticle(String title, String brief, String content, long categoryId, long userId) {
        Article article = new Article();
        article.setTitle(title);
        article.setBrief(brief);
        article.setContent(content);
        article.setCreateDate(new Date());
        article.setPublished(false);
        Category category = categotyRepositoryDAO.selectById(categoryId);
        if (category != null) {
            article.setCategory(category);
            article.setLastUpdateDate(new Date());
            User user = userRepositoryDAO.selectById(userId);
            article.setUser(user);
            articleRepositoryDAO.save(article);
        } else System.out.println("this category is not exist!");
    }

    public void editArticle(long userId, long articleId, String newTitle, String newBrief, String newContent) {
        Article article = articleRepositoryDAO.selectById(articleId);
        if (article != null && article.getUser().getId() == userId) {
            article.setTitle(newTitle);
            article.setBrief(newBrief);
            article.setContent(newContent);
            article.setLastUpdateDate(new Date());
            articleRepositoryDAO.update(article);
        } else System.out.println("you can not edit this article");
    }

    public void changePublishedArticle(long articleId) {
        Article article = articleRepositoryDAO.selectById(articleId);
        if (article != null) {
            if (article.getPublished()) {
                article.setPublished(false);
            } else {
                article.setPublished(true);
            }
            article.setPublishDate(new Date());
            articleRepositoryDAO.update(article);
            System.out.println("Done! " + article.getTitle() + " changed publish");
        } else System.out.println("this article id is not exist");
    }

    public void deleteArticleById(long articleId) {
        articleRepositoryDAO.removeById(articleId);
    }
}
