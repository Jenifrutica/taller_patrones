package factory_method;

import model.CargoUnit;

public abstract class ManifestRegistrar {

    public abstract CargoUnit create(String kind);

    public CargoUnit createDefault() {
        return create("default");
    }
}
