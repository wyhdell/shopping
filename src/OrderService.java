import java.sql.SQLException;
import java.util.Collection;

public class OrderService {
    private OrderDao orderDao= OrderDao.getInstance();
    private static OrderService orderService = new OrderService();
    private OrderService(){}
    public static OrderService getInstance(){
        return orderService;
    }

    public Collection<Order> findAll()throws SQLException {
        return orderDao.findAll();
    }
    //Singleton

    public Order find(Integer id)throws SQLException{
        return orderDao.find(id);
    }



    public boolean add(Order project)throws SQLException {
        return orderDao.add(project);
    }

    public boolean delete(Integer id) throws SQLException {
        return orderDao.delete(id);
    }

}
