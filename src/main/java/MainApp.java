import controller.MainMenu;
import domains.User;
import services.UserService;

public class MainApp {
    public static void main(String[] args) {
//        UserService userService = new UserService();
//        User user = userService.signUpUser("admin", "1990412602", "1992-11-29", "iran", "dezful", "negar", "20");
//        userService.editPassword(user.getId(), "admin");
//        userService.changeRole(user.getId(), "admin");
        MainMenu.showMenu();
    }
}
