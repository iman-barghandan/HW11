package repositories;

import domains.Article;
import domains.User;

import javax.persistence.Query;
import java.util.List;


public class UserRepositoryDAO extends BaseRepositoryDAO<User, Long> {
    private static UserRepositoryDAO userRepositoryDAO;

    private UserRepositoryDAO() {
    }

    public static UserRepositoryDAO getInstance() {
        if (userRepositoryDAO == null) {
            userRepositoryDAO = new UserRepositoryDAO();
        }
        return userRepositoryDAO;
    }

    public long selectByUserNameAndPassword(String userName , String password)
    {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select entity from User entity where entity.username=:userName and entity.password=:password");
        query.setParameter("userName",userName);
        query.setParameter("password",password);
        List<User> userList = query.getResultList();
        long id=0L;
        if (userList.size()>0)
        {
            System.out.println("khoooooooooob");
            id = userList.get(0).getId();
        }
        else {
            System.out.println("noooooo");
        }

        entityManager.getTransaction().commit();
        return id;
    }

    @Override
    protected Class<User> getEntityClass() {
        return User.class;
    }
}
