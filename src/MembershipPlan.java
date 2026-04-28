public abstract class MembershipPlan implements Billable {
    private static final double VAT_RATE = 0.23;

    private String planCode;
    private String clientName;
    private int months;
    private double baseMonthlyFee;
    private boolean autoRenew;

    public MembershipPlan(String planCode, String clientName, int months, double baseMonthlyFee, boolean autoRenew) {
        this.planCode = planCode;
        this.clientName = clientName;
        this.months = months;
        this.baseMonthlyFee = baseMonthlyFee;
        this.autoRenew = autoRenew;
    }

    public String getPlanCode() {
        return planCode;
    }

    public String getClientName() {
        return clientName;
    }

    public int getMonths() {
        return months;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public abstract String getPlanType();

    @Override
    public abstract double calculateMonthlyNetPrice();

    @Override
    public double calculateMonthlyGrossPrice() {
        return calculateMonthlyNetPrice() * (1.0 + VAT_RATE);
    }

    public double calculateTotalNetPrice() {
        return calculateMonthlyNetPrice() * months;
    }

    public final void printSummary() {
        System.out.println("Plan type: " + getPlanType());
        System.out.println("Plan code: " + planCode);
        System.out.println("Client: " + clientName);
        System.out.println("Months: " + months);
        System.out.println("Auto renew: " + autoRenew);
        System.out.println("Monthly net price: " + calculateMonthlyNetPrice());
        System.out.println("Monthly gross price: " + calculateMonthlyGrossPrice());
        System.out.println("Total contract net price: " + calculateTotalNetPrice());
    }

    @Override
    public String toString() {
        return getPlanType() + "{planCode='" + planCode + "'"
                + ", clientName='" + clientName + "'"
                + ", months=" + months
                + ", baseMonthlyFee=" + baseMonthlyFee
                + ", autoRenew=" + autoRenew
                + "}";
    }
}