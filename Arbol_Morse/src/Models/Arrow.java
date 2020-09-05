/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Shape;

/**
 *
 * @author josue
 */
public class Arrow extends Shape{
    private final ArrayList<Node> elements;
    
    public Arrow(double iniX,double iniY,double finX,double finY){
       CubicCurve curve1 = new CubicCurve( iniX, iniY, iniX-25, iniY+35, finX+35, finY-25, finX, finY);
       curve1.setStroke(Color.BLACK);
       curve1.setStrokeWidth(1);    
       curve1.setFill(null);
      
       elements = new ArrayList<>();
       elements.add(curve1);
    }
    
    public ObservableList<Node> getChildren() {
        return FXCollections.observableArrayList(elements);
    }
    
}
