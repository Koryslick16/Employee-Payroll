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

        System.out.print("\t=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=\n");

        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tEMPLOYEE PAYROLL MANAGEMENT SYSTEM");

        System.out.print("\t=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=");
        System.out.print("=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=" + "=\n");

       EmployeeImpl PayRoll = new EmployeeImpl();
       int count = 0;
        try {
       do {
           System.out.println("\n" +
                   "\t1 Add an Employee\n" +
                   "\t2 View an Employee\n" +
                   "\t3 Update an Employee's Information \n" +
                   "\t4 View All Employees\n" +
                   "\t5 Delete an Employee\n" +
                   "\t6 Exit Program\n");
           System.out.println("Input your Preferred action: ");

           int inputChoice = input.nextInt();
           input.nextLine();
           switch (inputChoice) {
               case 1:
                   int id = count++;
                   System.out.println("Employee Full Name: ");
                   String employeeName = input.nextLine();
//                    employeeName.replace(" ", "_");
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
                           "\n1: AGGRESSION" +
                           "\n2: BULLYING" +
                           "\n3: LAZINESS" +
                           "\n4: MISCONDUCT" +
                           "\n5: NONE");
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
                   PayRoll.addEmployee(new Employees(id, employeeName, employeeWage, hrs, bonuses, penalties));
//                   PayRoll.writeToFile("Employee Payroll.txt");
//                   PayRoll.processThePayroll();

                   break;
               case 2:
                   System.out.println("Input Employee's name: ");
                   String employee = input.next();
                   PayRoll.searchEmployee(employee);

                   break;
               case 3:
                   PayRoll.updateEmployee();

                   break;
               case 4:
                   PayRoll.displayPayRoll();
                   try (BufferedReader reader = new BufferedReader(new FileReader("Employee Payroll.txt"))) {
                       String line;
                       while ((line = reader.readLine()) != null) {
                           String[] split = line.split(" ");
                           String name = split[0].replace("_", " ");
                           String gender = split[1];
                           String age = split[2];
                           String rank = split[3];
                           System.out.println("Full name: " + name + "\nGender: " + gender + "\nAge: " + age + "\nRank: " + rank);
                           System.out.println("-------------------------------------------");
                       }

                   } catch (Exception e) {
                       e.printStackTrace();
                   }

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
                   System.out.println("Invalid option. Please input a valid option.4");
           }


       } while (true);
   } catch (Exception e) {
       throw new RuntimeException(e);
   }
    }
}