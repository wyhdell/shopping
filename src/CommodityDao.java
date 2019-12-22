

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommodityDao {

    private static CommodityDao commodityDao = new CommodityDao();

    private CommodityDao() {
    }

    public static CommodityDao getInstance() {
        return commodityDao;
    }

    public Commodity find(Integer id) throws SQLException {
        Commodity commodity = null;
        Connection connection = JdbcHelper.getConn();
        String findCommodity_sql = "SELECT * FROM commodity WHERE id=?";
        //在该连接上创建预编译语句对象
        PreparedStatement preparedStatement = connection.prepareStatement(findCommodity_sql);
        //为预编译参数赋值
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        //由于id不能取重复值，故结果集中最多有一条记录
        //若结果集有一条记录，则以当前记录中的id,description,no,remarks值为参数，创建Degree对象
        //若结果集中没有记录，则本方法返回null
        if (resultSet.next()) {
            commodity = new Commodity(resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("price"),
                    resultSet.getString("description"),
                    resultSet.getString("type"));
        }
        System.out.println("commodity find" + commodity);
        //关闭资源
        JdbcHelper.close(resultSet, preparedStatement, connection);
        return commodity;
    }
}