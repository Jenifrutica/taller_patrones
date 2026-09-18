package ui;

import controller.StowagePlanningEngine;
import controller.OutputListener;
import model.CargoUnit;
import javax.swing.*;
import java.awt.*;


public class MinimalFlatUI extends JFrame implements OutputListener {

    private final StowagePlanningEngine engine;
    private final JTextArea output = new JTextArea(14, 52);
    private final JLabel error = new JLabel(" ");
    private final JTextField field0 = new JTextField(12);
    private final JTextField field1 = new JTextField(12);
    private final JTextField field2 = new JTextField(12);
    private final JTextField field3 = new JTextField(12);

    public MinimalFlatUI() {
        super("=== BARRANCABERMEJA RIVER TERMINAL ===");
        this.engine = new StowagePlanningEngine(this);
        buildUi();
        engine.loadSampleData();
    }

    private void buildUi() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));
        JLabel title = new JLabel(" BARRANCABERMEJA RIVER TERMINAL");
        title.setFont(title.getFont().deriveFont(Font.BOLD, 20f));
        title.setBorder(BorderFactory.createEmptyBorder(10, 12, 4, 12));
        add(title, BorderLayout.NORTH);
        JPanel center = new JPanel(new BorderLayout(8, 8));
        center.add(form(), BorderLayout.NORTH);
        output.setEditable(false);
        center.add(new JScrollPane(output), BorderLayout.CENTER);
        add(center, BorderLayout.CENTER);
        add(error, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    private JComponent form() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
        panel.add(new JLabel("code"));
        panel.add(field0);
        panel.add(new JLabel("unitType"));
        panel.add(field1);
        panel.add(new JLabel("grossWeight"));
        panel.add(field2);
        panel.add(new JLabel("description"));
        panel.add(field3);
        panel.add(button("Add", this::onAdd));
        panel.add(button("List", this::onList));
        panel.add(button("Find", this::onFind));
        panel.add(button("Count", this::onCount));
        panel.add(button("Build", this::onBuild));
        panel.add(button("Factory", this::onFactory));
        panel.add(button("Family", this::onFamily));
        return panel;
    }

    private JButton button(String text, Runnable action) {
        JButton b = new JButton(text);
        b.addActionListener(e -> run(action));
        return b;
    }

    private void run(Runnable action) {
        error.setText(" ");
        try {
            action.run();
        } catch (RuntimeException ex) {
            error.setForeground(new Color(0xB0, 0x00, 0x20));
            error.setText(ex.getMessage());
        }
    }

    private void onAdd() {
        engine.add(new CargoUnit(field0.getText(), field1.getText(), Double.parseDouble(field2.getText().trim()), field3.getText()));
        onList();
    }

    private void onList() {
        output.setText("");
        for (CargoUnit item : engine.all()) {
            out(item.toString());
        }
        out("Total: " + engine.count());
    }

    private void onFind() {
        String key = field0.getText();
        CargoUnit item = engine.find(key);
        out(item == null ? "Not found: " + key : "Found: " + item);
    }

    private void onCount() {
        out("Count: " + engine.count());
    }

    private void onBuild() {
        engine.build(field0.getText(), field1.getText(), Double.parseDouble(field2.getText().trim()), field3.getText());
        onList();
    }

    private void onFactory() {
        String kind = field0.getText();
        engine.createByFactory(false, kind);
        onList();
    }

    private void onFamily() {
        String key = field0.getText();
        engine.createFamily(false, false, key);
        onList();
    }

    private void out(String message) {
        output.append(message + "\n");
    }

    @Override
    public void onOutput(String message) {
        out(message);
    }

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless()) {
            runCli();
            return;
        }
        try {
            SwingUtilities.invokeLater(() -> new MinimalFlatUI().setVisible(true));
        } catch (Throwable t) {
            runCli();
        }
    }

    private static void runCli() {
        StowagePlanningEngine engine = new StowagePlanningEngine(System.out::println);
        engine.loadSampleData();
        System.out.println(engine.describeAll());
        System.out.println("Count: " + engine.count());
    }
}
