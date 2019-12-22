import java.io.Serializable;

public class Order implements Comparable<Order>, Serializable {
    private Integer id;
    private User user;
    private ShoppingCart shoppingCart;
    private Commodity commodity;
    private  int number;
    {
        this.id = IdService.getId();
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int Number) {
        this.number = number;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity Commodity) {
        this.commodity = commodity;
    }
    public Order(int id,int number,User user,ShoppingCart shoppingCart,Commodity commodity ) {
        this(number,user,shoppingCart,commodity);
        this.id = id;
    }
    public Order(int number,User user,ShoppingCart shoppingCart,Commodity commodity) {
        super();
        this.number = number;
        this.user = user;;
        this.shoppingCart = shoppingCart;
        this.commodity = commodity;
       
    }

    @Override
    public int compareTo(Order o) {
        // TODO Auto-generated method stub
        return this.id-o.id;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    public String toString()
    {
        final String TAB = "    ";
        String retValue = "";
        retValue = "Order ( "
                + super.toString() + TAB
                + "id = " + this.id + TAB
                + "number = " + this.number + TAB
                + "user = " + this.user + TAB
                + "commodity = " + this.commodity + TAB
                + "shoppingcart = " + this.shoppingCart + TAB
                + " )";

        return retValue;
    }
}
