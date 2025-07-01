import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes

	private Button button1, button2, button3, button4, button5;
    private Label feedbackLabel;
    private TextField textField;
    private HBox hBoxButtons, hBoxLabelTextField;
	
	//student Task #4:
	//  declare an instance of DataManager

	private DataManager dataManager;

	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes

		button1 = new Button("Hello");
		button2 = new Button("Howdy");	
		button3 = new Button("Chinese");	
		button4 = new Button("Clear");	
		button5 = new Button("Exit");	
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components

		dataManager = new DataManager();

		ButtonHandler buttonHandler = new ButtonHandler();

		button1.setOnAction(buttonHandler);
        button2.setOnAction(buttonHandler);
        button3.setOnAction(buttonHandler);
        button4.setOnAction(buttonHandler);
        button5.setOnAction(buttonHandler);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		feedbackLabel = new Label("Feedback:");
		textField = new TextField();
		hBoxButtons = new HBox(button1, button2, button3, button4, button5);
		hBoxLabelTextField = new HBox(feedbackLabel, textField);

		hBoxButtons.setAlignment(Pos.CENTER);
        hBoxLabelTextField.setAlignment(Pos.CENTER);

        getChildren().addAll(hBoxButtons, hBoxLabelTextField);

		HBox.setMargin(button1, new Insets(0, 10, 0, 10));

	}
	
private class ButtonHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {

            if (event.getSource() == button1 || event.getSource() == button2 || event.getSource() == button3) {

                String feedback = "";
				//hello howdy and chinese button
                if (event.getSource() == button1) {
                    feedback = dataManager.getHello();
                } else if (event.getSource() == button2) {
                    feedback = dataManager.getHowdy();
                } else if (event.getSource() == button3) {
                    feedback = dataManager.getChinese();
                }
                textField.setText(feedback);

            } else if (event.getSource() == button4) {
				//clear
                textField.setText("");

            } else if (event.getSource() == button5) {
				//exit
                Platform.exit();
                System.exit(0);

            }

        }
    }
	

}	
