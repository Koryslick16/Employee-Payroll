package org.example;

import java.io.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        while (true){

        System.out.print("\t=====================================================");
        System.out.print("=====================================================");
        System.out.print("=====================================================\n");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEMPLOYEE PAYROLL MANAGEMENT SYSTEM");

        System.out.print("\t=====================================================");
        System.out.print("=====================================================");
        System.out.print("=====================================================\n");

       EmployeeImpl PayRoll = new EmployeeImpl();
       int count = 1;
        try {
       do {
           System.out.println("\n" +
                   "\t\t||============================================||\n" +
                   "\t\t||\t\t\t\t\tMENU\t\t\t\t\t  ||\n" +
                   "\t\t||============================================||\n" +
                   "\t\t1: Add an Employee\n" +
                   "\t\t2: View an Employee\n" +
                   "\t\t3: Update an Employee's Information \n" +
                   "\t\t4: View All Employees\n" +
                   "\t\t5: Delete an Employee\n" +
                   "\t\t6: Exit Program\n");
           System.out.println("Input your Preferred action: ");

           int inputChoice = input.nextInt();
           input.nextLine();
           switch (inputChoice) {
               case 1:
                   int id = count++;
                   if (id == Employees.getId()){
                       id++;
                   }
                   System.out.println("Employee Full Name: ");
                   String employeeName = input.nextLine();
                   System.out.println("Employee Rank: ");
                   String rank = input.nextLine();
                   System.out.println("Employee hourly Wage: ");
                   double employeeWage = input.nextDouble();
                   System.out.println("Hours Worked: ");
                   String employeeHrs = input.next();
                   double hrs = 0;
                   if (employeeHrs.endsWith("mins") || employeeHrs.endsWith("minutes")) {
                       employeeHrs = employeeHrs.replaceAll("[^0-9]", "");
                       double minutes = Double.parseDouble(employeeHrs);
                       hrs = minutes / 60.0;
                   } else {
                       hrs = Double.parseDouble(employeeHrs);
                   }
                   System.out.println("Employee Bonuses(amount): ");
                   double bonuses = input.nextDouble();
                   input.nextLine();
                   System.out.println("PENALTIES:" +
                           "\nAGGRESSION" +
                           "\nBULLYING" +
                           "\nLAZINESS" +
                           "\nMISCONDUCT" +
                           "\nNONE");
                   System.out.println("Employee Penalty: ");
                   Penalties penalties = Penalties.valueOf(input.nextLine().toUpperCase());
                   switch (penalties) {
                       case LAZINESS -> {
                           Penalties.valueOf("LAZINESS");
                           break;
                       }

                       case AGGRESSION -> {
                           Penalties.valueOf("AGGRESSION");
                           break;
                       }
                       case MISCONDUCT -> {
                           Penalties.valueOf("MISCONDUCT");
                           break;
                       }
                       case BULLYING -> {
                           Penalties.valueOf("BULLYING");
                           break;
                       }
                       case NONE -> {
                           Penalties.valueOf("NONE");
                           break;
                       }
                       default -> throw new IllegalStateException("Unexpected value: " + penalties);
                   }
                   PayRoll.addEmployee(new Employees(id, employeeName, employeeWage, hrs, bonuses, penalties, rank));

                   break;
               case 2:
                   System.out.println("Input Employee's id: ");
                   int employee = input.nextInt();
                   PayRoll.searchEmployee(employee);

                   break;
               case 3:
                   System.out.println("Input the name of the Employee you want to update");
                   PayRoll.updateEmployee();

                   break;
               case 4:
                   PayRoll.displayPayRoll();

                   break;
               case 5:
                   System.out.println("Input the id of the Employee you want to remove: ");
                   int newId = input.nextInt();
                   PayRoll.deleteEmployee(newId);

                   break;
               case 6:
                   System.exit(0);
                   break;

               default:
                   System.out.println("Invalid option. Please input a valid option.");
           }


       } while (true);
   } catch (Exception e) {
       throw new RuntimeException(e);
   }
    }
}