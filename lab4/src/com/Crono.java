package com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crono {

    private JPanel cronoPanel;
    private JPanel mainPanel;
    private JLabel textLabel;
    private JButton startBtn;
    private JButton pauseBtn;
    private JButton resetbtn;

    private CronoThread cronometer;

    public Crono() {

        cronometer = new CronoThread(textLabel);

        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cronometer.getState() == Thread.State.TERMINATED) {
                    cronometer = new CronoThread(textLabel);
                }
                cronometer.start();
            }
        });

        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometer.stop();
            }
        });

        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cronometer.reset();
            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Crono");
        frame.setContentPane(new Crono().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
