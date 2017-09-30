abstract class BusinessEmployee extends Employee {

    public double bonusBudget;

    public BusinessEmployee(String name) {
        super(name, 50000);
    }

    public double getBonusBudget() {
        return Math.round(this.bonusBudget);
    }

    public String employeeStatus() {
        return this.numberID + " " + this.name + " with a budget of " + this.getBonusBudget();
    }

}
