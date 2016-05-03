package com.Shawn;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wolfknightx on 4/25/2016.
 * From here the user will be able to log changes to their application for fitness and play with their Monsters.
 */
public class MainStageGUI extends JFrame{
    private JPanel rootPanel;
    private JButton btnPrint;
    private JButton btnNewExcersise;
    private JButton btnNewWaterLog;
    private JButton btnQuit;
    private JButton btnReviewData;
    private JButton btnNewHeight;
    private JButton btnNewMeasurements;
    private JButton btnNewWeight;
    private JButton btnPlayTTT;
    private JPanel pnlPictureBox;

    MainStageGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        //access the set buttons.
        buttonConfig();

    }

    public void buttonConfig(){
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnReviewData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();

                // TODO insure that when this window is opened that only the ADMIN has rights to alter the tables.
            }
        });
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel,"Going back to main page.", "Cancel",JOptionPane.CANCEL_OPTION);
                OpeningPageGUI opGUI = new OpeningPageGUI(); //cancel out of this screen and open up the main page.
                opGUI.setVisible(true);
                setVisible(false);
            }
        });
        btnNewExcersise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnNewMeasurements.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnPlayTTT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnNewWaterLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnNewHeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
        btnNewWeight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nonFunction();
            }
        });
    }

    public void nonFunction(){
        JOptionPane.showMessageDialog(rootPanel, "Function not ready yet.", "Pending Operation",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
