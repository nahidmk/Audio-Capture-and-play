package com.company;

import javax.sound.sampled.*;
import java.io.*;

public class PlayMusic {

      void play(long RECORD_TIME)  {

         Thread stopper = new Thread(new Runnable() {
             public void run() {
                 try {
                     Thread.sleep(RECORD_TIME);
                 } catch (InterruptedException ex) {
                     ex.printStackTrace();
                 }
             }
         });

        try {
            File path = new File("C:\\Users\\Nahid\\Desktop\\Spring-Security-main\\Spring-Security-main\\Voice Recoder\\RecordAudio.wav");
            if(path.exists())
            {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(path);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
                stopper.start();

            }
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }



    }

}

