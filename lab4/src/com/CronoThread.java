package com;

import javax.swing.*;

public class CronoThread extends Thread {

    private int hh;
    private int mm;
    private int ss;
    private JLabel textLabel;

    public CronoThread(JLabel textLabel) {
        reset();
        this.textLabel = textLabel;
    }

    public void write() {
        textLabel.setText(String.format("%02d", hh) + ":" +  String.format("%02d", mm) + ":" +  String.format("%02d", ss));
    }

    public void reset() {
        this.hh = this.mm = this.ss = 0;
    }

    @Override
    public void run() {
        while(true) {
            if(ss == 59) {
                ss = 0;
                mm++;
                if(mm == 60) {
                    mm = 0;
                    hh++;
                }
            }
            ss++;
            write();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
