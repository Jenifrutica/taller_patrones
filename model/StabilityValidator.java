package model;

public class StabilityValidator {

    private double maxImbalancePercent;
    private double maxDraft;

    public StabilityValidator() {
    }

    public StabilityValidator(double maxImbalancePercent, double maxDraft) {
        this.maxImbalancePercent = maxImbalancePercent;
        this.maxDraft = maxDraft;
    }

    public double getMaxImbalancePercent() {
        return maxImbalancePercent;
    }

    public void setMaxImbalancePercent(double maxImbalancePercent) {
        this.maxImbalancePercent = maxImbalancePercent;
    }

    public double getMaxDraft() {
        return maxDraft;
    }

    public void setMaxDraft(double maxDraft) {
        this.maxDraft = maxDraft;
    }

    @Override
    public String toString() {
        return maxImbalancePercent + " | " + maxDraft;
    }
}
