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
import javafx.scene.shape.Circle;

/**
 *
 * @author josue
 */
public class Nodo {
    private double x;
    private double y;
    static int levelx = 2;
    static int levely = 2;
    private final ArrayList<Node> elements; 
    
    public Nodo(double x,double y,int a){
        if(a==0){
            this.x = x/levelx;
            this.y = y/levely;
        }else{
            this.x = (x/levelx)*(levelx-1);
            this.y = y/levely;
        }
        
        Circle c = new Circle(this.x,this.y,20);
        elements = new ArrayList<>();
        elements.add(c);
        levelx++;levely++;
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

    public static int getLevelx() {
        return levelx;
    }

    public static void setLevelx(int levelx) {
        Nodo.levelx = levelx;
    }

    public static int getLevely() {
        return levely;
    }

    public static void setLevely(int levely) {
        Nodo.levely = levely;
    }
    
    
    
    
}

