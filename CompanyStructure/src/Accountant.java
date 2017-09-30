public class Accountant extends BusinessEmployee {

    //public double bonusBudget;
    public TechnicalLead teamSupport;
    public BusinessLead manager;

    public Accountant(String name) {
        super(name);
        this.bonusBudget = 0;
        this.teamSupport = null;

    }

    public TechnicalLead getTeamSupported() {
        if (this.teamSupport == null) {
            return null;
        } else {
            return this.teamSupport;
        }
    }

    public void supportTeam(TechnicalLead lead) {
        for (int i = 0; i < lead.reports.size(); i++) {
            this.bonusBudget += 75000;
        }
        this.bonusBudget += this.bonusBudget*0.10;
    }

    public boolean approveBonus(double bonus) {
        if (this.getTeamSupported() == null) {
            return false;
        } else if (bonus <= this.bonusBudget){
            //this.bonusBudget -= bonus;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee getManager() {
        return this.manager;
    }

    @Override
    public String employeeStatus() {
        if (this.getTeamSupported() == null) {
            return super.employeeStatus();
        } else {
            return super.employeeStatus() + " is supporting " + this.getTeamSupported();
        }
    }

}