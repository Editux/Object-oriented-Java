package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {


Student students= new Student();

Scanner scan = new Scanner(System.in);
//Entering the information
        System.out.println("Enter your name:\n");
        String name=scan.nextLine();
        students.setName(name);

        System.out.println("Enter your surname:\n");
        String surname=scan.nextLine();
        students.setSurname(surname);

        System.out.println("Enter your group name:\n");
        String group =scan.nextLine();
        students.setGroup(group);

        System.out.println("How much subjects?\n");
        int size=scan.nextInt();

        for (int i = 0; i < size; i++) {

            students.subject[i]=new Subject();
            System.out.println("Enter subject title : \n" );
            String title=scan.next();
            students.subject[i].setTitle(title);
            System.out.println("Enter subject grade for:\n");
            int grade=scan.nextInt();
            students.subject[i].setGrade(grade);
            System.out.println("Enter subject credits:\n");
            int credits=scan.nextInt();
            students.subject[i].setCredits(credits);


        }
        // Displaying Student's whole information
        System.out.printf("Name: %s\n",students.getName());
        System.out.printf("Surname: %s\n",students.getSurname());
        System.out.printf("Group: %s\n",students.getGroup());

        for(int i=0; i<size; i++){
            System.out.printf("For %s you have %d mark and %d credits\n",students.subject[i].getTitle(),students.subject[i].getGrade(),students.subject[i].getCredits());
        }

        System.out.println("The average is:" +students.getAverage(size));

}}
