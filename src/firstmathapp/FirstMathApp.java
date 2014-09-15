
package firstmathapp;

/**
 *
 * @author CTomsyck
 * 
 * Program is designed to practice addition, subtraction, multiplication, division, and solving quadratic equations
 * Program is made in javafx
 */

import static javafx.application.Application.launch;
import java.util.ArrayList;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class FirstMathApp extends Application {
    

    ArrayList<Integer> addNumbers1 = new ArrayList<>();
    ArrayList<Integer> addNumbers2 = new ArrayList<>();
    ArrayList<Integer> subtractNumbers1 = new ArrayList<>();
    ArrayList<Integer> subtractNumbers2 = new ArrayList<>();
    ArrayList<Integer> multiNumbers1 = new ArrayList<>();
    ArrayList<Integer> multiNumbers2 = new ArrayList<>();
    ArrayList<Integer> divNumbers1 = new ArrayList<>();
    ArrayList<Integer> divNumbers2 = new ArrayList<>();
    ArrayList<Integer> algebraNumbers1 = new ArrayList<>();
    ArrayList<Integer> algebraNumbers2 = new ArrayList<>();
    int addNum1, addNum2, subtractNum1, subtractNum2, multiNum1, multiNum2, divNum1, divNum2,
            quadA, quadB, quadC, temp1, root1, root2;
    String addNumber1, addNumber2, subtractNumber1, subtractNumber2, multiNumber1, multiNumber2,
            divNumber1, divNumber2, quadRoot1, quadRoot2;
    int countCorrect;

    @Override
    public void start(Stage primaryStage) {

        GridPane pane1 = new GridPane();
        GridPane pane2 = new GridPane();
        GridPane pane3 = new GridPane();
        GridPane pane4 = new GridPane();
        GridPane pane5 = new GridPane();
        GridPane pane6 = new GridPane();

        Scene scene1 = new Scene(pane1);
        Scene scene2 = new Scene(pane2);
        Scene scene3 = new Scene(pane3);
        Scene scene4 = new Scene(pane4);
        Scene scene5 = new Scene(pane5);
        Scene scene6 = new Scene(pane6);

        //main scene
        pane1.setPadding(new Insets(10));
        pane1.setHgap(10);
        pane1.setVgap(10);
        Label label1 = new Label("What would you like to practice today?");
        Button btAdd = new Button("Addition");
        btAdd.setPrefWidth(150);
        Button btSubtract = new Button("Subtraction");
        btSubtract.setPrefWidth(90);
        Button btMultiplication = new Button("Multiplication");
        btMultiplication.setPrefWidth(150);
        Button btDivision = new Button("Division");
        btDivision.setPrefWidth(90);
        Button btQuad = new Button("Quadratic Equations");
        btQuad.setPrefWidth(150);

        pane1.add(label1, 0, 0);
        pane1.add(btAdd, 0, 1);
        pane1.add(btSubtract, 1, 1);
        pane1.add(btMultiplication, 0, 2);
        pane1.add(btDivision, 1, 2);
        pane1.add(btQuad, 0, 3);

        primaryStage.setTitle("Math");
        primaryStage.setScene(scene1);
        primaryStage.show();

        btAdd.setOnMouseClicked(e -> {
            primaryStage.setTitle("Addition");
            primaryStage.setScene(scene2);
        });

        btSubtract.setOnMouseClicked(e -> {
            primaryStage.setTitle("Subtraction");
            primaryStage.setScene(scene3);
        });

        btMultiplication.setOnMouseClicked(e -> {
            primaryStage.setTitle("Multiplication");
            primaryStage.setScene(scene4);
        });

        btDivision.setOnMouseClicked(e -> {
            primaryStage.setTitle("Division");
            primaryStage.setScene(scene5);
        });

        btQuad.setOnMouseClicked(e -> {
            primaryStage.setTitle("Quadratic Equations");
            primaryStage.setScene(scene6);
        });

        //add numbers to arrays for use in addition, subtraction, and division
        //random numbers between 1 and 100
        for (int i = 1; i < 100; i++) {
            addNumbers1.add(i);
            addNumbers2.add(i);
            subtractNumbers1.add(i);
            subtractNumbers2.add(i);
            divNumbers1.add(i);
            divNumbers2.add(i);
        };

        //add numbers to arrays for use in multiplication
        for (int i = 0; i < 12; i++) {
            multiNumbers1.add(i);
            multiNumbers2.add(i);
        };

        //add numbers to arrays for quadratic equations
        for (int i = 10; i < 80; i++) {
            algebraNumbers1.add(i);
        }

        //addition scene
        Label lbAdd1 = new Label();
        Label lbAdd2 = new Label();
        Label lbAdd3 = new Label("=");
        Label lbAdd4 = new Label("+");
        Label lbAdd5 = new Label();
        Label lbAdd6 = new Label();
        pane2.add(lbAdd6, 2, 7);
        shuffleAdd();
        lbAdd1.setText(addNumber1);
        lbAdd2.setText(addNumber2);
        TextField tfAddAnswer = new TextField();
        tfAddAnswer.setText("0");
        tfAddAnswer.setPrefWidth(200);
        Button btAdd1 = new Button("Add");
        pane2.setPadding(new Insets(10));
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane2.add(lbAdd1, 2, 0);
        pane2.add(lbAdd2, 2, 1);
        pane2.add(lbAdd3, 1, 2);
        pane2.add(lbAdd4, 1, 1);
        pane2.add(tfAddAnswer, 2, 2);
        pane2.add(btAdd1, 3, 2);
        pane2.add(lbAdd5, 2, 3);
        Button btAdd2 = new Button("New Problem");
        pane2.add(btAdd2, 3, 3);
        Label lbCorrectAdd = new Label();
        lbCorrectAdd.setText("");
        pane2.add(lbCorrectAdd, 2, 5);
        Button btMain1 = new Button("Main Menu");
        pane2.add(btMain1, 2, 6);

        btAdd1.setOnMouseClicked(e -> {
            try {
                lbAdd6.setText("");
                int userAnswer = Integer.parseInt(tfAddAnswer.getText());
                int result = addNum1 + addNum2;
                if (userAnswer == result) {
                    lbAdd5.setText("Correct answer!");
                    countCorrect++;
                    String correct = Integer.toString(countCorrect);
                    lbCorrectAdd.setText("You answered " + correct + " problems correctly");
                } else {
                    lbAdd5.setText("Incorrect");
                }
            } catch (NumberFormatException error) {
                lbAdd6.setText("Please input an integer");
            }
        });

        btAdd2.setOnMouseClicked(e -> {
            pane2.getChildren().removeAll(lbAdd1, lbAdd2, lbAdd5, btAdd1);
            shuffleAdd();
            lbAdd5.setText("");
            lbAdd1.setText(addNumber1);
            lbAdd2.setText(addNumber2);
            pane2.getChildren().addAll(lbAdd1, lbAdd2, lbAdd5, btAdd1);
        });

        btMain1.setOnMouseClicked(e -> {
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene1);
        });

        //subtraction scene
        Label lbSubtract1 = new Label();
        Label lbSubtract2 = new Label();
        Label lbSubtract3 = new Label("=");
        Label lbSubtract4 = new Label("-");
        Label lbSubtract5 = new Label();
        Label lbSubtract6 = new Label();
        pane3.add(lbSubtract6, 2, 7);
        shuffleSubtract();
        while (subtractNum1 < subtractNum2) {
            shuffleSubtract();
        }
        lbSubtract1.setText(subtractNumber1);
        lbSubtract2.setText(subtractNumber2);
        TextField tfSubtractAnswer = new TextField();
        tfSubtractAnswer.setPrefWidth(200);
        tfSubtractAnswer.setText("0");
        Button btSubtract1 = new Button("Subtract");
        pane3.setPadding(new Insets(10));
        pane3.setHgap(10);
        pane3.setVgap(10);
        pane3.add(lbSubtract1, 2, 0);
        pane3.add(lbSubtract2, 2, 1);
        pane3.add(lbSubtract3, 1, 2);
        pane3.add(lbSubtract4, 1, 1);
        pane3.add(tfSubtractAnswer, 2, 2);
        pane3.add(btSubtract1, 3, 2);
        pane3.add(lbSubtract5, 2, 3);
        Button btSubtract2 = new Button("New Problem");
        pane3.add(btSubtract2, 3, 3);
        Label lbCorrectSubtract = new Label();
        lbCorrectSubtract.setText("");
        pane3.add(lbCorrectSubtract, 2, 5);
        Button btMain2 = new Button("Main Menu");
        pane3.add(btMain2, 2, 6);

        btSubtract1.setOnMouseClicked(e -> {
            try {
                lbSubtract6.setText("");
            int result1 = subtractNum1 - subtractNum2;
            int userAnswer1 = Integer.parseInt(tfSubtractAnswer.getText());
            if (userAnswer1 == result1) {
                lbSubtract5.setText("Correct answer!");
                countCorrect++;
                String correct = Integer.toString(countCorrect);
                lbCorrectSubtract.setText("You answered " + correct + " problems correctly");
            } else {
                lbSubtract5.setText("Incorrect");
            }
            } catch (NumberFormatException error) {
                lbSubtract6.setText("Please input an integer");
            }
        });

        btSubtract2.setOnMouseClicked(e -> {
            pane3.getChildren().removeAll(lbSubtract1, lbSubtract2, lbSubtract5, btSubtract1);
            shuffleSubtract();
            lbSubtract5.setText("");
            while (subtractNum1 < subtractNum2) {
                shuffleSubtract();
            }
            lbSubtract1.setText(subtractNumber1);
            lbSubtract2.setText(subtractNumber2);
            pane3.getChildren().addAll(lbSubtract1, lbSubtract2, lbSubtract5, btSubtract1);
        });

        btMain2.setOnMouseClicked(e -> {
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene1);
        });

        //Multiplication scene
        Label lbMultiplication1 = new Label();
        Label lbMultiplication2 = new Label();
        Label lbMultiplication3 = new Label("=");
        Label lbMultiplication4 = new Label("*");
        Label lbMultiplication5 = new Label();
        Label lbMultiplication6 = new Label();
        pane4.add(lbMultiplication6, 2, 7);
        shuffleMulti();
        lbMultiplication1.setText(multiNumber1);
        lbMultiplication2.setText(multiNumber2);
        TextField tfMultiplicationAnswer = new TextField();
        tfMultiplicationAnswer.setPrefWidth(200);
        tfMultiplicationAnswer.setText("0");
        Button btMultiplication1 = new Button("Multiply");
        pane4.setPadding(new Insets(10));
        pane4.setHgap(10);
        pane4.setVgap(10);
        pane4.add(lbMultiplication1, 2, 0);
        pane4.add(lbMultiplication2, 2, 1);
        pane4.add(lbMultiplication3, 1, 2);
        pane4.add(lbMultiplication4, 1, 1);
        pane4.add(tfMultiplicationAnswer, 2, 2);
        pane4.add(btMultiplication1, 3, 2);
        pane4.add(lbMultiplication5, 2, 3);
        Button btMultiplication2 = new Button("New Problem");
        pane4.add(btMultiplication2, 3, 3);
        Label lbCorrectMultiplication = new Label();
        lbCorrectMultiplication.setText("");
        pane4.add(lbCorrectMultiplication, 2, 5);
        Button btMain3 = new Button("Main Menu");
        pane4.add(btMain3, 2, 6);

        btMultiplication1.setOnMouseClicked(e -> {
            try {
                lbMultiplication6.setText("");
            int result2 = multiNum1 * multiNum2;
            int userAnswer2 = Integer.parseInt(tfMultiplicationAnswer.getText());
            if (userAnswer2 == result2) {
                lbMultiplication5.setText("Correct answer!");
                countCorrect++;
                String correct = Integer.toString(countCorrect);
                lbCorrectMultiplication.setText("You answered " + correct + " problems correctly");
            } else {
                lbMultiplication5.setText("Incorrect");
            }
            } catch (NumberFormatException error) {
                lbMultiplication6.setText("Please input an integer");
            }
        });

        btMultiplication2.setOnMouseClicked(e -> {
            pane4.getChildren().removeAll(lbMultiplication1, lbMultiplication2, lbMultiplication5, btMultiplication1);
            shuffleMulti();
            lbMultiplication5.setText("");
            lbMultiplication1.setText(multiNumber1);
            lbMultiplication2.setText(multiNumber2);
            pane4.getChildren().addAll(lbMultiplication1, lbMultiplication2, lbMultiplication5, btMultiplication1);
        });

        //need to fix
        btMain3.setOnMouseClicked(e -> {
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene1);
        });

        //division scene
        Label lbDivision1 = new Label();
        Label lbDivision2 = new Label();
        Label lbDivision3 = new Label("=");
        Label lbDivision4 = new Label("/");
        Label lbDivision5 = new Label();
        Label lbDivision6 = new Label();
        pane5.add(lbDivision6, 2, 7);
        shuffleDiv();
        while (divNum1 < divNum2) {
            shuffleDiv();
        }

        while (divNum1 % divNum2 != 0) {
            shuffleDiv();
        }
        lbDivision1.setText(divNumber1);
        lbDivision2.setText(divNumber2);
        TextField tfDivisionAnswer = new TextField();
        tfDivisionAnswer.setPrefWidth(200);
        tfDivisionAnswer.setText("0");
        Button btDivision1 = new Button("Divide");
        pane5.setPadding(new Insets(10));
        pane5.setHgap(10);
        pane5.setVgap(10);
        pane5.add(lbDivision1, 2, 0);
        pane5.add(lbDivision2, 2, 1);
        pane5.add(lbDivision3, 1, 2);
        pane5.add(lbDivision4, 1, 1);
        pane5.add(tfDivisionAnswer, 2, 2);
        pane5.add(btDivision1, 3, 2);
        pane5.add(lbDivision5, 2, 3);
        Button btDivision2 = new Button("New Problem");
        pane5.add(btDivision2, 3, 3);
        Label lbCorrectDivision = new Label();
        lbCorrectDivision.setText("");
        pane5.add(lbCorrectDivision, 2, 5);
        Button btMain4 = new Button("Main Menu");
        pane5.add(btMain4, 2, 6);

        btDivision1.setOnMouseClicked(e -> {
            try {
                lbDivision6.setText("");
            int result3 = divNum1 / divNum2;
            int userAnswer3 = Integer.parseInt(tfDivisionAnswer.getText());
            if (userAnswer3 == result3) {
                lbDivision5.setText("Correct answer!");
                countCorrect++;
                String correct = Integer.toString(countCorrect);
                lbCorrectDivision.setText("You answered " + correct + " problems correctly");
            } else {
                lbDivision5.setText("Incorrect");
            }
            } catch (NumberFormatException error) {
                lbDivision6.setText("Please input an integer");
            }
        });

        btDivision2.setOnMouseClicked(e -> {
            pane5.getChildren().removeAll(lbDivision1, lbDivision2, lbDivision5, btDivision1);

            shuffleDiv();
            while (divNum1 < divNum2) {
                shuffleDiv();
            }

            while (divNum1 % divNum2 != 0) {
                shuffleDiv();
            }

            lbDivision5.setText("");
            lbDivision1.setText(divNumber1);
            lbDivision2.setText(divNumber2);
            pane5.getChildren().addAll(lbDivision1, lbDivision2, lbDivision5, btDivision1);
        });

        btMain4.setOnMouseClicked(e -> {
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene1);
        });

        //Quadratic Equations scene
        Label lbQuad1 = new Label();
        Label lbQuad2 = new Label("                        x = ");
        Label lbQuad3 = new Label("                        x = ");
        Label lbQuad4 = new Label();
        Label lbCorrectQuad = new Label();
        Label lbQuad6 = new Label();
        pane6.add(lbQuad6, 3, 5);
        pane6.add(lbCorrectQuad, 3, 4);
        pane6.add(lbQuad4, 3, 3);
        pane6.setPadding(new Insets(10));
        pane6.setHgap(10);
        pane6.setVgap(10);
        shuffleQuad();
        lbQuad1.setText("x² + " + quadB + "x + " + quadC + " = 0");
        pane6.add(lbQuad1, 2, 0);
        pane6.add(lbQuad2, 2, 1);
        pane6.add(lbQuad3, 2, 2);
        TextField tfQuadAnswer1 = new TextField();
        tfQuadAnswer1.setPrefWidth(200);
        tfQuadAnswer1.setText("0");
        TextField tfQuadAnswer2 = new TextField();
        tfQuadAnswer2.setPrefWidth(200);
        tfQuadAnswer2.setText("0");
        pane6.add(tfQuadAnswer1, 3, 1);
        pane6.add(tfQuadAnswer2, 3, 2);
        Button btQuad1 = new Button("Solve");
        pane6.add(btQuad1, 2, 3);
        Button btQuad2 = new Button("New Problem");
        pane6.add(btQuad2, 2, 4);
        Button btQuad3 = new Button("Main Menu");
        pane6.add(btQuad3, 2, 5);

        btQuad3.setOnMouseClicked(e -> {
            primaryStage.setTitle("Main Menu");
            primaryStage.setScene(scene1);
        });

        btQuad2.setOnMouseClicked(e -> {
            shuffleQuad();
            lbQuad1.setText("x² + " + quadB + "x + " + quadC + " = 0");
        });

        btQuad1.setOnMouseClicked(e -> {
             try {
                lbQuad6.setText("");
            int results4 = root1;
            int results5 = root2;
            int userAnswer4 = Integer.parseInt(tfQuadAnswer1.getText());
            int userAnswer5 = Integer.parseInt(tfQuadAnswer2.getText());
            if (((userAnswer4 == results4) && (userAnswer5 == results5)) || ((userAnswer5 == results4) && (userAnswer4 == results5))) {
                lbQuad4.setText("Correct Answer!");
                countCorrect++;
                String correct = Integer.toString(countCorrect);
                lbCorrectQuad.setText("You answered " + correct + " problems correctly");
            } else {
                lbQuad4.setText("incorrect");
            }
            } catch (NumberFormatException error) {
                lbQuad6.setText("Please input an integer");
            }

        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void shuffleAdd() {
        Collections.shuffle(addNumbers1);
        Collections.shuffle(addNumbers2);
        addNum1 = addNumbers1.get(0);
        addNumber1 = Integer.toString(addNum1);
        addNum2 = addNumbers2.get(0);
        addNumber2 = Integer.toString(addNum2);
    }

    public void shuffleSubtract() {
        Collections.shuffle(subtractNumbers1);
        Collections.shuffle(subtractNumbers2);
        subtractNum1 = subtractNumbers1.get(0);
        subtractNumber1 = Integer.toString(subtractNum1);
        subtractNum2 = subtractNumbers2.get(0);
        subtractNumber2 = Integer.toString(subtractNum2);
    }

    public void shuffleMulti() {
        Collections.shuffle(multiNumbers1);
        Collections.shuffle(multiNumbers2);
        multiNum1 = multiNumbers1.get(0);
        multiNumber1 = Integer.toString(multiNum1);
        multiNum2 = multiNumbers2.get(0);
        multiNumber2 = Integer.toString(multiNum2);
    }

    public void shuffleDiv() {
        Collections.shuffle(divNumbers1);
        Collections.shuffle(divNumbers2);
        divNum1 = divNumbers1.get(0);
        divNumber1 = Integer.toString(divNum1);
        divNum2 = divNumbers2.get(0);
        divNumber2 = Integer.toString(divNum2);
    }

    public void shuffleQuad() {
        Collections.shuffle(algebraNumbers1);
        algebraNumbers2.clear();
        quadA = 1;
        quadC = algebraNumbers1.get(0);
        //quadB = 0;

        for (int i = 1; i <= quadC; i++) {
            if (quadC % i == 0) {
                System.out.println(i);
                algebraNumbers2.add(i);
            }
        }

        while (algebraNumbers2.size() == 2) {
            algebraNumbers2.clear();
            Collections.shuffle(algebraNumbers1);
            quadC = algebraNumbers1.get(0);
            for (int i = 1; i <= quadC; i++) {
                if (quadC % i == 0) {
                    System.out.println(i);
                    algebraNumbers2.add(i);

                }
            }
        }

        //probably could have looped here
        if (algebraNumbers2.size() == 12) {
            quadB = algebraNumbers2.get(5) + algebraNumbers2.get(6);
        }
        if (algebraNumbers2.size() == 11) {
            quadB = algebraNumbers2.get(5) + algebraNumbers2.get(5);
        }
        if (algebraNumbers2.size() == 10) {
            quadB = algebraNumbers2.get(4) + algebraNumbers2.get(5);
        }
        if (algebraNumbers2.size() == 9) {
            quadB = algebraNumbers2.get(4) + algebraNumbers2.get(4);
        }
        if (algebraNumbers2.size() == 8) {
            quadB = algebraNumbers2.get(3) + algebraNumbers2.get(4);
        }
        if (algebraNumbers2.size() == 7) {
            quadB = algebraNumbers2.get(3) + algebraNumbers2.get(3);
        }
        if (algebraNumbers2.size() == 6) {
            quadB = algebraNumbers2.get(2) + algebraNumbers2.get(3);
        }
        if (algebraNumbers2.size() == 5) {
            quadB = algebraNumbers2.get(2) + algebraNumbers2.get(2);
        }
        if (algebraNumbers2.size() == 4) {
            quadB = algebraNumbers2.get(1) + algebraNumbers2.get(2);
        }
        if (algebraNumbers2.size() == 3) {
            quadB = algebraNumbers2.get(1) + algebraNumbers2.get(1);
        }

        System.out.println(algebraNumbers2.size());

        //temp1 = Math.sqrt(b * b - 4 * a * c);
        temp1 = (int) java.lang.Math.sqrt(quadB * quadB - 4 * quadA * quadC);

        root1 = (-quadB + temp1) / (2 * quadA);
        root2 = (-quadB - temp1) / (2 * quadA);
        System.out.println(root1);
        System.out.println(root2);
    }
}

