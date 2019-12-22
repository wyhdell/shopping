

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

public final class ShoppingCartService {
    private ShoppingCartDao shoppingCartDao= ShoppingCartDao.getInstance();
    private static ShoppingCartService shoppingCartService = new ShoppingCartService();

    //Singleton
    private ShoppingCartService(){}

    public static ShoppingCartService getInstance(){
        return shoppingCartService;
    }


    //获得id对应的课题
    public ShoppingCart find(Integer id)throws SQLException  {
        return shoppingCartDao.find(id);
    }

}