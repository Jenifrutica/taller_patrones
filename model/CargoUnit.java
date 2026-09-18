package model;

public class CargoUnit {

    private String code;
    private String unitType;
    private double grossWeight;
    private String description;

    public CargoUnit() {
    }

    public CargoUnit(String code, String unitType, double grossWeight, String description) {
        this.code = code;
        this.unitType = unitType;
        this.grossWeight = grossWeight;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return code + " | " + unitType + " | " + grossWeight + " | " + description;
    }
}
