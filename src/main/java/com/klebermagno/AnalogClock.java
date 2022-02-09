package com.klebermagno;

import javax.swing.*;
import java.util.Date;


/** Represents an Analog Clock..
 * @author Kleber Magno Maciel Vieira
 * @author klebermagno@me.com
 * @version 1.0.0
 */
public class AnalogClock extends javax.swing.JFrame {


    public int hour;
    public int digitalHour;
    public int min;
    public int sec;
    public int width = 510;
    public int height = 530;
    public int center = 245;
    ClockDial clockDial;

    /**
     * Creates an AnalogClock.
     */
    public AnalogClock() {
        setTitle("Watchface test");
        setSize(width,height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        clockDial =new ClockDial(this);
        getContentPane().add(clockDial);
        Date curr=new Date();
        String time=curr.toString();
        digitalHour=Integer.parseInt(time.substring(11,13));
        hour=Integer.parseInt(time.substring(11,13));
        min=Integer.parseInt(time.substring(14,16));
        sec=Integer.parseInt(time.substring(17,19));
        ClockEngine.setPriority(ClockEngine.getPriority()+3);
        ClockEngine.start();
    }

    /**
     * Main method to run the application.
     * @param args initial args.
     */
    public static void main(String args[]) {
        new AnalogClock().setVisible(true);
    }

    /**
     * Thread to update the clock.
     */
    Thread ClockEngine=new Thread() {
        int newsec,newmin;

        /**
         * Update loop.
         */
        public void run() {
            while(true)
            {
                newsec=(sec+1)%60;
                newmin=(min+(sec+1)/60)%60;
                hour=(hour+(min+(sec+1)/60)/60)%12;
                sec=newsec;
                min=newmin;

                try {

                    Thread.sleep(1000);

                } catch (InterruptedException ex) {}

                clockDial.repaint();
            }
        }
    };
}

