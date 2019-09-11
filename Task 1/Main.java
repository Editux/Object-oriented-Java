package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.println("Enter the length of Rectangle:");
        double input_a = input.nextDouble();
        System.out.println("Enter the width of Rectangle");
        double input_b = input.nextDouble();
        System.out.println("Enter the corner of x coordinate");
        double input_x=input.nextDouble();
        System.out.println("Enter the corner of y coordinate");
        double input_y= input.nextDouble();

        Rectangle rect=new Rectangle(input_a, input_b,input_x,input_y);

        System.out.println("The area of Rectangle is:"+ Recalc.GetArea(rect.a, rect.b));
        System.out.println("The Circumference of rectangle is:" +Recalc.GetCircumference(rect.a,rect.b));
        System.out.println("The Diagonal of rectangle is:" +Recalc.Diagonal(rect.a,rect.b));
        System.out.println("The Coordinate of x center is:"+Recalc.GetCenterX(rect.x));
        System.out.println("The Coordinate of y center is:"+Recalc.GetCenterY(rect.y));
    }
}
