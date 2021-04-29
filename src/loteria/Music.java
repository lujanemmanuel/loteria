/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loteria;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
/**
 *
 * @author HP
 */
public class Music implements Runnable {
    public    List <String> Carta_maquina = new ArrayList();
            public static String[] Canciones={"adios", "bamba", "cascabel", "cielito", "mariachi", "mozart", "manera", "playa", "bikina", "cucaracha"};

    @Override
    public void run() {
        try {
            
            while (true){
            int cant = (int)(10*Math.random()+0);
            
            FileInputStream fis;
            Player player;
            String cancion=System.getProperty("user.dir")+"/src/Sound/Songs/"+Canciones[cant]+".mp3";
            fis = new FileInputStream(cancion);
            
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            player = new Player(bis);
                player.play();
            }
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        
        }

    
    
       // throw new UnsupportedOperationException("Not supported yet.");
    }
    /**
     *
     * @param a
     */
    public static void main (String a[]){
        Music reproduce = new Music();
        Thread play = new Thread(reproduce);
        play.start();
    }
    
}

