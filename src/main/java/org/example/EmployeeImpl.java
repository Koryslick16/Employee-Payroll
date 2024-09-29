package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeImpl implements IEmployee{
    public List<Employees> employees  = new ArrayList<>();
    @Override
    public void displayPayRoll() {
        if (employees.isEmpty()){
            System.out.println("No Employees have been added. Add an Employee.");
        }
       employees = new ArrayList<>();
    }

    @Override
    public void addEmployee(Employees employee) {

        employees.add(employee);
        writeToFile("Employee Payroll.txt");
        System.out.println("Employee added successfully.");
    }

    @Override
    public void processThePayroll() {

    }

    @Override
    public void writeToFile(String filename) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Employees employee : employees) {
                writer.write(employee.toString());
                writer.newLine();
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void searchEmployee(String name) {
         for (Employees emp : employees){
             if (emp.getName().equals(name)){
                 System.out.println(emp);
             }
             else {
                 System.out.println("Employee with this name does not exist");
             }
         }
    }

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
