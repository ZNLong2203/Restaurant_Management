package model;

public class product_info {
    private int id;
    private int customer_id;
    private double total;
    private java.sql.Date date;

    private int numId;

//    store the total income of the restaurant by date
    public product_info(double total, java.sql.Date date){
        this.total = total;
        this.date = date;
    }

//    store the total customer of the restaurant by date
    public product_info(int numId, java.sql.Date date){
        this.numId = numId;
        this.date = date;
    }

    public int getId(){
        return id;
    }

    public int getCustomerId(){
        return customer_id;
    }

    public double getTotal(){
        return total;
    }

    public java.sql.Date getDate(){
        return date;
    }

    public int getNumId(){
        return numId;
    }
}
