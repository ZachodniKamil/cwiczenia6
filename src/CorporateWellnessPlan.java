public class CorporateWellnessPlan extends MembershipPlan implements RemoteAccess, Freezable {
    private int employeeCount;
    private int workshopsPerMonth;
    private boolean onlineDashboard;

    public CorporateWellnessPlan(String planCode, String clientName, int months, double baseMonthlyFee,
                                 boolean autoRenew, int employeeCount, int workshopsPerMonth,
                                 boolean onlineDashboard) {
        super(planCode, clientName, months, baseMonthlyFee, autoRenew);
        this.employeeCount = employeeCount;
        this.workshopsPerMonth = workshopsPerMonth;
        this.onlineDashboard = onlineDashboard;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public int getWorkshopsPerMonth() {
        return workshopsPerMonth;
    }

    public boolean isOnlineDashboard() {
        return onlineDashboard;
    }

    @Override
    public String getPlanType() {
        return "CorporateWellnessPlan";
    }

    @Override
    public double calculateMonthlyNetPrice() {
        double price = getBaseMonthlyFee();
        price += employeeCount * 18;
        price += workshopsPerMonth * 220;
        if (employeeCount >= 20) {
            price = price * 0.88;
        }
        if (onlineDashboard) {
            price += 80;
        }
        return price;
    }

    @Override
    public boolean hasOnlineAccess() {
        return onlineDashboard;
    }

    @Override
    public boolean canFreeze() {
        return getMonths() >= 6 && workshopsPerMonth == 0;
    }

    @Override
    public String toString() {
        return super.toString()
                + " [employeeCount=" + employeeCount
                + ", workshopsPerMonth=" + workshopsPerMonth
                + ", onlineDashboard=" + onlineDashboard + "]";
    }
}