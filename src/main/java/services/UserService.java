package services;

import domains.Address;
import domains.Role;
import domains.User;
import repositories.UserRepositoryDAO;

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
        User savedUser = userRepositoryDAO.save(user);
        return savedUser;
    }

    public long SignInUser(String userName , String password)
    {
        return userRepositoryDAO.selectByUserNameAndPassword(userName,password);
    }
}
