package org.example;

public class Employees {
    private static int id;
    private String name;
    private double hourlyWage;
    private double hoursWorked;
    private double bonuses;
    private Penalties penalties;
    private double netPay;
    private String rank;

    public Employees(int id, String name, double hourlyRate, double hoursWorked, double bonuses, Penalties penalties, String rank) {
        this.id = id;
        this.name = name;
        this.hourlyWage = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.bonuses = bonuses;
        this.penalties = penalties;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getId() {
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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
        if (penalties.equals(Penalties.AGGRESSION)){
            payPenalty = netPay - 8;
        }
       else if (penalties.equals(Penalties.BULLYING)){
            payPenalty = netPay - 20;
        }
        else if (penalties.equals(Penalties.LAZINESS)){
            payPenalty = netPay - 10;
        }
       else  if (penalties.equals(Penalties.MISCONDUCT)){
            payPenalty = netPay - 15;
        }
        else{
            payPenalty = netPay - 0;
        }
        return payPenalty;
    }
    @Override
    public String toString() {
        return "Employee ID: " + id + "\n"+
                "Name: " + name + "\n"+
                "Hourly Wage: $" + hourlyWage + "\n" +
                "Hours Worked: " + hoursWorked + "hrs\n" +
                "Bonuses: $" + bonuses + "\n" +
                "Penalty: " + penalties + "\n" +
                "NetPay: $" + calculateNetPay();
    }
}
