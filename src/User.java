public final class User {
    private Integer id;
    private String username;
    private String password;
    private String realname;
    private Integer phone;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(Integer id, String username, String password,
                String realname, Integer phone, String address) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.address = address;
    }

    //@Override
    public int compareTo(User o) {
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
        final User other = (User) obj;
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
        retValue = "User ( "
                + super.toString() + TAB
                + "id = " + this.id + TAB
                + "username = " + this.username + TAB
                + "password = " + this.password + TAB
                + "realname = " + this.realname + TAB
                + "phone = " + this.phone + TAB
                + "address = " + this.address + TAB
                + " )";
        return retValue;
    }
}
