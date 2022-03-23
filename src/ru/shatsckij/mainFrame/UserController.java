package ru.shatsckij.mainFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;

import ru.shatsckij.forms.Form_7;
import ru.shatsckij.forms.Form_8;

public class UserController {
    private static Toolkit toolkit = Toolkit.getDefaultToolkit();
    private static Dimension dimension = toolkit.getScreenSize();
    public static JFrame mainFrame = GetMainFrame();
    private static ITask[] tasks = { new Form_7() ,new Form_8()};


    private static JFrame GetMainFrame() {
        JFrame frame = new JFrame();
        frame.setBounds(dimension.width / 2 - 200, dimension.height / 2 - 50, 400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {
        try {

            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        JPanel mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        mainPanel.setLayout(new GridLayout());
        JComboBox<ITask> task_selector = new JComboBox<ITask>(tasks);
        mainPanel.add(task_selector);
        JComboBox<IVariant> variant_selector = new JComboBox<IVariant>(((ITask) task_selector.getSelectedItem()).GetVariants());
        mainPanel.add(variant_selector);
        JButton mainButton = new JButton("Выполнить");
        mainPanel.add(mainButton);
        task_selector.addActionListener(event -> {
            variant_selector.removeAllItems();
            ITask task = (ITask) task_selector.getSelectedItem();
            if (task == null)
                return;
            for (IVariant v : task.GetVariants()) {
                variant_selector.addItem(v);
            }
        });
        mainButton.addActionListener(event -> {
            IVariant variant = (IVariant) variant_selector.getSelectedItem();
            if (variant == null)
                return;

            variant.Run();
        });
        mainPanel.revalidate();
        mainFrame.pack();

    }
}
