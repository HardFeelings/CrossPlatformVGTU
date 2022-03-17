package ru.shatsckij.forms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.shatsckij.crossplatform.Task_7_30;
import ru.shatsckij.mainFrame.IVariant;
import ru.shatsckij.mainFrame.UserController;

public class Form_7_30 implements IVariant{
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Dimension dimension = toolkit.getScreenSize();

    private static JFrame GetJFrame(){
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setBounds(dimension.width/2 - 350,dimension.height/2 - 60,700,120);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setTitle("Task_7");
        return jframe;
    }

    public void GetMainFrame() {
        JFrame frame = GetJFrame();
        JPanel panel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        panel.setLayout(gridBagLayout);
        frame.add(panel);
        GridBagConstraints con = new GridBagConstraints();
        con.weightx = 1.0f;
        con.weighty = 1.0f;
        con.fill = GridBagConstraints.BOTH;
        con.gridy = 0;
        con.gridx = 0;
        con.gridwidth = 1;
        con.gridheight = 1;
        JLabel label1 = new JLabel("Введите массив");
        panel.add(label1,con);
        con.gridx = 1;
        JLabel label3 = new JLabel("Введите n");
        panel.add(label3,con);
        con.gridx = 0;
        con.gridy = 1;
        JTextField ArrayArea = new JTextField(10);
        panel.add(ArrayArea,con);
        con.gridx = 1;
        JTextField nArea = new JTextField(10);
        panel.add(nArea,con);
        con.gridx = 2;
        JButton button = new JButton("Выполнить");
        panel.add(button,con);
        con.gridy = 2;
        con.gridx = 1;
        JTextField OutputArea = new JTextField(10);
        panel.add(OutputArea,con);
        JLabel label4 = new JLabel("Индекс первого элемента найденной последовательности");
        con.gridx = 0;
        panel.add(label4,con);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = ArrayArea.getText();
                List<String> list = new ArrayList<>();
                list.add(ArrayArea.getText());
                int[] array = list.stream().flatMap(x -> Stream.of(x.split(" "))).mapToInt(x->Integer.parseInt(x)).toArray();
                OutputArea.setText(String.valueOf(new Task_7_30().findMaxSeq(array,Integer.parseInt(nArea.getText()))));
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                UserController.mainFrame.setVisible(true);

            }
        });
        panel.revalidate();
        frame.pack();
    }
    @Override
    public String toString() {
        return "Вариант 30";
    }
    @Override
    public void Run() {
        this.GetMainFrame();
    }
}
