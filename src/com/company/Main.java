package com.company;

//import static com.company.Sound_In.RECORD_TIME;

public class Main {

    public static void main(String[] args) {


         final long RECORD_TIME = 10000;

        final SoundCapture recorder = new SoundCapture();
        final PlayMusic playMusic  = new PlayMusic();

        Thread stopper = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(RECORD_TIME);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                recorder.finish();
                playMusic.play(RECORD_TIME);

            }
        });

        stopper.start();

        recorder.start();
    }
}
