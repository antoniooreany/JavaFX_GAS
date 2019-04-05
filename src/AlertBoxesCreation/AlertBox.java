package AlertBoxesCreation;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String title, String message) {

        Label lbl = new Label("Label");

        Button btn = new Button("Button");

        StackPane pane = new StackPane();
        pane.getChildren().addAll(lbl, btn);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane, 300, 300);
        scene.setOnMousePressed(event -> System.out.println("Mouse pressed!!!"));

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.showAndWait();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(message);
                stage.close();
            }
        });
    }
}
