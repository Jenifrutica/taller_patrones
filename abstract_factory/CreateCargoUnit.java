package abstract_factory;

import model.CargoUnit;

public class CreateCargoUnit implements TerminalFactory {

    @Override
    public CargoUnit createPrimary(String key) {
        return make(key, "cargo_unit");
    }

    @Override
    public CargoUnit createSecondary(String key) {
        return make(key, "cargo_unit-alt");
    }

    private CargoUnit make(String key, String family) {
        CargoUnit item = new CargoUnit();
        item.setCode(key + "-" + family);
        return item;
    }
}
