package JavaFX_Demos;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.scene.control.*;

public class BasicArithmetic extends Application {

    private String text1;
    private String text2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("Inside the Start Method().");

        primaryStage.setTitle("Primitive Arithmetic");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(10, 10, 10, 10));

        // Set vertical and horizontal gaps between controls.
        rootNode.setVgap(10);
        rootNode.setHgap(20);

        Scene myScene = new Scene(rootNode, 600, 200);

        primaryStage.setScene(myScene);

        Label plus = new Label();
        Label minus = new Label();
        Label response = new Label();

        Button compute = new Button();
        compute.setText("Compute!");

        TextField operand1 = new TextField();
        operand1.setMaxWidth(120);
        TextField operand2 = new TextField();
        operand2.setMaxWidth(120);

        // Add first column.
        rootNode.add(operand1, 0, 0);
        rootNode.add(operand2, 0, 1);

        // Add second column.
        rootNode.add(compute, 1, 1);

        // Add Third column.
        rootNode.add(plus, 2, 0);
        rootNode.add(minus, 2, 1);
        rootNode.add(response, 2, 2);


        // Handle the action events for the Second button.
        compute.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {

                text1 = operand1.getText();
                text2 = operand2.getText();

                if (text1.equals("") || text2.equals("")) {
                    response.setText("You Forgot to Enter one of the Numeric Strings at least!");
                }

                try {
                    int op1 = Integer.parseInt(text1);
                    int op2 = Integer.parseInt(text2);
                    plus.setText(text1 + "+" + text2 + "=" + (op1 + op2));
                    minus.setText(text1 + "-" + text2 + "=" + (op1 - op2));
                } catch (NumberFormatException nfe) {
                    response.setText("Illegal Input!");
                }
            }
        });

        operand1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {

            }
        });

        operand2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {

            }
        });

        primaryStage.show();
    }

//    private String generate(Label response, Label plus, Label minus, String text) {
//
//        String value = "";
//
//        for (int i = 0; i < text.length(); ++i) {
//            if (text.charAt(i) < '0' || text.charAt(i) > '9') {
//                throw new NumberFormatException();
//            } else {
//                value += text.charAt(i);
//            }
//        }
//        return value;
//    }
}