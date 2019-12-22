

public final class ShoppingCart {
    private Integer id;
    private Integer number;
    public User user;
    public Commodity commodity;
    {
        this.id = IdService.getId();
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Commodity getCommodity() {
        return commodity;
    }
    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

    public ShoppingCart(int id, int number, User user, Commodity commodity) {
        this(number, user, commodity);
        this.id = id;
    }

    public ShoppingCart(Integer number, User user,Commodity commodity){
        super();
        this.number = number;
        this.user = user;
        this.commodity = commodity;
    }

    //@Override
    public int compareTo(ShoppingCart o) {
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
        final ShoppingCart other = (ShoppingCart) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public String toString() {
        final String TAB = "    ";
        String retValue = "";
        retValue = "ShoppingCart ( "
                + super.toString() + TAB
                + "id = " + this.id + TAB
                + "number = " + this.number + TAB
                + "user = " + this.user + TAB
                + "commodity = " + this.commodity + TAB
                + " )";
        return retValue;
    }
}
