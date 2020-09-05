/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import models.Nodo;
import models.Arrow;
import main.ArbolMorse;
import models.MorseTree;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 *
 * @author josue
 */
public class TDAUtil {
    private TDAUtil(){}
    public static Map<String,String> leerMapaArchivo(String nombreArchivo){
        HashMap<String,String> hm = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String line = br.readLine();
            while(line!=null){
                String[] arr = line.split("\\|");
                String value = hm.get(arr[0]);
                if(value == null){
                    hm.put(arr[0],arr[1]);
                }
                line = br.readLine();
            }
            return hm;
        }catch(Exception e){
            Logger.getLogger(e.getMessage());
        }
        return null;
    }
    
    public static void amarArbolArchivo(MorseTree tree,String nombreArchivo){
        try(BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))){
            String line = br.readLine();
            while(line!=null){
                String[] arr = line.split("\\|");
                tree.add(arr[0], arr[1],Double.valueOf(arr[2]),Double.valueOf(arr[3]));
                line = br.readLine();
            }
        }catch(Exception e){
            Logger.getLogger(e.getMessage());
        }
    }
    
    public static void connectLeft(Nodo n1, Nodo n2){
        Arrow f = new Arrow(n1.getX()-20,n1.getY(),n2.getX(),n2.getY()-20);
        ArbolMorse.root.getChildren().addAll(f.getChildren());
    }
    
    public static void connectRight(Nodo n1, Nodo n2){
        Arrow f = new Arrow(n1.getX()+20,n1.getY(),n2.getX(),n2.getY()-20);
        ArbolMorse.root.getChildren().addAll(f.getChildren());
    }
}
