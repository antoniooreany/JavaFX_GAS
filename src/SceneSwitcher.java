import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SceneSwitcher extends Application {

    private Stage stage;
    private Scene scene1;
    private Scene scene2;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;

        Label label1 = new Label("Page 1");
        Button button1 = new Button("Switch to page 2");
        button1.setOnAction(event -> stage.setScene(scene2));
        GridPane layout1 = new GridPane();
        layout1.setHgap(10);
        layout1.setVgap(10);
        layout1.add(label1, 0, 0);
        layout1.add(button1, 0, 1);
        layout1.setAlignment(Pos.CENTER);
        scene1 = new Scene(layout1, 500, 500);

        Label label2 = new Label("Page 2");
        Button button2 = new Button("Switch to page 1");
        button2.setOnAction(event -> stage.setScene(scene1));
        GridPane layout2 = new GridPane();
        layout2.setHgap(10);
        layout2.setVgap(10);
        layout2.add(label2, 0, 0);
        layout2.add(button2, 0, 1);
        layout2.setAlignment(Pos.CENTER);
        scene2 = new Scene(layout2, 500, 500);

        stage.setScene(scene1);
        stage.setTitle("Scene switcher");
        stage.show();

    }
}
