
import java.sql.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ShoppingCartDao {
    //本类的一个对象引用，保存自身对象
    private static ShoppingCartDao shoppingCartDao = new ShoppingCartDao();

    //私有的构造方法，防止其它类创建它的对象
    private ShoppingCartDao() {
    }

    public static ShoppingCartDao getInstance() {
        return shoppingCartDao;
    }

    //返回所有的shoppingCart对象的方法


    //根据id返回shoppingCart对象的方法
    public ShoppingCart find(Integer id) throws SQLException {
        ShoppingCart shoppingCart = null;
        //获得连接对象
        Connection connection = JdbcHelper.getConn();
        String selectcommodity_sql = "SELECT * FROM shoppingcart WHERE id=?";
        //在该连接上创建预编译语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(selectcommodity_sql);
        //为预编译参数赋值
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        //由于id不能取重复值，故结果集中最多有一条记录
        //若结果集有一条记录，则以当前记录中的id,description,no,remarks，school值为参数，创建GraduateProject对象
        //若结果集中没有记录，则本方法返回null
        if (resultSet.next()) {
            User user = UserDao.getInstance().find(resultSet.getInt("user_id"));
            Commodity commodity = CommodityDao.getInstance().find(resultSet.getInt("commodity_id"));
            //创建ShoppingCart对象，根据遍历结果中的id,number,user_id,commodity_id值
            shoppingCart = new ShoppingCart(resultSet.getInt("id"), resultSet.getInt("number"), user, commodity);
        }
        //关闭资源
        JdbcHelper.close(resultSet, preparedStatement, connection);
        return shoppingCart;
    }


}