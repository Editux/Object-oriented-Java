package sample;

import javafx.beans.property.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Orderfood {
    private StringProperty dishname;
    private StringProperty description;
    private IntegerProperty price;
    private FileInputStream picture;
    private double total;


    public Orderfood(){
        this(null,null,0);
    }
    public Orderfood(String dishname,String description,int price){
        this.dishname = new SimpleStringProperty(dishname);
        this.description= new SimpleStringProperty(description);
        this.price = new SimpleIntegerProperty(price);
        /*try {
            this.picture = new FileInputStream(String.valueOf(picture));
        } catch (FileNotFoundException e) {
            System.out.println("This method of picture doesn't work");
        }
        */

    }

    public void setDishname(String dishname) {
        this.dishname.set(dishname);
    }

    public String getDishname() {
        return dishname.get();
    }

    public StringProperty dishnameProperty() {
        return dishname;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDescription() {
        return description.get();
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPicture(FileInputStream picture) {
        this.picture = picture;
    }

    public FileInputStream getPicture() {
        return picture;
    }

    public double getTotal() {

        for (int i = 0; i <Main.getOrderData().size() ; i++) {

            total=total + Main.getOrderData().get(i).getPrice();
        }
        return total;
    }
    public double getTotalVat(){
       final double  tax = 1.21;

        return total *tax;
    }
}
