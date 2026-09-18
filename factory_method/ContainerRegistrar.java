package factory_method;

import model.CargoUnit;


public class ContainerRegistrar extends ManifestRegistrar {

    @Override
    public CargoUnit create(String kind) {
        CargoUnit item = new CargoUnit();
        item.setCode(kind);
        return item;
    }
}
