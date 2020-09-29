package services;

import domains.*;
import repositories.UserRepositoryDAO;

import java.util.List;

public class UserService {
    UserRepositoryDAO userRepositoryDAO = UserRepositoryDAO.getInstance();

    public User signUpUser(String userName,String nationalCode,String birthDay,
                           String country,String city,String street,String zipCode)
    {
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
//        User savedUser = userRepositoryDAO.save(user);
//        return savedUser;
        return userRepositoryDAO.save(user);
    }

    public long SignInUser(String userName , String password)
    {
        return userRepositoryDAO.selectByUserNameAndPassword(userName,password);
    }

    public void selectArticleByUserId(long userId)
    {
        User user = userRepositoryDAO.selectById(userId);
        List<Article> articleList = user.getArticleList();
        for (Article item : articleList)
        {
            System.out.println("Category: " + item.getCategory().getTitle());
            System.out.println("Id: " + item.getId());
            System.out.println("Title: " + item.getTitle());
            System.out.println("Brief: " + item.getBrief());
            System.out.println("Content: " +item.getContent());
            System.out.println("CreateDate: " + item.getCreateDate());
            System.out.println("is published: " + item.getPublished());

//            System.out.println("PublishDate: " + item.getPublishDate());
//            System.out.println("LastUpdateDate: "+ item.getLastUpdateDate());

            List<Tag> listTag =  item.getTagList();
            if (listTag.size()>0)
            {
                for (Tag t : listTag)
                {
                    System.out.println("Tag Id: " + t.getId());
                    System.out.println("Tag Title: " + t.getTitle());
                }
            }
            System.out.println("-------------------------");
        }
    }
}
