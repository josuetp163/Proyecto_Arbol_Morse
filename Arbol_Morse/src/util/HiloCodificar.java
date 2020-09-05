/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import mainApp.ArbolMorse;
import models.MorseTree;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

/**
 *
 * @author josue
 */
public class HiloCodificar implements Runnable{
    
    String txt;
    StringBuilder traduccion;

    public HiloCodificar(String txt) {
        this.txt = txt;
        traduccion = new StringBuilder();
    }
    
    
    @Override
    public void run() {
        CharacterIterator it = new StringCharacterIterator(txt.toUpperCase());
        char a;
        String code;
        
        while(it.current()!= CharacterIterator.DONE){
            a= it.current();
            code = ArbolMorse.map.get(String.valueOf(a));
            if(code != null && !code.equals("")){
                ArbolMorse.tree.recorrer(code);
                traduccion.append(code);
                Platform.runLater(()->{ArbolMorse.lb.setText(traduccion.toString());});
                it.next();
                try {
                    Thread.sleep(code.length()*1500L);
                }catch(InterruptedException ex) {
                    Logger.getLogger(MorseTree.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt(); 
                }
            }   
        }
    }
    
}
