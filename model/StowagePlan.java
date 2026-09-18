package model;

public class StowagePlan {

    private String planNumber;
    private String departureDate;
    private String bargeRegistration;
    private String terminalType;
    private double totalWeight;
    private boolean approved;

    public StowagePlan() {
    }

    public StowagePlan(String planNumber, String departureDate, String bargeRegistration, String terminalType, double totalWeight, boolean approved) {
        this.planNumber = planNumber;
        this.departureDate = departureDate;
        this.bargeRegistration = bargeRegistration;
        this.terminalType = terminalType;
        this.totalWeight = totalWeight;
        this.approved = approved;
    }

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getBargeRegistration() {
        return bargeRegistration;
    }

    public void setBargeRegistration(String bargeRegistration) {
        this.bargeRegistration = bargeRegistration;
    }

    public String getTerminalType() {
        return terminalType;
    }

    public void setTerminalType(String terminalType) {
        this.terminalType = terminalType;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public boolean getApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    @Override
    public String toString() {
        return planNumber + " | " + departureDate + " | " + bargeRegistration + " | " + terminalType + " | " + totalWeight + " | " + approved;
    }
}
