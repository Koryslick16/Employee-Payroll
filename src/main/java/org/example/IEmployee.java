package org.example;

public interface IEmployee {
    void displayPayRoll();
    void addEmployee(Employees employees);
    void processThePayroll();
    void writeToFile(String filename);
    void searchEmployee(String name);
    void updateEmployee();
    void deleteEmployee(int id);
}
