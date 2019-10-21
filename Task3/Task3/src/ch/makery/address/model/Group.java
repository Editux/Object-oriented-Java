package ch.makery.address.model;

import ch.makery.address.Main;
import ch.makery.address.view.StudentEditController;
import javafx.beans.property.*;


public class Group {

    private DoubleProperty groupAverage;



    public double getGroupAverage() {
        double average;
        double sum =0;
        for (int i = 0; i <StudentEditController.number ; i++) {


            sum =+ Main.studentData.get(i).getAverage();
        }
         average= sum/StudentEditController.number;
        return average;
    }
}
