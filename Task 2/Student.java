package com.company;



public class Student {
    private String name;
    private String surname;
    private String group;



   Subject[] subject= new Subject[10];

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGroup(String group) {
        this.group = group;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

 

    public double getAverage(int size) {
        float sum_a=0;
        float sum_b=0;

        double average;


        for (int i = 0; i < size; i++) {



            sum_a = sum_a + subject[i].getGrade() * subject[i].getCredits;
            sum_b = sum_b+ subject[i].getCredits(); ;

        }
        average =sum_a *sum_b/sum_b;
        return average / 10;
    }
}
