/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_morse;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.*;

/**
 *
 * @author josue
 */
public class Arbol_Morse extends Application {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Pane p = new Pane();
        Scene scene = new Scene(root,1200,700);
        primaryStage.setTitle("INICIO");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        Nodo n = new Nodo(scene.getWidth(),scene.getHeight()*1.75,1);
        Nodo n2 = new Nodo(scene.getWidth(),scene.getHeight()*1.75,0);
        Nodo n3 = new Nodo(scene.getWidth(),scene.getHeight()*1.75,0);
        Nodo n4 = new Nodo(scene.getWidth(),scene.getHeight()*1.75,1);
        
        connect(n,n2,root);
        connect(n2,n3,root);
        connect(n3,n4,root);
        root.getChildren().addAll(n3.getChildren());
        root.getChildren().addAll(n4.getChildren());
        root.getChildren().addAll(n.getChildren());
        root.getChildren().addAll(n2.getChildren());

       // bending curve
       
       
       //x,y,-----x,y

       
        Circle c = new Circle(300,300,50);
        
        
    }
    
    public void connect(Nodo n1, Nodo n2,Group root){
        Arrow f = new Arrow(n1.getX()-20,n1.getY(),n2.getX()+20,n2.getY());
        root.getChildren().addAll(f.getChildren());
    }
    
    
}
