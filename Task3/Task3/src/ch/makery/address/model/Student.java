package ch.makery.address.model;

import ch.makery.address.Main;
import ch.makery.address.view.StudentEditController;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Student  {
private StringProperty name;
private StringProperty surname;
private StringProperty group;
private IntegerProperty semester;
private IntegerProperty subjectEgrade;//English
private IntegerProperty subjectEcredit;
private IntegerProperty subjectMgrade;// Math
private IntegerProperty subjectMcredit;
private IntegerProperty subjectPgrade;//Physics
private IntegerProperty subjectPcredit;
private IntegerProperty subjectHgrade;//History
private IntegerProperty subjectHcredit;
private IntegerProperty subjectCgrade;//Computer Science
private IntegerProperty subjectCcredit;





    public Student() {
        this(null, null,0,0,0,0,0,0,0,0,0,0);
    }
public Student(String name,String surname, int subjectEgrade,int subjectEcredit,int subjectMgrade,int subjectMcredit, int subjectPgrade,int subjectPcredit,int subjectHgrade,int subjectHcredit,int subjectCgrade,int subjectCcredit){
    this.name= new SimpleStringProperty(name);
    this.surname=new SimpleStringProperty(surname);
    this.group=new SimpleStringProperty("PI18E");
    this.semester=new SimpleIntegerProperty(2);
    this.subjectEgrade= new SimpleIntegerProperty(subjectEgrade);
    this.subjectEcredit=new SimpleIntegerProperty(subjectEcredit);
    this.subjectMgrade=new SimpleIntegerProperty(subjectMgrade);
    this.subjectMcredit=new SimpleIntegerProperty(subjectMcredit);
    this.subjectPgrade=new SimpleIntegerProperty(subjectPgrade);
    this.subjectPcredit= new SimpleIntegerProperty(subjectPcredit);
   this.subjectHgrade= new SimpleIntegerProperty(subjectHgrade);
   this.subjectHcredit= new SimpleIntegerProperty(subjectHcredit);
    this.subjectCgrade= new SimpleIntegerProperty(subjectCgrade);
    this.subjectCcredit= new SimpleIntegerProperty(subjectCcredit);



}

    public void setName(String name) {
        this.name.set(name);
    }

    public String getName() {
        return name.get();
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getSurname() {
        return surname.get();
    }

    public void setGroup(String group) {
        this.group.set(group);
    }

    public String getGroup() {
        return group.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public StringProperty groupProperty() {
        return group;
    }

    public void setSemester(int semester) {
        this.semester.set(semester);
    }

    public int getSemester() {
        return semester.get();
    }


    public int getSubjectEgrade() {
        return subjectEgrade.get();
    }



    public int getSubjectEcredit() {
        return subjectEcredit.get();
    }



    public int getSubjectMgrade() {
        return subjectMgrade.get();
    }

    public int getSubjectMcredit() {
        return subjectMcredit.get();
    }


    public int getSubjectPcredit() {
        return subjectPcredit.get();
    }

    public int getSubjectPgrade() {
        return subjectPgrade.get();
    }


    public int getSubjectHcredit() {
        return subjectHcredit.get();
    }

    public int getSubjectHgrade() {
        return subjectHgrade.get();
    }

    public int getSubjectCgrade() {
        return subjectCgrade.get();
    }

    public int getSubjectCcredit() {
        return subjectCcredit.get();
    }

    public void setSubjectEgrade(int subjectEgrade) {
        this.subjectEgrade.set(subjectEgrade);
    }

    public void setSubjectEcredit(int subjectEcredit) {
        this.subjectEcredit.set(subjectEcredit);
    }

    public void setSubjectMgrade(int subjectMgrade) {
        this.subjectMgrade.set(subjectMgrade);
    }

    public void setSubjectMcredit(int subjectMcredit) {
        this.subjectMcredit.set(subjectMcredit);
    }

    public void setSubjectHcredit(int subjectHcredit) {
        this.subjectHcredit.set(subjectHcredit);
    }

    public void setSubjectHgrade(int subjectHgrade) {
        this.subjectHgrade.set(subjectHgrade);
    }

    public void setSubjectCcredit(int subjectCcredit) {
        this.subjectCcredit.set(subjectCcredit);
    }

    public void setSubjectCgrade(int subjectCgrade) {
        this.subjectCgrade.set(subjectCgrade);
    }

    public void setSubjectPcredit(int subjectPcredit) {
        this.subjectPcredit.set(subjectPcredit);
    }

    public void setSubjectPgrade(int subjectPgrade) {
        this.subjectPgrade.set(subjectPgrade);
    }

    public double getAverage(){
       double average;

          double suma;

        suma = subjectEgrade.get()+subjectMgrade.get()+subjectPgrade.get()+subjectHgrade.get()+subjectCgrade.get();

        average= suma/5;

        return average;
    }
    public double getGroupAverage() {
        double average;
        double sum =0;
        for (int i = 0; i < StudentEditController.number ; i++) {


            sum = sum+ Main.studentData.get(i).getAverage();
        }
        average= sum/StudentEditController.number;
        return average;
    }
}
