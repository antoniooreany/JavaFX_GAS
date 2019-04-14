package ColorFinder;

import javafx.application.Application;
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
    private static final String[] COLORS = new String[]{"Red:", "Green:", "Blue:"};
    private static final int COLORS_NUMBER = COLORS.length;
    private static final double opacity = 1;

    private static double[] values;
    private static Rectangle rectangle;
    private static Color color;
    private static Slider[] sliders = new Slider[COLORS_NUMBER];
    private static Label[] lblValues255 = new Label[COLORS_NUMBER];
    private static Label[] lblColors = new Label[COLORS_NUMBER];

    @Override
    public void start(Stage stage) {

        GridPane gridPane = getGridPane(100);
        FlowPane flowPane = getFlowPane(200, 200);

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft(gridPane);
        borderPane.setRight(flowPane);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    private GridPane getGridPane(int valuesBlockMinWidth) {
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
//        gridPane.setGridLinesVisible(true); //TODO Only for debugging. Comment when ready!
//        gridPane.
        gridPane.setAlignment(Pos.CENTER);

        values = new double[COLORS_NUMBER];

        for (int i = 0; i < COLORS_NUMBER; i++) {
            int finalI = i;
            sliders[finalI] = new Slider(MIN_VALUE, MAX_VALUE, 0);
            lblValues255[finalI] = new Label(Double.toString(values[finalI]));
            lblColors[finalI] = new Label(COLORS[finalI]);
            lblValues255[finalI] = new Label(Double.toString(values[finalI]));
            lblValues255[finalI].setMinWidth(valuesBlockMinWidth); //TODO Do we need this line?
            gridPane.add(lblValues255[finalI], 1, finalI);
            gridPane.add(lblColors[finalI], 0, finalI);
            gridPane.add(sliders[finalI], 2, finalI);

            sliders[finalI].valueProperty().addListener((ov, old_val, new_val) -> {
                        double v = new_val.doubleValue() / 255;
                        values[finalI] = v;
                        color = new Color(values[0], values[1], values[2], opacity);
                        rectangle.setFill(color);
                        gridPane.getChildren().remove(lblValues255[finalI]);
                        lblValues255[finalI] = new Label(Double.toString(Math.round(values[finalI] * 255)));
                        lblValues255[finalI].setMinWidth(valuesBlockMinWidth); //TODO Do we need this line?
                        gridPane.add(lblValues255[finalI], 1, finalI);
                    }
            );
        }
        return gridPane;
    }

    private FlowPane getFlowPane(int rectangleWidth, int rectangleHeight) {
        int x = 0;
        int y = 0;
        rectangle = new Rectangle(x, y, rectangleWidth, rectangleHeight);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(new Color(values[0], values[1], values[2], opacity));
        rectangle.setStrokeWidth(3);

        FlowPane flowPane = new FlowPane();
//        flowPane.setPadding(new Insets(0, 0, 0, 0));
        flowPane.setVgap(4);
        flowPane.setHgap(4);
        flowPane.setPrefWrapLength(170); // preferred width allows for two columns
        flowPane.setStyle("-fx-background-color: #b6ffc1;");
        flowPane.getChildren().add(rectangle);
        return flowPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
