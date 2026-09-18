package config;

import model.CargoUnit;
import java.util.ArrayList;
import java.util.List;
    /* esto noams es para poder tomas los tipos de datos q se dieron en el casito, medio hardcoded si*/
public final class SampleData {

    private SampleData() {
    }

    public static List<CargoUnit> rows() {
        List<CargoUnit> list = new ArrayList<>();
        list.add(new CargoUnit("CNT;MSKU1234567;40;18.5;SEAL-8891", "CNT;TCLU8877213;40;21.9;SEAL-4410", 0.0, "LIQ;PALM-OIL;120000;0.915"));
        list.add(new CargoUnit("SP-2026-0148", "BG-4417", 0.0, "CONTAINERS"));
        list.add(new CargoUnit("B1=600 t", "B2=750 t", 0.0, "B4=600 t"));
        return list;
    }
}
