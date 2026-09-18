package model;

public class Hold {

    private String code;
    private double capacity;
    private double assignedWeight;
    private int units;

    public Hold() {
    }

    public Hold(String code, double capacity, double assignedWeight, int units) {
        this.code = code;
        this.capacity = capacity;
        this.assignedWeight = assignedWeight;
        this.units = units;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getAssignedWeight() {
        return assignedWeight;
    }

    public void setAssignedWeight(double assignedWeight) {
        this.assignedWeight = assignedWeight;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return code + " | " + capacity + " | " + assignedWeight + " | " + units;
    }
}
