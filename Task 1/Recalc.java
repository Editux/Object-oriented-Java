package com.company;
//Class that is responsible calculating the rectangle
public class Recalc {
    public static double GetArea(double a, double b) {
        return a * b;
    }
    public static double GetCircumference(double a,double b){

        return 2*a+2*b;
    }
    public static double Diagonal(double a,double b){
        double c;
        c=Math.sqrt((a*a)+(b*b));
        return c;
    }
    public static double GetCenterX(double x){

        return (x+0)/2;
    }
    public static double GetCenterY(double y){


        return (y+0)/2;
    }
}
