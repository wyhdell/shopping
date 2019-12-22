import java.sql.SQLException;

public class CommodityService {
    private CommodityDao commodityDao= CommodityDao.getInstance();
    private static CommodityService commodityService = new CommodityService();
    private CommodityService(){}
    public static CommodityService getInstance(){
        return commodityService;
    }
    public Commodity find(Integer id)throws SQLException {
        return commodityDao.find(id);
    }
}
