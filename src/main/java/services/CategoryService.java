package services;

import domains.Article;
import domains.Category;
import repositories.CategotyRepositoryDAO;

import java.util.List;

public class CategoryService {
    CategotyRepositoryDAO categotyRepositoryDAO = CategotyRepositoryDAO.getInstance();

    public int selectCategories() {
        List<Category> categoryList = categotyRepositoryDAO.selectAll();
        if (categoryList.size() > 0) {
            for (Category item : categoryList) {

                System.out.println("Category Id: " + item.getId());
                System.out.println("Title: " + item.getTitle());
                System.out.println("Description: " + item.getDescription());
                System.out.println("--------------");

            }
        } else System.out.println("No categories created yet");
        return categoryList.size();
    }


    public void insertCategory(String title, String description) {
        Category category = new Category();
        category.setTitle(title);
        category.setDescription(description);
        categotyRepositoryDAO.save(category);
    }
}
