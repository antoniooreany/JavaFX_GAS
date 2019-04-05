import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class DynamicButton extends Application {
	
	private static final double BUTTON_HEIGHT = 60;
	private static final double BUTTON_WIDTH = 100;
	private int magicNumber = 0;

	public static void main(String[] args) {
        launch(args);
	}
	
    public void start(Stage myStage) {

        myStage.setTitle("DynamicButton");

        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 200, 400);
 
        myStage.setScene(myScene);
        
       	Button btnMagic = new Button("" + magicNumber);
       	btnMagic.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
       	btnMagic.setFont(new Font("Courier New", 20));
       	
       	Button btnReset = new Button("Reset");
       	btnReset.setMinSize(BUTTON_WIDTH, BUTTON_HEIGHT);
       	btnReset.setFont(new Font("Courier New", 20));
      	
       	btnMagic.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				++magicNumber;
				btnMagic.setText("" + magicNumber);
				btnReset.setDisable(false);
				
			}
		});
       	       	
       	btnReset.setOnAction(new EventHandler<ActionEvent>() {			
			@Override
			public void handle(ActionEvent event) {
				magicNumber = 0;
				btnMagic.setText("" + magicNumber);
				btnReset.setDisable(true);
			}
		});
       	
       	rootNode.getChildren().addAll(btnMagic, btnReset);

        myStage.show();
    }


}
