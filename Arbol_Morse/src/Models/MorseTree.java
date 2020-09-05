package models;

import util.TDAUtil;
import util.Constantes;
import main.ArbolMorse;
import java.io.File;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

public class MorseTree{
    private final Node root;

    private class Node{
        private Nodo nodo;
        private Node left;
        private Node right;
    }
    
    public MorseTree(){
        Nodo n = new Nodo(600,100,"MT");
        root = new Node();
        root.nodo = n;
        ArbolMorse.root.getChildren().addAll(n.getChildren());
    }

    public boolean add(String letter,String code,double x,double y){
        Node nc = searchNode(code);
        if(nc != null) return false;
        nc = new Node();
        Nodo nodo = new Nodo(x,y,letter);
        nc.nodo = nodo;
        CharacterIterator it = new StringCharacterIterator(code);
        char a;
        Node n = root;
        while(it.next() != CharacterIterator.DONE){
            a= it.previous();
            if(a == '-'){
                n = n.left;
            }else if(a == '.'){
                n = n.right;
            }
            it.next();
        }
        a = it.previous();
        if(a == '-'){
                n.left = nc;
                TDAUtil.connectLeft(n.nodo,nc.nodo);
                ArbolMorse.root.getChildren().addAll(nc.nodo.getChildren());
                return true;
            }else if(a == '.'){
                n.right = nc;
                TDAUtil.connectRight(n.nodo,nc.nodo);
                ArbolMorse.root.getChildren().addAll(nc.nodo.getChildren());
                return true;
            }
        return false;
    }

    private Node searchNode(String code){
        Node n = root;
        for(char a : code.toCharArray()){
            if(n==null){
                return n;
            }
            if(a == '-'){
                n = n.left;
            }else if(a == '.'){
                n = n.right;
            }
        }
        return n;
    }

    public int size(){
        return size(root);
    }
    
    private int size(Node n){
        if(n == null) return 0;
        else{
            return 1+size(n.right)+size(n.left);
        }
    }

    public int height(){
        return height(root);
    }
    private int height(Node n){
        if(n == null) return 0;
        return 1 + Math.max(height(n.left),height(n.right));
    }
    
    public void recorrer(String code){
        HiloRecorrer hilo = new HiloRecorrer(code);
        Thread hiloReco= new Thread(hilo);
        hiloReco.start();
    }
    
    public class HiloRecorrer implements Runnable{
        private String code;
        private Node n;
        
        public HiloRecorrer(String code){
            this.code = code;
        }
        
        @Override
        public void run() {
            CharacterIterator it = new StringCharacterIterator(code);
            String uriLine = new File(Constantes.URILINE).toURI().toString();
            String uriDot = new File(Constantes.URIDOT).toURI().toString();
            MediaPlayer player;
            char a;
            n = root;
            while(it.current()!= CharacterIterator.DONE){
                try {
                    Thread.sleep(500);
                }catch(InterruptedException ex) {
                    Logger.getLogger(MorseTree.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt();
                }
                a= it.current();
                if(a == '-'){
                    n = n.left;
                    try{
                        player = new MediaPlayer( new Media(uriLine));
                        player.play();
                    }catch(NullPointerException ex){}
                    
                }else if(a == '.'){
                    n = n.right;
                    try{
                        player = new MediaPlayer( new Media(uriDot));
                        player.play();
                    }catch(NullPointerException ex){}
                }
                Platform.runLater(()->{n.nodo.getCircle().setFill(Color.valueOf("#2E9C9C"));});
                it.next();
                try {
                    Thread.sleep(1000);
                }catch(InterruptedException ex) {
                    Logger.getLogger(MorseTree.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt();
                }
                Platform.runLater(()->{n.nodo.getCircle().setFill(Color.BLACK);});

            }
        }
    }
}
