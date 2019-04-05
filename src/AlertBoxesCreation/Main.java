package AlertBoxesCreation;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    private Stage stage;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Label label1 = new Label("Page 1");

        Button button1 = new Button("Push for the AlertBox to appear!!!");
        button1.setOnAction(event -> AlertBox.display("Stage","!!!Button pushed!!!"));

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.add(label1, 0, 0);
        pane.add(button1, 0, 1);
        pane.setAlignment(Pos.CENTER);

        scene = new Scene(pane, 500, 500);

        stage = primaryStage;
        stage.setScene(scene);
        stage.setTitle("SceneSwitcher");
        stage.show();

    }
}
