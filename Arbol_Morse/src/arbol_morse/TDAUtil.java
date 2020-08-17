/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol_morse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import javafx.scene.Group;


/**
 *
 * @author josue
 */
public class TDAUtil {
    
    public static HashMap<String,String> leerMapaArchivo(String nombreArchivo){
        HashMap<String,String> hm = new HashMap<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String line = br.readLine();
            while(line!=null){
                String[] arr = line.split("\\|");
                System.out.println(line);
                String value = hm.get(arr[0]);
                if(value == null){
                    hm.put(arr[0],arr[1]);
                }
                line = br.readLine();
            }
            return hm;
        }catch(Exception e){
        System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void amarArbolArchivo(MorseTree tree,String nombreArchivo){
        try{
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String line = br.readLine();
            while(line!=null){
                String[] arr = line.split("\\|");
                tree.add(arr[0], arr[1],Double.valueOf(arr[2]),Double.valueOf(arr[3]));
                line = br.readLine();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void connectLeft(Nodo n1, Nodo n2){
        Arrow f = new Arrow(n1.getX()-20,n1.getY(),n2.getX(),n2.getY()-20);
        Arbol_Morse.root.getChildren().addAll(f.getChildren());
    }
    
    public static void connectRight(Nodo n1, Nodo n2){
        Arrow f = new Arrow(n1.getX()+20,n1.getY(),n2.getX(),n2.getY()-20);
        Arbol_Morse.root.getChildren().addAll(f.getChildren());
    }
}
