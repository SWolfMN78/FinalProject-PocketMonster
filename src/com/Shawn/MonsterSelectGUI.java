package com.Shawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wolfknightx on 4/25/2016.
 */
public class MonsterSelectGUI extends JFrame{
    private JPanel rootPanel;
    private JButton btnEnter;
    private JButton btnCancel;
    private JRadioButton rdoMonster1;
    private JRadioButton rdoMonster2;
    private JRadioButton rdoMonster3;
    private JPanel pnlMonsterDisplay;
    boolean monsterSelected = false;

    MonsterSelectGUI(){
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
                //once the user selects their desired monster to work with, move into the next screen
                if( isMonsterSelected() == true){
                    MainStageGUI msGUI = new MainStageGUI();
                    msGUI.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(rootPanel, "You must select a monster to move forward.","Select Error",
                            JOptionPane.ERROR_MESSAGE);
                }
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

    public boolean isMonsterSelected(){
        if (rdoMonster1.isSelected() == true || rdoMonster2.isSelected() == true || rdoMonster3.isSelected() == true){
            return monsterSelected = true;
        }
        return monsterSelected = false;
    }
}
