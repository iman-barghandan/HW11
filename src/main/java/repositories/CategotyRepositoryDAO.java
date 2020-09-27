package repositories;

import domains.Category;

public class CategotyRepositoryDAO extends BaseRepositoryDAO<Category, Long> {

    private static CategotyRepositoryDAO categotyRepositoryDAO;

    private CategotyRepositoryDAO() {
    }

    public static CategotyRepositoryDAO getInstance() {
        if (categotyRepositoryDAO == null) {
            categotyRepositoryDAO = new CategotyRepositoryDAO();
        }
        return categotyRepositoryDAO;
    }

    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }
}
