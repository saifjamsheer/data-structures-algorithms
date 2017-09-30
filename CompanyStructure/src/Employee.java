public abstract class Employee implements nonManagers {

    public String name;
    public double baseSalary;
    public static int ID = 0;
    public int numberID;
    public double bonus;

    public Employee(String name, double salary) {
        this.name = name;
        this.baseSalary = salary;
        this.numberID = this.setEmployeeID();
        this.bonus = 0;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public String getName() {
        return this.name;
    }

    public int setEmployeeID() {
        ID += 1;
        return ID;
    }

    public int getEmployeeID() {
        return this.numberID;
    }

    public Employee getManager() {
        if (this instanceof SoftwareEngineer || this instanceof Accountant) {
            return this.getManager();
        } else {
            return null;
        }
    }

    public boolean equals(Employee other) {
        if (this.numberID == other.numberID) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.numberID + " " + this.getName();
    }

    abstract String employeeStatus();

}