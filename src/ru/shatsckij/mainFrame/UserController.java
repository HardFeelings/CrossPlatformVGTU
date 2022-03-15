package ru.shatsckij.mainFrame;

import ru.shatsckij.forms.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Dimension dimension = toolkit.getScreenSize();
    public static JFrame mainFrame = GetMainFrame();
    public static String var_1 = "Вариант 25", var_2 = "Вариант 30";


    private static JFrame GetMainFrame() {
        JFrame frame = new JFrame();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 50, 400, 100);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {

        JPanel mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        mainPanel.setLayout(gridBagLayout);
        GridBagConstraints mainCon = new GridBagConstraints();
        mainCon.weightx = 1.0f;
        mainCon.weighty = 1.0f;
        mainCon.fill = GridBagConstraints.BOTH;
        mainCon.gridy = 0;
        mainCon.gridx = 0;
        mainCon.gridwidth = 1;
        mainCon.gridheight = 1;
        JLabel mainLabel = new JLabel("Выберите задание");
        mainPanel.add(mainLabel, mainCon);
        mainCon.gridx = 2;
        mainCon.fill = GridBagConstraints.HORIZONTAL;
        int x = 5;
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(7, 7, 13, 1);
        JSpinner mainSpinner = new JSpinner(spinnerNumberModel);

        mainPanel.add(mainSpinner, mainCon);
        mainCon.gridx = 3;
        JButton mainButton = new JButton("Выполнить");
        mainPanel.add(mainButton, mainCon);
        JRadioButton varOneRB = new JRadioButton(var_1, true);
        JRadioButton varTwoRB = new JRadioButton(var_2, false);
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(varOneRB);
        radioGroup.add(varTwoRB);
        mainCon.gridy = 1;
        mainCon.gridx = 0;
        mainPanel.add(varOneRB, mainCon);
        mainCon.gridx = 1;
        mainPanel.add(varTwoRB, mainCon);

        mainSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if ((int) mainSpinner.getValue() == 7) {
                    varOneRB.setText("Вариант 25");
                    varTwoRB.setText("Вариант 30");
                }
                if ((int) mainSpinner.getValue() == 8) {
                    varOneRB.setText("Вариант 15");
                    varTwoRB.setText("Вариант 23");
                }
            }
        });
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int CurrentTask = (int) mainSpinner.getValue();
                if (CurrentTask == 7) {
                    if (varOneRB.isSelected()) { //Задание 7 Вариант 25
                        mainFrame.setVisible(false);
                        Form_7_25 formSeven = new Form_7_25();
                        formSeven.GetForm();
                    }
                    if (varTwoRB.isSelected()) {//Задание 7 Вариант 30
                        mainFrame.setVisible(false);
                        Form_7_30 formSeven = new Form_7_30();
                        formSeven.GetMainFrame();
                    }
                }
                if (CurrentTask == 8) {
                    if (varOneRB.isSelected()) {//Задание 8 Вариант 15

                    }
                    if (varTwoRB.isSelected()) {//Задание 8 Вариант 23

                    }
                }
            }
        });
        mainPanel.revalidate();

    }
}
