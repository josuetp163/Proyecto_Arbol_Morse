/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Shape;

/**
 *
 * @author josue
 */
public class Arrow extends Shape{
    private double iniX;
    private double iniY;
    private double finX;
    private double finY;
    private final ArrayList<Node> elements;
    
    public Arrow(double iniX,double iniY,double finX,double finY){
       CubicCurve curve1 = new CubicCurve( iniX, iniY, iniX-25, iniY+35, finX+35, finY-25, finX, finY);
       curve1.setStroke(Color.BLACK);
       curve1.setStrokeWidth(1);    
       curve1.setFill(null);
      
       elements = new ArrayList<>();
       elements.add(curve1);
    }
    
    private Point2D eval(CubicCurve c, float t){
       Point2D p=new Point2D(Math.pow(1-t,3)*c.getStartX()+
               3*t*Math.pow(1-t,2)*c.getControlX1()+
               3*(1-t)*t*t*c.getControlX2()+
               Math.pow(t, 3)*c.getEndX(),
               Math.pow(1-t,3)*c.getStartY()+
               3*t*Math.pow(1-t, 2)*c.getControlY1()+
               3*(1-t)*t*t*c.getControlY2()+
               Math.pow(t, 3)*c.getEndY());
       return p;
}
    
    private Point2D evalDt(CubicCurve c, float t){
       Point2D p=new Point2D(-3*Math.pow(1-t,2)*c.getStartX()+
               3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlX1()+
               3*((1-t)*2*t-t*t)*c.getControlX2()+
               3*Math.pow(t, 2)*c.getEndX(),
               -3*Math.pow(1-t,2)*c.getStartY()+
               3*(Math.pow(1-t, 2)-2*t*(1-t))*c.getControlY1()+
               3*((1-t)*2*t-t*t)*c.getControlY2()+
               3*Math.pow(t, 2)*c.getEndY());
       return p;
}
    
    public ObservableList<Node> getChildren() {
        return FXCollections.observableArrayList(elements);
    }
    
}
