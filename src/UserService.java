import java.sql.SQLException;

public class UserService {
    private UserDao userDao= UserDao.getInstance();
    private static UserService userService = new UserService();
    private UserService(){}
    public static UserService getInstance(){
        return userService;
    }
    public User find(Integer id)throws SQLException {
        return userDao.find(id);
    }

}
