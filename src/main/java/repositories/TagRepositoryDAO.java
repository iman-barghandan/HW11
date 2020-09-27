package repositories;

import domains.Tag;

public class TagRepositoryDAO extends BaseRepositoryDAO<Tag, Long> {
    private static TagRepositoryDAO tagRepositoryDAO;

    private TagRepositoryDAO() {
    }

    public static TagRepositoryDAO getInstance() {
        if (tagRepositoryDAO == null) {
            tagRepositoryDAO = new TagRepositoryDAO();
        }
        return tagRepositoryDAO;
    }

    @Override
    protected Class<Tag> getEntityClass() {
        return Tag.class;
    }
}
