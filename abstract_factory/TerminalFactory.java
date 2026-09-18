package abstract_factory;

import model.CargoUnit;


public interface TerminalFactory {
    CargoUnit createPrimary(String key);
    CargoUnit createSecondary(String key);
}
