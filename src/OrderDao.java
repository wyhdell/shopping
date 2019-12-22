import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class OrderDao {
    private static OrderDao orderDao = new OrderDao();
    //私有的构造方法，防止其它类创建它的对象
    private OrderDao() {
    }
    public static OrderDao getInstance() {
        return orderDao;
    }
    public Order find(Integer id) throws SQLException {
        Order order = null;
        //获得连接对象
        Connection connection = JdbcHelper.getConn();
        String selectProject_sql = "SELECT * FROM Order1 WHERE id=?";
        //在该连接上创建预编译语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(selectProject_sql);
        //为预编译参数赋值
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        //由于id不能取重复值，故结果集中最多有一条记录
        //若结果集有一条记录，则以当前记录中的id,description,no,remarks，school值为参数，创建Order对象
        //若结果集中没有记录，则本方法返回null
        if (resultSet.next()) {
            User user = UserService.getInstance().find(resultSet.getInt("user_id"));
            ShoppingCart shoppingCart = ShoppingCartService.getInstance().find(resultSet.getInt("shoppingCart_id"));
            Commodity commodity = CommodityService.getInstance().find(resultSet.getInt("commodity_id"));
            //创建Order对象，根据遍历结果中的id,description,no,remarks，school值
            Order Order = new Order(resultSet.getInt("id"), resultSet.getInt("number"), user,shoppingCart, commodity);
            //向Orders集合中添加Order对象

        }
        //关闭资源
        JdbcHelper.close(resultSet, preparedStatement, connection);
        return order;
    }
    public Set<Order> findAll() throws SQLException {
        ////创建一个Order类型的集合
        Set<Order> Orders = new HashSet<Order>();
        //获得连接对象
        Connection connection = JdbcHelper.getConn();
        //创建一个Statement对象，封装SQL语句发送给数据库
        Statement statement = connection.createStatement();
        //执行SQL查询语句并获得结果集对象（游标指向结果集的开头）
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Order1");
        //若结果集仍然有下一条记录，则执行循环体
        while (resultSet.next()) {
            User user = UserService.getInstance().find(resultSet.getInt("user_id"));
            ShoppingCart shoppingCart = ShoppingCartService.getInstance().find(resultSet.getInt("shoppingCart_id"));
            Commodity commodity = CommodityService.getInstance().find(resultSet.getInt("commodity_id"));
            //创建Order对象，根据遍历结果中的id,description,no,remarks，school值
            Order Order = new Order(resultSet.getInt("id"), resultSet.getInt("number"), user,shoppingCart, commodity);
            //向Orders集合中添加Order对象
            Orders.add(Order);
        }
        //关闭资源
        JdbcHelper.close(resultSet, statement, connection);
        return Orders;
    }
    public boolean add(Order order) throws SQLException {
        //获得连接对象
        Connection connection = JdbcHelper.getConn();
        //定义sql语句
        String addProject_sql = "INSERT INTO Order1 (number ,user_id,shoppingCart_id,commodity_id) VALUES" + " (?,?,?,?)";
        //在该连接上创建预编译语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(addProject_sql);
        //为预编译参数赋值
            preparedStatement.setInt(1, order.getNumber());
        preparedStatement.setInt(2, order.getUser().getId());
        preparedStatement.setInt(3, order.getCommodity().getId());
        preparedStatement.setInt(4, order.getShoppingCart().getId());
        //执行预编译语句，获取添加记录行数并赋值给affectedRowNum
        int affectedRowNum = preparedStatement.executeUpdate();
        //关闭资源
        JdbcHelper.close(preparedStatement, connection);
        //如果影响的行数大于1，则返回true，否则返回false
        return affectedRowNum > 0;
    }
    public boolean delete(Integer id) throws SQLException {
        //获得连接对象
        Connection connection = JdbcHelper.getConn();
        //创建PreparedStatement接口对象，包装编译后的目标代码（可以设置参数，安全性高）
        PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Order1 WHERE id = ?");
        //为预编译的语句参数赋值
        pstmt.setInt(1, id);
        //执行预编译对象的executeUpdate()方法，获取删除记录的行数
        int affectedRowNum = pstmt.executeUpdate();
        System.out.println("删除了 " + affectedRowNum + " 条");
        //关闭资源
        JdbcHelper.close(pstmt, connection);
        //如果影响的行数大于1，则返回true，否则返回false
        return affectedRowNum > 0;
    }

}
