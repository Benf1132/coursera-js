import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Calculator extends Application {
    private TextField display;
    private Button[] numberButtons = new Button[10];
    private Button[] functionButtons = new Button[8];
    private Button addButton, subButton, mulButton, divButton;
    private Button decButton, equButton, delButton, clrButton;

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    @Override
    public void start(Stage primaryStage) {
        // Create display
        display = new TextField();
        display.setEditable(false);
        display.setStyle("-fx-font-size: 24;");

        // Create number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new Button(String.valueOf(i));
            numberButtons[i].setStyle("-fx-font-size: 18;");
            int finalI = i;
            numberButtons[i].setOnAction(e -> display.setText(display.getText() + finalI));
        }

        // Create function buttons
        addButton = new Button("+");
        subButton = new Button("-");
        mulButton = new Button("*");
        divButton = new Button("/");
        decButton = new Button(".");
        equButton = new Button("=");
        delButton = new Button("Del");
        clrButton = new Button("Clr");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        // Set styles for function buttons
        for (Button button : functionButtons) {
            button.setStyle("-fx-font-size: 18;");
        }

        // Add event handling
        addButton.setOnAction(e -> setOperator('+'));
        subButton.setOnAction(e -> setOperator('-'));
        mulButton.setOnAction(e -> setOperator('*'));
        divButton.setOnAction(e -> setOperator('/'));
        decButton.setOnAction(e -> display.setText(display.getText() + "."));
        equButton.setOnAction(e -> calculateResult());
        clrButton.setOnAction(e -> display.clear());
        delButton.setOnAction(e -> {
            String text = display.getText();
            if (text.length() > 0) {
                display.setText(text.substring(0, text.length() - 1));
            }
        });

        // Create layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        
        gridPane.add(numberButtons[1], 0, 0);
        gridPane.add(numberButtons[2], 1, 0);
        gridPane.add(numberButtons[3], 2, 0);
        gridPane.add(addButton, 3, 0);
        
        gridPane.add(numberButtons[4], 0, 1);
        gridPane.add(numberButtons[5], 1, 1);
        gridPane.add(numberButtons[6], 2, 1);
        gridPane.add(subButton, 3, 1);
        
        gridPane.add(numberButtons[7], 0, 2);
        gridPane.add(numberButtons[8], 1, 2);
        gridPane.add(numberButtons[9], 2, 2);
        gridPane.add(mulButton, 3, 2);
        
        gridPane.add(decButton, 0, 3);
        gridPane.add(numberButtons[0], 1, 3);
        gridPane.add(equButton, 2, 3);
        gridPane.add(divButton, 3, 3);

        VBox functionPanel = new VBox(10, delButton, clrButton);
        functionPanel.setAlignment(Pos.CENTER);
        functionPanel.setPadding(new Insets(10));

        VBox layout = new VBox(20, display, gridPane, functionPanel);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 400, 500);

        // Set up stage
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void setOperator(char operator) {
        this.num1 = Double.parseDouble(display.getText());
        this.operator = operator;
        display.clear();
    }

    private void calculateResult() {
        this.num2 = Double.parseDouble(display.getText());

        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        display.setText(String.valueOf(result));
        num1 = result;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
