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

public class Main extends Application {

    private static final String title = "Color Finder";
    private static final double MIN_VALUE = 0;
    private static final double MAX_VALUE = 255;
    private static final int COLORS_NUMBER = 3;
    private static final String[] COLORS = new String[]{"Red:", "Green:", "Blue:"};
    private static final double opacity = 1;

    private static double[] values;
    private static Rectangle rectangle;
    private static Color color;

    @Override
    public void start(Stage stage) {

        Label[] lblColorNames = new Label[COLORS_NUMBER];
        Label[] lblValues = new Label[COLORS_NUMBER];
        Slider[] sliders = new Slider[COLORS_NUMBER];

        GridPane gridPane = getGridPane(lblColorNames, lblValues, sliders);
        FlowPane flowPane = getFlowPane();

        BorderPane border = new BorderPane();
        border.setLeft(gridPane);
        border.setRight(flowPane);

        Scene scene = new Scene(border);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    private GridPane getGridPane(Label[] lblColors, Label[] lblValues255, Slider[] sliders) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        values = new double[COLORS_NUMBER];

        for (int i = 0; i < COLORS_NUMBER; i++) {
            sliders[i] = new Slider(MIN_VALUE, MAX_VALUE, 0);
            lblValues255[i] = new Label(Double.toString(values[i]));
            lblColors[i] = new Label(COLORS[i]);
            int finalI = i;

            lblValues255[finalI] = new Label(Double.toString(values[finalI]));
            gridPane.add(lblValues255[i], 1, i);
            gridPane.add(lblColors[i], 0, i);
            gridPane.add(sliders[i], 2, i);

            sliders[i].valueProperty().addListener((ov, old_val, new_val) -> {
                        double v = new_val.doubleValue() / 255;
                        values[finalI] = v;
                        color = new Color(values[0], values[1], values[2], opacity);
                        rectangle.setFill(color);
                        gridPane.getChildren().remove(lblValues255[finalI]);
                        lblValues255[finalI] = new Label(Double.toString(Math.round(values[finalI] * 255)));
                        gridPane.add(lblValues255[finalI], 1, finalI);
                    }
            );
        }
        return gridPane;
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

    public static void main(String[] args) {
        launch(args);
    }
}
