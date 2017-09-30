import java.util.ArrayList;
import java.util.List;

public class BusinessLead extends BusinessEmployee implements leadPrivileges {

    private int headCount;
    public ArrayList<Accountant> accReports;

    public BusinessLead(String name) {
        super(name);
        this.baseSalary = 50000*2;
        this.headCount = 10;
        this.accReports = new ArrayList<Accountant>();
        this.bonusBudget = 0;
    }

    public boolean hasHeadCount() {
        if (this.accReports.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(Accountant e, TechnicalLead supportTeam) {
        if (hasHeadCount() == true) {
            this.accReports.add(e);
            e.manager = this;
            e.teamSupport = supportTeam;
            e.supportTeam(supportTeam);
            supportTeam.businessSupport = this;
            this.bonusBudget += e.baseSalary*1.1;
            return true;
        } else {
            return false;
        }

    }

    public boolean requestBonus(Employee e, double bonus) {
        if (bonus <= this.bonusBudget) {
            e.bonus += bonus;
            this.bonusBudget -= bonus;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveBonus(Employee e, double bonus) {
        for (int i = 0; i < this.accReports.size(); i++) {
            if (e.getManager() == this.accReports.get(i)) {
                if (this.accReports.get(i).approveBonus(bonus) == true) {
                    this.accReports.get(i).bonusBudget -= bonus;
                    e.bonus += bonus;
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return false;
    }

    public String getTeamStatus() {
        if (this.accReports.size() == 0) {
            return super.employeeStatus() + "no direct reports yet.";
        } else {
            String status = "";
            for (int i = 0; i < this.accReports.size(); i++) {
                status += this.accReports.get(i).employeeStatus() + "\n";
            }
            return super.employeeStatus() + this.accReports.size() + " reports, and is managing the following members:\n" + status;
        }
    }

}