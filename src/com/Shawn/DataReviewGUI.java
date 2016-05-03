package com.Shawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wolfknightx on 4/25/2016.
 * From here the user will be able to update the information they have entered.
 */
public class DataReviewGUI extends JFrame{
    private JPanel rootPanel;
    private JButton printButton;
    private JButton closeButton;
    private JButton removeSelectionButton;
    private JTable table1;

    DataReviewGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        //set up the buttons for the application
        buttonconfig();

    }

    public void buttonconfig(){
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        removeSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Logging Admin out");
                OpeningPageGUI opGUI = new OpeningPageGUI(); //log the admin out and go back to the screen
                opGUI.setVisible(true);
                setVisible(false);
            }
        });
    }
}
