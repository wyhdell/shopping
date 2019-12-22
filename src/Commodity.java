

public final class Commodity {
    private Integer id;
    private String name;
    private Integer price;
    private String description;
    private String type;

    public Commodity(Integer id, String name, Integer price,
                String description, String type) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.type = type;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}