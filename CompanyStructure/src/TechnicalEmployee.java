abstract class TechnicalEmployee extends Employee {


    public TechnicalEmployee(String name) {

        super(name, 75000);
    }

    public String employeeStatus() {
        return this.numberID + " " + this.name + " has ";
    }
}