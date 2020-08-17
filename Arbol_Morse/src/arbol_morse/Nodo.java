/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_morse;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author josue
 */
public class Nodo {
    private Circle circle;
    private Label letter;
    private double x;
    private double y;
    private final ArrayList<Node> elements = new ArrayList<>();
    
    
    public Nodo(double x,double y,String label){
        this.x = x;
        this.y = y;
        letter = new Label(label);
        letter.setTextFill(Color.WHITE);
        letter.setLayoutX(this.x-3);
        letter.setLayoutY(this.y-9);
        circle = new Circle(this.x,this.y,20);
        elements.add(circle);
        elements.add(letter);
    }
    
    public ObservableList<Node> getChildren() {
        return FXCollections.observableArrayList(elements);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Label getLetter() {
        return letter;
    }

    public void setLetter(Label letter) {
        this.letter = letter;
    }
    
    
}

