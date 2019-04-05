import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PrimitiveArithmetics extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("PrimitiveArithmetics");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(10, 10, 10, 10));

        rootNode.setHgap(10);
        rootNode.setVgap(20);

        Scene myScene = new Scene(rootNode, 600, 200);

        primaryStage.setScene(myScene);

        TextField txtFldOp1 = new TextField();
        TextField txtFldOp2 = new TextField();

        Label lblErrMsg = new Label("");
        lblErrMsg.setMinWidth(100);

        Button btn = new Button();
        btn.setText("Compute!");

        Label lblSum = new Label();
        Label lblSub = new Label();

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String opStr1 = txtFldOp1.getCharacters().toString();
                    String opStr2 = txtFldOp2.getCharacters().toString();
                    int int1 = Integer.parseInt(opStr1);
                    int int2 = Integer.parseInt(opStr2);
                    int sum = int1 + int2;
                    int sub = int1 - int2;
                    lblSum.setText(opStr1 + " + " + opStr2 + " = " + sum);
                    lblSub.setText(opStr1 + " - " + opStr2 + " = " + sub);
                } catch (NumberFormatException e) {
                    lblErrMsg.setText("Illegal argument(s)");
                } finally {
                    btn.setDisable(true);
                }
            }
        });

        txtFldOp1.textProperty().addListener((observable, oldValue, newValue) -> {
            btn.setDisable(false);
            lblErrMsg.setText("");
//            System.out.println("txtFldOp1 changed from " + oldValue + " to " + newValue);
        });

        txtFldOp2.textProperty().addListener((observable, oldValue, newValue) -> {
            btn.setDisable(false);
            lblErrMsg.setText("");
//            System.out.println("txtFldOp2 changed from " + oldValue + " to " + newValue);
        });

        rootNode.add(txtFldOp1, 0, 0);
        rootNode.add(txtFldOp2, 0, 1);
        rootNode.add(lblErrMsg, 1, 0);
        rootNode.add(btn, 1, 1);
        rootNode.add(lblSum, 2, 0);
        rootNode.add(lblSub, 2, 1);
        primaryStage.show();
    }
}
