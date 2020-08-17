package arbol_morse;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.LinkedList;

public class MorseTree{
    private Node root;

    private class Node{
        private Nodo nodo;
        private String letter;
        private String code;
        private Node left;
        private Node right;

        public Node(String letter,String code){
            this.letter = letter;
            this.code = code;
        }
    }
    
    public MorseTree(){
        Nodo n = new Nodo(600,100,"INI");
        root = new Node("Inicio","");
        root.nodo = n;
        Arbol_Morse.root.getChildren().addAll(n.getChildren());
    }

    public boolean add(String letter,String code,double x,double y){
        Node nc = searchNode(code);
        if(nc != null) return false;
        nc = new Node(letter,code);
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
                Arbol_Morse.root.getChildren().addAll(nc.nodo.getChildren());
                return true;
            }else if(a == '.'){
                n.right = nc;
                TDAUtil.connectRight(n.nodo,nc.nodo);
                Arbol_Morse.root.getChildren().addAll(nc.nodo.getChildren());
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


    public void preOrden(){
        preOrden(root);
    }
    private void preOrden(Node n){
        if(n!=null){
            System.out.println(n.letter);
            preOrden(n.left);
            preOrden(n.right);
        }
    }
    
    public void inOrden(){
        inOrden(root);
    }
    private void inOrden(Node n){
        if(n!=null){
            inOrden(n.left);
            System.out.println(n.letter);
            inOrden(n.right);
        }
    }
    public void postOrden(){
        postOrden(root);
    }
    private void postOrden(Node n){
        if(n!=null){
            postOrden(n.left);
            postOrden(n.right);
            System.out.println(n.letter);
        }
    }
}
