package ColorFinder;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test extends Application {

    private static final String title = "Layout Sample";
    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 255;
    private static final int COLOR_NUMBER = 3;
    private static final String[] COLORS = new String[]{"Red", "Green", "Blue"};
    private static double[] values = new double[]{0.0, 0.0, 0, 0};
    private double opacity = 1;
    private Rectangle rectangle;
    private Color color;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label[] lblColors = new Label[COLOR_NUMBER];
        Label[] lblValues = new Label[COLOR_NUMBER];
        Slider[] sliders = new Slider[COLOR_NUMBER];

        GridPane gridPane = getGridPane(lblColors, lblValues, sliders);
        FlowPane flowPane = getFlowPane();

        BorderPane border = new BorderPane();
        border.setRight(flowPane);
        border.setLeft(gridPane);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    private FlowPane getFlowPane() {
        rectangle = new Rectangle(50, 25, 100, 140);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(new Color(values[0], values[1], values[2], opacity));
        rectangle.setStrokeWidth(3);

        FlowPane flowPane = new FlowPane();
        flowPane.setPadding(new Insets(5, 0, 5, 0));
        flowPane.setVgap(4);
        flowPane.setHgap(4);
        flowPane.setPrefWrapLength(170); // preferred width allows for two columns
        flowPane.setStyle("-fx-background-color: DAE6F3;");
        flowPane.getChildren().add(rectangle);
        return flowPane;
    }

    private GridPane getGridPane(Label[] lblColors, Label[] lblValues, Slider[] sliders) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < COLOR_NUMBER; i++) {
            lblColors[i] = new Label(COLORS[i]);
            lblValues[i] = new Label(Double.toString(values[i]));
            sliders[i] = new Slider(MIN_VALUE, MAX_VALUE, 0);
            int finalI = i;
            sliders[i].valueProperty().addListener((ov, old_val, new_val) -> {
                        double v = new_val.doubleValue() / 255;
                        values[finalI] = v;
                        color = new Color(values[0], values[1], values[2], opacity);
                        rectangle.setFill(color);
//                        System.out.println("" + values[0]+ "    " + values[1] + "    " +  values[2] + "    " +  opacity);
//                        System.out.println("!!!changed: " + COLORS[finalI] + "    " + old_val + " ---> " + new_val);
                    }
            );
            gridPane.add(lblColors[i], 0, i);
            gridPane.add(lblValues[i], 1, i);
            gridPane.add(sliders[i], 2, i);
        }
        return gridPane;
    }
}
