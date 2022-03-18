package ru.shatsckij.other;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.nio.charset.StandardCharsets;

public class Calculator {

    public static JFrame GetForm(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        String iconPath = "D:\\Учёба\\LessonsJavaVGTU\\esources\\AndreyHasDown.jpg";
        ImageIcon img = new ImageIcon(iconPath);
        Dimension dimension = toolkit.getScreenSize();
        JFrame jframe = new JFrame();
        jframe.setIconImage(img.getImage());
        jframe.setTitle("AndreyDaunCalculator");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setMinimumSize(new Dimension(400,500));
        jframe.setBounds(dimension.width/2 - 200,dimension.height/2 - 250,400,500);
        jframe.setResizable(true);
        jframe.setVisible(true);

        return jframe;

    }

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        JFrame mainFrame = GetForm();
        JPanel mainPanel = new JPanel();
        GridBagLayout gbd = new GridBagLayout();
        mainPanel.setLayout(gbd);
        mainFrame.add(mainPanel);
        JTextField OutputTF = new JTextField(20);
        OutputTF.setHorizontalAlignment(JTextField.RIGHT);
        OutputTF.setEditable(false);
        OutputTF.setFont(new Font("Arial", Font.PLAIN, 40));
        mainPanel.add(OutputTF,new GridBagConstraints(0, 0, 4, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // OneRow
        JButton ProcentButton = new JButton("%");
        ProcentButton.setFont(new Font("Arial", Font.PLAIN, 20));
        mainPanel.add(ProcentButton,new GridBagConstraints(0, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton CEButton = new JButton("CE");
        CEButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(CEButton,new GridBagConstraints(1, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton CButton = new JButton("C");
        CButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(CButton,new GridBagConstraints(2, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton remButton = new JButton("<");
        remButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(remButton,new GridBagConstraints(3, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // TwoRow
        JButton x_deliButton = new JButton("1/x");
        x_deliButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(x_deliButton,new GridBagConstraints(0, 2, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton xPowButton = new JButton("x^2");
        xPowButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(xPowButton,new GridBagConstraints(1, 2, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton sqrtButton = new JButton("\\/x");
        sqrtButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(sqrtButton,new GridBagConstraints(2, 2, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton delitButton = new JButton("/");
        delitButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(delitButton,new GridBagConstraints(3, 2   , 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // ThreeRow
        JButton sevenButton = new JButton("7");
        sevenButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(sevenButton,new GridBagConstraints(0, 3, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton eightButton = new JButton("8");
        eightButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(eightButton,new GridBagConstraints(1, 3, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton nineButton = new JButton("9");
        nineButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(nineButton,new GridBagConstraints(2, 3, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton multipliButton = new JButton("x");
        multipliButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(multipliButton,new GridBagConstraints(3, 3   , 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // FourRow
        JButton fourButton = new JButton("4");
        fourButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(fourButton,new GridBagConstraints(0, 4, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton fiveButton = new JButton("5");
        fiveButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(fiveButton,new GridBagConstraints(1, 4, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton sixButton = new JButton("6");
        sixButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(sixButton,new GridBagConstraints(2, 4, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton minusButton = new JButton("-");
        minusButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(minusButton,new GridBagConstraints(3, 4   , 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        // FiveRow
        JButton oneButton = new JButton("1");
        oneButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(oneButton,new GridBagConstraints(0, 5, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton twoButton = new JButton("2");
        twoButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(twoButton,new GridBagConstraints(1, 5, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton threeButton = new JButton("3");
        threeButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(threeButton,new GridBagConstraints(2, 5, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton concatButton = new JButton("+");
        concatButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(concatButton,new GridBagConstraints(3, 5   , 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
    // SixRow
        JButton supButton = new JButton("+/-");
        supButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(supButton,new GridBagConstraints(0, 6, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton nullButton = new JButton("0");
        nullButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(nullButton,new GridBagConstraints(1, 6, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton zapButton = new JButton(",");
        zapButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(zapButton,new GridBagConstraints(2, 6, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton equalsButton = new JButton("=");
        equalsButton.setFont(new Font("Arial", Font.PLAIN, 20));

        mainPanel.add(equalsButton,new GridBagConstraints(3, 6   , 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));



        mainPanel.revalidate();
        //mainFrame.pack();


    }
}
