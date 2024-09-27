package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        while (true){
        System.out.print("\t=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=\n");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEMPLOYEE PAYROLL MANAGEMENT SYSTEM");

        System.out.print("\t=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=\n");

        EmployeeImpl PayRoll = new EmployeeImpl();
        do {
            System.out.println("\n" +
                    "\t1 Add an Employee\n" +
                    "\t2 View an Employee\n" +
                    "\t3 Update an Employee's Information \n" +
                    "\t4 View All Employees\n" +
                    "\t5 Delete an Employee\n" +
                    "\t6 Exit Program\n" );
            System.out.println("Input your Preferred action: ");

            int inputChoice = input.nextInt();
            switch (inputChoice) {
                case 1:
                    int count = 0;
                    int id = count++;
                    System.out.println("Employee Full Name: ");
                    String employeeName = input.next();
//                    employeeName.replace(" ", "_");
                    System.out.println("Employee hourly Wage: ");
                    double employeeWage = input.nextDouble();
                    System.out.println("Hours Worked: ");
                    String employeeHrs = input.next();
                    double hrs = 0;
                    if (employeeHrs.endsWith("mins")|| employeeHrs.endsWith("minutes")){
                        employeeHrs = employeeHrs.replaceAll("[0^9]", " ");
                        double minutes = Double.parseDouble(employeeHrs);
                        hrs = minutes / 60.0;
                     }else{
                        hrs = Double.parseDouble(employeeHrs);
                      }
                    System.out.println("Employee Bonuses(amount): ");
                    double bonuses = input.nextDouble();
                    System.out.println("PENALTIES:" +
                "\n1: AGGRESSION" +
                "\n2: BULLYING" +
                "\n3: LAZINESS" +
                "\n4: MISCONDUCT" +
                "\n5: NONE");
                    System.out.println("Employee Penalty: ");
                    Penalties penalties = Penalties.valueOf(input.nextLine());
                    switch (penalties){
                        case LAZINESS -> {
                            Penalties.valueOf("LAZINESS");
                        }
                        case AGGRESSION -> {
                             Penalties.valueOf("AGGRESSION");
                        }
                        case MISCONDUCT -> {
                             Penalties.valueOf("MISCONDUCT");
                        }
                        case BULLYING -> {
                             Penalties.valueOf("BULLYING");
                        }
                        case NONE -> {
                             Penalties.valueOf("NONE");
                        }
                        default -> throw new IllegalStateException("Unexpected value: " + penalties);
                    }
                    PayRoll.addEmployee(new Employees(id, employeeName, employeeWage, hrs, bonuses, penalties));
                    PayRoll.writeToFile("Employee Payroll.txt");
                    PayRoll.processThePayroll();

                case 2:
                    System.out.println("Input Employee's name: ");
                    String employee = input.next();
                    PayRoll.searchEmployee(employee);

                case 3:
                    PayRoll.updateEmployee();

                case 4:
                    PayRoll.displayPayRoll();
                    try (BufferedReader reader = new BufferedReader(new FileReader("Employee Payroll.txt"))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] split = line.split(" ");
                String name = split[0].replace("_", " ");
                String gender = split[1];
                String age = split[2];
                String rank = split[3];
                System.out.println("Full name: "+name+"\nGender: "+gender+"\nAge: "+age+"\nRank: "+rank);
                System.out.println("-------------------------------------------");
            }

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }

                case 5:
                    System.out.println("Input the id of the Employee you want to remove: ");
                    int newId = input.nextInt();
                    PayRoll.deleteEmployee(newId);

                case 6:
                      System.exit(0);

                    }

//        System.out.println("PENALTIES:" +
//                "\n1: AGGRESSION" +
//                "\n2: BULLYING" +
//                "\n3: LAZINESS" +
//                "\n4: MISCONDUCT" +
//                "\n5: NONE");
//        Penalties penalties = Penalties.valueOf(input.nextLine());
//        while (true) {
//            if (penalties.equals( Penalties.AGGRESSION)){
//                penalties = Penalties.valueOf("AGGRESSION");
//            }
//            else if(penalties.equals( Penalties.BULLYING)){
//                penalties = Penalties.valueOf("BULLYING");
//            } else if (penalties.equals(Penalties.LAZINESS)) {
//                penalties = Penalties.valueOf("LAZINESS");
//            } else if (penalties.equals(Penalties.MISCONDUCT)) {
//                penalties = Penalties.valueOf("MISCONDUCT");
//            } else if (penalties.equals(Penalties.NONE)) {
//                penalties = Penalties.valueOf("NONE");
//            }
//        }
//
//        PayRoll.addEmployee(new Employees(id, employeeName, employeeWage, hrs, bonuses, penalties));
//
//
//
//
//
//        try (BufferedReader reader = new BufferedReader(new FileReader("Employee Payroll.txt"))) {
//
//            String line;
//            while ((line = reader.readLine()) != null){
//                String[] split = line.split(" ");
//                String name = split[0].replace("_", " ");
//                String gender = split[1];
//                String age = split[2];
//                String rank = split[3];
//                System.out.println("Full name: "+name+"\nGender: "+gender+"\nAge: "+age+"\nRank: "+rank);
//                System.out.println("-------------------------------------------");
//            }
//

//    }
        } while (true);
    }
}