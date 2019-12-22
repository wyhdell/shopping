import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private static UserDao userDao = new UserDao();
    //私有的构造方法，防止其它类创建它的对象
    private UserDao() {
    }
    public static UserDao getInstance() {
        return userDao;
    }
    public User find(Integer id) throws SQLException {
        User user = null;
        //获得连接对象
        Connection connection = JdbcHelper.getConn();
        String selectProject_sql = "SELECT * FROM User WHERE id=?";
        //在该连接上创建预编译语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(selectProject_sql);
        //为预编译参数赋值
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        //由于id不能取重复值，故结果集中最多有一条记录
        //若结果集有一条记录，则以当前记录中的id,description,no,remarks，school值为参数，创建User对象
        //若结果集中没有记录，则本方法返回null
        if (resultSet.next()) {
            user = new User(resultSet.getInt("id"),
                    resultSet.getString("username"), resultSet.getString("password"), resultSet.getString("realname"),resultSet.getInt("phone"),
                    resultSet.getString("phone"));
        }
        //关闭资源
        JdbcHelper.close(resultSet, preparedStatement, connection);
        return user;
    }
}
