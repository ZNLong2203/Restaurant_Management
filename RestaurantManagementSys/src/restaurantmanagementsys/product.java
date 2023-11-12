package restaurantmanagementsys;

import oracle.sql.DATE;

public class product {
    
    private Integer id;
    private String customerId;
    private String productId;
    private String name;
    private String type;
    private Double price;
    private Integer quantity;
    private java.sql.Date date;
    
    public product(Integer id, String productId, String name, String type, Double price, Integer quantity){
        this.id = id;
        this.productId = productId;
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Integer getId(){
        return id;
    }
    public String getCustomerId(){
        return customerId;
    }
    public String getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public Double getPrice(){
        return price;
    }
    public Integer getQuantity(){
        return quantity;
    }
    public java.sql.Date getDate(){
        return date;
    }
}
