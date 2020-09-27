package repositories;

import domains.User;

public class UserRepositoryDAO extends BaseRepositoryDAO<User,Long> {
    private static UserRepositoryDAO userRepositoryDAO;
    private UserRepositoryDAO(){}

    public static UserRepositoryDAO getInstance(){
        if (userRepositoryDAO==null){
            userRepositoryDAO = new UserRepositoryDAO();
        }
        return userRepositoryDAO;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
