package org.example;

public interface IEmployee {
    void displayPayRoll();
    void addEmployee(Employees employees);
    void writeToFile(String filename);
    String searchEmployee(int id);
    void updateEmployee();
    void deleteEmployee(int id);
}
