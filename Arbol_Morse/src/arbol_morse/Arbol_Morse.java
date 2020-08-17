/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_morse;

import java.util.HashMap;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.*;

/**
 *
 * @author josue
 */
public class Arbol_Morse extends Application {
    public MorseTree tree;
    public static Group root;
    
    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        
        root = new Group();
        tree = new MorseTree();
        TDAUtil.amarArbolArchivo(tree,"./src/arbol_morse/traducciones.txt");
        tree.inOrden();
        Scene scene = new Scene(root,1300,700);
        primaryStage.setTitle("INICIO");
        primaryStage.setScene(scene);
        primaryStage.show();       
    }
}
