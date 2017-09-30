public class SoftwareEngineer extends TechnicalEmployee implements nonManagers {

    public boolean codeAccess;
    public int codeCheckIns;
    public TechnicalLead manager;

    public SoftwareEngineer(String name) {
        super(name);
        this.codeAccess = false;
        this.codeCheckIns = 0;
        this.manager = null;
    }

    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    public void setCodeAccess(boolean access) {
        this.codeAccess = access;
    }

    public int getSuccessfulCheckIns() {
        return this.codeCheckIns;
    }

    public boolean checkInCode() {
        if (this.manager == null) {
            System.out.println("No manager assigned yet.");
            return false;
        } else {
            if (this.manager.approveCheckIn(this) == true) {
                this.codeCheckIns += 1;
                return true;
            } else {
                return false;
            }
        }
    }


    public Employee getManager() {
        return this.manager;
    }

    @Override
    public String employeeStatus() {
        return super.employeeStatus() + this.codeCheckIns + " successful check-ins.";
    }
}