package com.Shawn;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXMessageDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wolfknightx on 4/25/2016.
 * Login page for existing users.
 */
public class LoginPageGUI extends JFrame{
    private JPanel rootPanel;
    private JButton btnEnter;
    private JButton btnCancel;
    private JTextField txtLogin;
    private JTextField txtPassword;

    LoginPageGUI(){
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(650, 650));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(false);

        //access the set buttons.
        buttonConfig();

    }

    public void buttonConfig(){
        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel,"Going back to main page.", "Cancel",JOptionPane.CANCEL_OPTION);
                OpeningPageGUI opGUI = new OpeningPageGUI(); //cancel out of this screen and open up the main page.
                opGUI.setVisible(true);
                setVisible(false);
            }
        });
    }
}
