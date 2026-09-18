package controller;

import model.CargoUnit;
import config.SampleData;
import java.util.List;
import java.util.ArrayList;
import builder.CargoUnitBuilder;
import factory_method.ManifestRegistrar;
import factory_method.ContainerRegistrar;
import factory_method.GranelRegistrar;
import abstract_factory.TerminalFactory;
import abstract_factory.CreateStabValidator;
import abstract_factory.CreateCargoUnit;


public class StowagePlanningEngine {

    private final OutputListener out;
    private final List<CargoUnit> items = new ArrayList<>();

    public StowagePlanningEngine(OutputListener out) {
        this.out = out;
    }

    public void loadSampleData() {
        for (CargoUnit item : SampleData.rows()) {
            add(item);
        }
        out.onOutput("Sample data loaded: " + count() + " record(s).");
    }

    public void add(CargoUnit item) {
        items.add(item);
    }

    public List<CargoUnit> all() {
        return new ArrayList<>(items);
    }

    public CargoUnit find(String key) {
        for (CargoUnit i : items) {
            if (key.equals(i.getCode())) {
                return i;
            }
        }
        return null;
    }

    public boolean remove(String key) {
        return items.removeIf(i -> key.equals(i.getCode()));
    }

    public int count() {
        return items.size();
    }

    public String describeAll() {
        StringBuilder sb = new StringBuilder();
        for (CargoUnit i : all()) {
            sb.append(i).append('\n');
        }
        return sb.toString();
    }

    public String validate() {
    /*
    *Cada tipo define un conjunto inseparable de tres elementos: equipo de carga con una tasa fija (cinta transportadora BT-3 a 320 t/h, grúa pórtico móvil GP-1 a 180 t/h, brazo de carga BC-2 a 240 t/h), un validador de estabilidad y un formato de documento de embarque.
    *Peso bruto por tipo de unidad: contenedor = carga neta + tara (20 pies = 2,2 t, 40 pies = 3,8 t); lote de granel sólido = toneladas declaradas x (1 + % de humedad / 100); tanque de líquido = litros x densidad / 1000.
    *Cada barcaza tiene cuatro bodegas: B1 y B2 en proa, B3 y B4 en popa, con capacidades B1 = 600 t, B2 = 750 t, B3 = 750 t, B4 = 600 t.
    * % de desequilibrio = |pesoProa - pesoPopa| / pesoTotal x 100, donde pesoProa = peso(B1) + peso(B2) y pesoPopa = peso(B3) + peso(B4). Si supera el máximo del validador de la terminal, el plan se marca como NO APROBADO y se indican las toneladas que deben trasladarse del lado más pesado al más ligero para situarse exactamente en el límite.
    *Calado estimado (m) = 0,55 + (pesoTotal / 4200). Si supera el máximo del validador, el plan se marca como NO APROBADO por motivo de calado.
    */
        return null;
    }

    public CargoUnit build(String code, String unitType, double grossWeight, String description) {
        CargoUnitBuilder builder = new CargoUnitBuilder();
        builder.code(code);
        builder.unitType(unitType);
        builder.grossWeight(grossWeight);
        builder.description(description);
        CargoUnit item = builder.build();
        add(item);
        out.onOutput("Built: " + item);
        return item;
    }

    public CargoUnit createByFactory(boolean granel, String kind) {
        ManifestRegistrar factory = granel ? new GranelRegistrar() : new ContainerRegistrar();
        CargoUnit item = factory.create(kind);
        add(item);
        out.onOutput("Factory create: " + item);
        return item;
    }

    public CargoUnit createFamily(boolean cargo_unit, boolean secondary, String key) {
        TerminalFactory family = cargo_unit ? new CreateCargoUnit() : new CreateStabValidator();
        CargoUnit item = secondary ? family.createSecondary(key) : family.createPrimary(key);
        add(item);
        out.onOutput("Family create: " + item);
        return item;
    }

}
