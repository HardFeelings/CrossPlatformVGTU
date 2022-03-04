package ru.shatsckij.mainFrame;

import ru.shatsckij.forms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController {
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Dimension dimension = toolkit.getScreenSize();
    public static JFrame mainFrame = GetMainFrame();

    private static JFrame GetMainFrame(){
        JFrame frame = new JFrame();
        frame.setBounds(dimension.width/2 - 150, dimension.height/2-50,300,100);
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
        mainPanel.add(mainLabel,mainCon);
        mainCon.gridx = 2;
        mainCon.fill = GridBagConstraints.HORIZONTAL;
        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(7,7,13,1);
        JSpinner mainSpinner = new JSpinner(spinnerNumberModel);
        mainPanel.add(mainSpinner,mainCon);
        mainCon.gridx = 3;
        JButton mainButton = new JButton("Выполнить");
        mainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int CurrentTask = (int)mainSpinner.getValue();
                if(CurrentTask == 7){
                    mainFrame.setVisible(false);
                    FormSeven formSeven = new FormSeven();
                    formSeven.GetForm();
                }
            }
        });
        mainPanel.add(mainButton,mainCon);
        mainPanel.revalidate();

    }
}
