package ru.shatsckij.forms;

import ru.shatsckij.crossplatform.Task_7_25;
import ru.shatsckij.mainFrame.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Form_7_25 {
    public static Toolkit toolkit = Toolkit.getDefaultToolkit();
    public static Dimension dimension = toolkit.getScreenSize();
    public static int SIZE;
    private static String[] strArray;
    private static String str;
    public static int[] outputArray;
    private static Task_7_25 taskSeven = new Task_7_25();


    private static JFrame GetJFrame(){
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setBounds(dimension.width/2 - 300,dimension.height/2 - 75,600,150);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setTitle("Task_7");
        return jframe;
    }

    public void GetForm() {
        JFrame mainFrame = GetJFrame();
        JPanel mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        mainPanel.setLayout(gridBagLayout);
        GridBagConstraints constraintsLabel = new GridBagConstraints();
        constraintsLabel.fill = GridBagConstraints.BOTH;
        constraintsLabel.weightx = 1.0f;
        constraintsLabel.weighty = 1.0f;
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        constraintsLabel.gridheight = 1;
        constraintsLabel.gridwidth = 2;
        JLabel labelOne = new JLabel("Введите массив");
        mainPanel.add(labelOne,constraintsLabel);

        GridBagConstraints constraintsTF = new GridBagConstraints();
        constraintsTF.fill = GridBagConstraints.BOTH;
        constraintsTF.weighty = 1.0f;
        constraintsTF.weightx = 1.0f;
        constraintsTF.gridx = 0;
        constraintsTF.gridy = 1;
        constraintsTF.gridheight = 1;
        constraintsTF.gridwidth = 3;
        JTextField inputArrayField = new JTextField(20);
        mainPanel.add(inputArrayField,constraintsTF);

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(1,0,20,1);

        GridBagConstraints constraintsSpinner = new GridBagConstraints();
        constraintsSpinner.fill = GridBagConstraints.BOTH;
        constraintsSpinner.weighty = 1.0f;
        constraintsSpinner.weightx = 0.5f;
        constraintsSpinner.gridx = 3;
        constraintsSpinner.gridy = 1;
        constraintsSpinner.gridheight = 1;
        constraintsSpinner.gridwidth = 1;
        JSpinner jSpinner = new JSpinner(spinnerNumberModel);
        mainPanel.add(jSpinner,constraintsSpinner);

        GridBagConstraints constraintsLabelN = new GridBagConstraints();
        constraintsLabelN.fill = GridBagConstraints.BOTH;
        constraintsLabelN.weighty = 1.0f;
        constraintsLabelN.weightx = 1.0f;
        constraintsLabelN.gridx = 2;
        constraintsLabelN.gridy = 0;
        constraintsLabelN.gridheight = 1;
        constraintsLabelN.gridwidth = 2;
        JLabel labelTwo = new JLabel("Выберите размер");
        mainPanel.add(labelTwo,constraintsLabelN);

        GridBagConstraints constraintsButton = new GridBagConstraints();
        constraintsButton.fill = GridBagConstraints.BOTH;
        constraintsButton.weighty = 1.0f;
        constraintsButton.weightx = 1.0f;
        constraintsButton.gridx = 4;
        constraintsButton.gridy = 1;
        constraintsButton.gridheight = 1;
        constraintsButton.gridwidth = 2;
        JButton button = new JButton("Выполнить");
        mainPanel.add(button,constraintsButton);

        GridBagConstraints constraintsInputTF = new GridBagConstraints();
        constraintsInputTF.fill = GridBagConstraints.BOTH;
        constraintsInputTF.weighty = 1.0f;
        constraintsInputTF.weightx = 1.0f;
        constraintsInputTF.gridx = 0;
        constraintsInputTF.gridy = 4;
        constraintsInputTF.gridheight = 1;
        constraintsInputTF.gridwidth = 2;
        JTextField inputTextFieldOne = new JTextField(15);
        mainPanel.add(inputTextFieldOne,constraintsInputTF);

        GridBagConstraints constraintsInputTF2 = new GridBagConstraints();
        constraintsInputTF2.fill = GridBagConstraints.BOTH;
        constraintsInputTF2.weighty = 1.0f;
        constraintsInputTF2.weightx = 1.0f;
        constraintsInputTF2.gridx = 0;
        constraintsInputTF2.gridy = 5;
        constraintsInputTF2.gridheight = 1;
        constraintsInputTF2.gridwidth =
                2;
        JTextField inputTextFieldTwo = new JTextField(15);
        mainPanel.add(inputTextFieldTwo,constraintsInputTF2);

        GridBagConstraints constraintsLabelThree = new GridBagConstraints();
        constraintsLabelThree.fill = GridBagConstraints.BOTH;
        constraintsLabelThree.weighty = 1.0f;
        constraintsLabelThree.weightx = 1.0f;
        constraintsLabelThree.gridx = 2;
        constraintsLabelThree.gridy = 4;
        constraintsLabelThree.gridheight = 1;
        constraintsLabelThree.gridwidth = 2;
        JLabel labelThree = new JLabel("- Индекс начала последовательности");
        mainPanel.add(labelThree,constraintsLabelThree);

        GridBagConstraints constraintsLabelFour = new GridBagConstraints();
        constraintsLabelFour.fill = GridBagConstraints.BOTH;
        constraintsLabelFour.weighty = 1.0f;
        constraintsLabelFour.weightx = 1.0f;
        constraintsLabelFour.gridx = 2;
        constraintsLabelFour.gridy = 5;
        constraintsLabelFour.gridheight = 1;
        constraintsLabelFour.gridwidth = 2;
        JLabel labelFour = new JLabel("- Количество элементов последовательности");
        mainPanel.add(labelFour,constraintsLabelFour);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SIZE = (int)jSpinner.getValue();
                str = inputArrayField.getText();
                strArray = str.split(" ");
                outputArray = new int[strArray.length];
                for (int i = 0; i < strArray.length; i++) {
                    outputArray[i] = Integer.parseInt(strArray[i]);
                }
                int[] resultArray = taskSeven.findMaxSeq(outputArray);
                inputTextFieldOne.setText("" + resultArray[1]);
                inputTextFieldTwo.setText("" + resultArray[0]);

            }
        });
        mainPanel.revalidate();
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                UserController.mainFrame.setVisible(true);

            }
        });


        System.gc();

    }
}