import java.util.ArrayList;
import java.util.List;

public class TechnicalLead extends TechnicalEmployee implements leadPrivileges {

    private int headCount;
    public BusinessLead businessSupport;
    public ArrayList<SoftwareEngineer> reports;

    public TechnicalLead(String name) {
        super(name);
        this.headCount = 4;
        this.baseSalary = 75000*1.3;
        this.reports = new ArrayList<SoftwareEngineer>();
    }

    public boolean hasHeadCount() {
        if (this.reports.size() < this.headCount) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer e) {
        if (hasHeadCount() == true) {
            this.reports.add(e);
            e.manager = this;
            return true;
        } else {
            return false;
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e) {
        if (this.reports.contains(e)) {
            if (e.codeAccess == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean requestBonus(Employee e, double bonus) {
        return this.businessSupport.approveBonus(e, bonus);
    }

    public String getTeamStatus() {
        if (this.reports.size() == 0) {
            return super.employeeStatus() + "no direct reports yet.";
        } else {
            String status = "";
            for (int i = 0; i < this.reports.size(); i++) {
                status += this.reports.get(i).employeeStatus() + "\n";
            }
            return super.employeeStatus() + this.reports.size() + " reports, and is managing the following members:\n" + status;
        }
    }


}