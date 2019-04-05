package ColorFinder;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Test extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();

        Rectangle r1 = new Rectangle(50, 25, 100, 140);
        r1.setStroke(Color.BLACK);
        Paint paint = new Color(0.10, 0.10, 0.10, 0.10);
        r1.setFill(paint);
        r1.setStrokeWidth(3);

        pane.getChildren().addAll(r1);

        Scene scene = new Scene(pane, 300, 300);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
