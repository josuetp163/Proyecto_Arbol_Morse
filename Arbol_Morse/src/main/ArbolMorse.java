/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import models.MorseTree;
import util.Constantes;
import util.HiloCodificar;
import util.TDAUtil;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.*;

/**
 *
 * @author josue
 */
public class ArbolMorse extends Application {
    public static final Group root = new Group();
    public static final MorseTree tree = new MorseTree();
    public static final Map<String,String> map = TDAUtil.leerMapaArchivo(Constantes.TRADUCCIONES);
    public static final Label lb = new Label("");
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root,1300,700);
        primaryStage.setTitle("ARBOL MORSE");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void init(){
        TDAUtil.amarArbolArchivo(tree,Constantes.TRADUCCIONES);
        TextField tf = new TextField();
        tf.setPromptText("INGRESAR TEXTO A CODIFICAR");
        tf.setLayoutX(30);
        tf.setLayoutY(30);
        tf.setMinWidth(200);
        Button bt = new Button("CODIFICAR");
        bt.setLayoutX(30);
        bt.setLayoutY(80);
        bt.setOnMouseClicked(e->{
            HiloCodificar hc = new HiloCodificar(tf.getText());
            Thread hiloCodi= new Thread(hc);
            hiloCodi.start();
        });
        lb.setLayoutX(250);
        lb.setLayoutY(35);
        Label title = new Label("ARBOL MORSE");
        title.setLayoutX(900);
        title.setLayoutY(35);
        root.getChildren().addAll(bt,tf,lb,title);
        setUserAgentStylesheet(Constantes.RUTASTYLE);
    }
   
}
