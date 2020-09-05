/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainApp;

import models.MorseTree;
import util.Constantes;
import util.HiloCodificar;
import util.TDAUtil;
import java.util.HashMap;
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
    public static MorseTree tree;
    public static Group root;
    public static HashMap<String,String> map;
    public TextField tf;
    public Button bt;
    public static Label lb;
    public static Label title;
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root,1300,700);
        primaryStage.setTitle("ARBOL MORSE");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        bt.setOnMouseClicked(e->{
            HiloCodificar hc = new HiloCodificar(tf.getText());
            Thread hiloCodi= new Thread(hc);
            hiloCodi.start();
        });
        
    }
    
    @Override
    public void init(){
        root = new Group();
        tree = new MorseTree();
        TDAUtil.amarArbolArchivo(tree,Constantes.TRADUCCIONES);
        map = TDAUtil.leerMapaArchivo(Constantes.TRADUCCIONES);
        tf = new TextField();
        tf.setPromptText("INGRESAR TEXTO A CODIFICAR");
        tf.setLayoutX(30);
        tf.setLayoutY(30);
        tf.setMinWidth(200);
        bt = new Button("CODIFICAR");
        bt.setLayoutX(30);
        bt.setLayoutY(80);
        lb = new Label("");
        lb.setLayoutX(250);
        lb.setLayoutY(35);
        title = new Label("ARBOL MORSE");
        title.setLayoutX(900);
        title.setLayoutY(35);
        root.getChildren().addAll(bt,tf,lb,title);
        setUserAgentStylesheet(Constantes.RUTASTYLE);
    }
}
