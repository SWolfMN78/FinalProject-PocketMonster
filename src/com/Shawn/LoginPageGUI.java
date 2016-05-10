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
    private String userLogin;
    private String userPassword;

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
                MainStageGUI msGUI = new MainStageGUI();
                userLogin = txtLogin.getText();
                userPassword = txtPassword.getText();
                Main.userInfo.logInSQLUser(userLogin, userPassword); //call the user information and access the prepS & rs.

                if (Main.userInfo.ID > 0) {
                    //if it comes back as good (we have a valid ID) then we can
                    msGUI.setVisible(true);
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(rootPanel, "Please check your login & password, the one you entered did not match",
                          "Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(rootPanel,"Going back to main page.", "Cancel",JOptionPane.CANCEL_OPTION);
                Main.shutdown(); //close the connecion.
                OpeningPageGUI opGUI = new OpeningPageGUI(); //cancel out of this screen and open up the main page.
                opGUI.setVisible(true);
                setVisible(false);
                Main.setup(); //open a new connection
            }
        });
    }
}
