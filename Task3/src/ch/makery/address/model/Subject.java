package ch.makery.address.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Subject {
    private StringProperty title;
    private IntegerProperty grade;
    private IntegerProperty credits;


    Subject(String title,int grade, int credits){
        this.title= new SimpleStringProperty();
        this.grade=new SimpleIntegerProperty();
        this.credits=new SimpleIntegerProperty();
    }
    public void setCredits(int credits) {
        this.credits.set(credits);
    }

    public void setGrade(int grade) {
        this.grade.set(grade);
    }

    public int getCredits() {
        return credits.get();
    }

    public int getGrade() {
        return grade.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getTitle() {
        return title.get();
    }
}
