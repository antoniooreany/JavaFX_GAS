package ColorFinder;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String title = "Color finder";
    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 255;
    private static final int COLOR_NUMBER = 3;
    private static final String[] COLORS = new String[]{"Red", "Green", "Blue"};
    private static double[] values = new double[]{0.0, 0.0, 0, 0};
    private double opacity = 1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label[] lblColors = new Label[COLOR_NUMBER];
        Label[] lblValues = new Label[COLOR_NUMBER];

        Slider[] sliders = new Slider[COLOR_NUMBER];

        Rectangle r = new Rectangle(50, 25, 100, 140);
        r.setStroke(Color.BLACK);
        r.setFill(new Color(values[0], values[1], values[2], opacity));
        r.setStrokeWidth(3);

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.add(r, 3, 0);

        for (int i = 0; i < COLOR_NUMBER; i++) {
            lblColors[i] = new Label(COLORS[i]);
            lblValues[i] = new Label(Double.toString(values[i]));
            sliders[i] = new Slider(MIN_VALUE, MAX_VALUE, 0);
            int finalI = i;
            sliders[i].valueProperty().addListener((ov, old_val, new_val) -> {
                        double v = new_val.doubleValue() / 255;
                        values[finalI] = v;
                        r.setFill(new Color(values[0], values[1], values[2], opacity));
                        System.out.println("!!!changed: " + COLORS[finalI] + "    " + old_val + " ---> " + new_val);
                    }
            );
            pane.add(lblColors[i], 0, i);
            pane.add(lblValues[i], 1, i);
            pane.add(sliders[i], 2, i);
        }

        Scene scene = new Scene(pane, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.setTitle(title);
        primaryStage.show();
    }
}
