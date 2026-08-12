abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double monthlySalary();
}

class FullTime extends Employee {
    double salary;

    FullTime(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    double monthlySalary() {
        return salary;
    }
}

class PartTime extends Employee {
    int hours;
    double rate;

    PartTime(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {
    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    double monthlySalary() {
        return stipend;
    }
}

public class Payroll {
    public static void main(String[] args) {

        // Default values
        Employee[] emp = {
            new FullTime("Sanvi", 101, 50000),
            new PartTime("Datta", 102, 80, 200),
            new Intern("Riaan", 103, 10000)
        };

        double total = 0;

        for (Employee e : emp) {
            double s = e.monthlySalary();
            System.out.println(e.name + " (ID: " + e.id + ") Salary = " + s);

            if (e instanceof Intern) {
                System.out.println("Note: This employee is an Intern.");
            }

            total += s;
        }

        System.out.println("Total Payroll = " + total);
    }
}