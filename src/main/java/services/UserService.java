package services;

import domains.*;
import repositories.UserRepositoryDAO;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class UserService {
    UserRepositoryDAO userRepositoryDAO = UserRepositoryDAO.getInstance();

    public User signUpUser(String userName, String nationalCode, String birthDay,
                           String country, String city, String street, String zipCode) {
        User user = new User();
        user.setUsername(userName);
        user.setNationalCode(nationalCode);
        user.setPassword(nationalCode);
        user.setBirthDay(birthDay);
        Role role = new Role();
        role.setTitle("writer");
        user.setRole(role);
        Address address = new Address();
        address.setCountry(country);
        address.setCity(city);
        address.setStreet(street);
        address.setZipCode(zipCode);
        user.setAddress(address);
        return userRepositoryDAO.save(user);
    }

    public long selectByUserNameAndPassword(String userName, String password) {
        List<User> userList = userRepositoryDAO.selectAll();
        long id = 0L;
        if (userList.size() > 0)
        {
            for (User item : userList)
            {
                if (item.getUsername().equals(userName) && item.getPassword().equals(password))
                {
                    System.out.println("welcome");
                    id = item.getId();
                }
            }
        }
        return id;
    }




    public void selectAllUsers() {
        List<User> userList = userRepositoryDAO.selectAll();
        for (User item : userList) {
            System.out.println("userId: " + item.getId());
            System.out.println("username: " + item.getUsername());
            System.out.println("Role: " + item.getRole().getTitle());
            System.out.println("-----------------");
        }
    }

    public void selectArticleByUserId(long userId) {
        User user = userRepositoryDAO.selectById(userId);
        List<Article> articleList = user.getArticleList();
        for (Article item : articleList) {
            System.out.println("Category: " + item.getCategory().getTitle());
            System.out.println("Id: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Brief: " + item.getBrief());
            System.out.println("Content: " + item.getContent());
            System.out.println("CreateDate: " + item.getCreateDate());
            System.out.println("LastUpdateDate: " + item.getLastUpdateDate());
            System.out.println("is published: " + item.getPublished());

            System.out.println("PublishDate: " + item.getPublishDate());

            List<Tag> listTag = item.getTagList();
            if (listTag.size() > 0) {
                for (Tag t : listTag) {
                    System.out.println("Tag Id: " + t.getId());
                    System.out.println("Tag Title: " + t.getTitle());
                    System.out.println("##############");
                }
            }
            System.out.println("-------------------------");
        }
    }

    public void editPassword(long userId, String newPassword) {
        User user = userRepositoryDAO.selectById(userId);
        if (user != null) {
            user.setPassword(newPassword);
            userRepositoryDAO.update(user);
            System.out.println("Done, your new password is : " + newPassword);
        } else System.out.println("this user not exist");
    }

    public User selectUserById(long userId) {
        return userRepositoryDAO.selectById(userId);
    }

    public void changeRole(long userId, String newRoleTitle) {
        User user = userRepositoryDAO.selectById(userId);
        if (user != null) {
            Role role = new Role();
            role.setTitle(newRoleTitle);
            user.setRole(role);
            System.out.println("Done, " + user.getUsername() + " now is a admin");
        } else System.out.println("this id user not exist");
    }
}
