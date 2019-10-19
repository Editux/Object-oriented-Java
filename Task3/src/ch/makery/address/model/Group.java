package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Group {
    private StringProperty title;
    private IntegerProperty number;

    Group(String title,String number){
        this.title=new SimpleStringProperty();
        this.number= new SimpleIntegerProperty();
    }
}
