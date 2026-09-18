package builder;

import model.CargoUnit;

// BUILDER: Fluent StowagePlanBuilder construye el StowagePlan (esta en models)
public class CargoUnitBuilder {

    private String code;
    private String unitType;
    private double grossWeight;
    private String description;

    public CargoUnitBuilder code(String code) {
        this.code = code;
        return this;
    }

    public CargoUnitBuilder unitType(String unitType) {
        this.unitType = unitType;
        return this;
    }

    public CargoUnitBuilder grossWeight(double grossWeight) {
        this.grossWeight = grossWeight;
        return this;
    }

    public CargoUnitBuilder description(String description) {
        this.description = description;
        return this;
    }

    public CargoUnit build() {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code is required");
        }
        if (unitType == null || unitType.isBlank()) {
            throw new IllegalArgumentException("unitType is required");
        }
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description is required");
        }
        return new CargoUnit(code, unitType, grossWeight, description);
    }
}
