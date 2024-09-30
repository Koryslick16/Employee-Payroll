package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements IEmployee{
    public List<Employees> employees  = new ArrayList<>();
    @Override
    public void displayPayRoll() {
        try(BufferedReader reader = new BufferedReader(new FileReader("Employee Payroll.txt"))) {
//            if (employees.isEmpty()) {
//                System.out.println("No Employees have been added. Add an Employee.");
//            } else {
                System.out.println("Employee Payroll:");
                System.out.println("+-----------------------------------------------------------------------------------------------------------------------+");

                String read;
                while((read = reader.readLine()) != null) {
                String[] split = read.split(":");
                String id = split[0];
                String name = split[1];
                String rank = split[2];
                String wage = split[3];
                String hours = split[4];
                String bonus = split[5];
                String penalty = split[6];
                String netPay = split[7];
                    System.out.println("| ID |" + " Full Name |" + " Rank |" + " Hourly Wage |" + " Hours Worked |" + " Bonuses |" + " Penalty |" + " Net Pay |");
                    System.out.println("| " + id + " | " + name + " | " + rank + " | " + wage + " | " + hours + " | " + bonus + " | " + penalty + " | " + netPay + " |");
                    System.out.println("+-----------------------------------------------------------------------------------------------------------------------+");
                }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void addEmployee(Employees employee) {

        employees.add(employee);
        writeToFile("Employee Payroll.txt");
        System.out.println("Employee added successfully.");
    }

    @Override
    public void writeToFile(String filename) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (Employees employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
                writer.flush();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String searchEmployee(int id) {
        if (id >= 0 && id <= employees.size()){
             employees.get(id).toString();
        }
        return "Employee with this id does not exist";
    }

//    @Override
//    public String Employees searchEmployee(int id) {
////         for (Employees emp : employees){
////             if (emp.getName().equals(name)){
////                 System.out.println(emp);
////             }
////             else {
////                 System.out.println("Employee with this name does not exist");
////             }
////         }
//        if (id >= 0 || id <= employees.size()){
//            return employees.get(id);
//        }
//
//        return ;
//    }

    @Override
    public void updateEmployee() {

    }

    @Override
    public void deleteEmployee(int id) {
        for (Employees emp : employees){
            if (emp.getId() == id){
                employees.remove(emp);
                System.out.println("Employee deleted successfully");
            }
            else{
                System.out.println("Employee with this id is not available");
            }
        }
    }

}
