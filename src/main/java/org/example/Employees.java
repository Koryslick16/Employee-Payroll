package org.example;

public class Employees {
    private int id;
    private String name;
    private double hourlyWage;
    private double hoursWorked;
    private double bonuses;
    private Penalties penalties;
    private double netPay;

    public Employees(int id, String name, double hourlyRate, double hoursWorked, double bonuses, Penalties penalties) {
        this.id = id;
        this.name = name;
        this.hourlyWage = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.bonuses = bonuses;
        this.penalties = penalties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getBonuses() {
        return bonuses;
    }

    public void setBonuses(double bonuses) {
        this.bonuses = bonuses;
    }

    public Penalties getPenalties() {
        return penalties;
    }

    public void setPenalties(Penalties penalties) {
        this.penalties = penalties;
    }

    public double calculateNetPay(){
       netPay = (hourlyWage * hoursWorked);
       calculatePenalties(netPay);
       return calculatePenalties(netPay);
    }
    public double calculatePenalties(double netPay){
        double payPenalty = 0;
        if (penalties == Penalties.AGGRESSION){
            payPenalty = netPay - 45;
        }
       else if (penalties == Penalties.BULLYING){
            payPenalty = netPay - 50;
        }
        else if (penalties == Penalties.LAZINESS){
            payPenalty = netPay - 60;
        }
       else  if (penalties == Penalties.MISCONDUCT){
            payPenalty = netPay - 65;
        }
        else{
            payPenalty = netPay - 0;
        }
        return payPenalty;
    }
    @Override
    public String toString() {
        return "Employee: \n" +
                "Name: " + name + "\n"+
                "Hourly Wage: $" + hourlyWage + "\n" +
                "Hours Worked: " + hoursWorked + "hrs\n" +
                "Bonuses: " + bonuses + "\n" +
                "Penalties: " + penalties + "\n" +
                "NetPay: $" + netPay +calculateNetPay();
    }
}
