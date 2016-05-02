package com.Shawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wolfknightx on 4/25/2016.
 * This form will be used for users to create a new account and sign on.
 */
public class CreateNewUserGUI extends JFrame{
    private JPanel rootPanel;
    private JButton btnEnter;
    private JButton btnCancel;
    private JButton btnClear;
    private JTextField txtUserName;
    private JTextField txtLogin;
    private JTextField txtPassword;
    private JTextField txtHeight;
    private JTextField txtWeight;
    private JComboBox cmbxMonth;
    private JComboBox cmbxDay;
    private JComboBox cmbxYear;

    CreateNewUserGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        buttonConfig();
        configureDDMonth();

    }

    public void buttonConfig(){
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //clear the current information and allow the user to start over.
                txtUserName.setText("");
                txtLogin.setText("");
                txtPassword.setText("");
                txtHeight.setText("");
                txtWeight.setText("");
                cmbxMonth.setSelectedIndex(0);
                cmbxDay.setSelectedIndex(0);
                cmbxYear.setSelectedIndex(0);
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpeningPageGUI opGUI = new OpeningPageGUI(); //cancel out of this screen and open up the main page.
                opGUI.setVisible(true);
                setVisible(false);
            }
        });
    }

    public void configureDDMonth(){
        //button drop down for the month
        for (int x = 1; x < 13; x++){
            cmbxMonth.addItem(x);
        }
        }

    public void configureDDDay(){
        //button dropdown for the month
    }

    public void configureDDYear(){
        //dropdown information for the year.
    }


}
