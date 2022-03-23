package ru.shatsckij.forms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import ru.shatsckij.crossplatform.Task_8_19;
import ru.shatsckij.mainFrame.IVariant;

public class Form_8_19 implements IVariant {

    private JFrame GetFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setBounds(dimension.width / 2 - 300, dimension.height / 2 - 200, 600, 400);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setTitle("Task_8");
        return jframe;
    }

    private JFrame GetMiniFrame() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setTitle("Task_8");
        return jframe;
    }


    public void GetForm() {
        JFrame miniFrame = GetMiniFrame();
        JPanel miniPanel = new JPanel();
        miniFrame.add(miniPanel);
        GridBagLayout gridBagLayout = new GridBagLayout();
        miniPanel.setLayout(gridBagLayout);
        JLabel labelOne = new JLabel("Введите кол-во столбцов");
        miniPanel.add(labelOne, new GridBagConstraints(0, 0, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JLabel labelTwo = new JLabel("Введите кол-во строк");
        miniPanel.add(labelTwo, new GridBagConstraints(1, 0, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JTextField ColumnTF = new JTextField(15);
        miniPanel.add(ColumnTF, new GridBagConstraints(0, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JTextField RowTF = new JTextField(15);
        miniPanel.add(RowTF, new GridBagConstraints(1, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        JButton miniButton = new JButton("Ok");
        miniPanel.add(miniButton, new GridBagConstraints(2, 1, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
        miniPanel.revalidate();
        miniFrame.pack();

        miniButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miniFrame.setVisible(false);
                int row = Integer.parseInt(RowTF.getText());
                int col = Integer.parseInt(ColumnTF.getText());
                JFrame mainFrame = new Form_8_19().GetFrame();
                JPanel mainPanel = new JPanel();
                GridBagLayout gridBagLayout = new GridBagLayout();
                mainFrame.add(mainPanel);
                mainPanel.setLayout(gridBagLayout);
                ArrayTableModel atb = new ArrayTableModel(col, row);
                JTable arrayTable = new JTable(atb);
                arrayTable.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getClickCount() == 1) {
                            int row = arrayTable.rowAtPoint(e.getPoint());
                            int column = arrayTable.columnAtPoint(e.getPoint());
                            boolean value = Boolean.parseBoolean(String.valueOf(atb.getValueAt(row, column)));
                            if (!value) {
                                atb.setValueAt(String.valueOf(true), row, column);
                            } else {
                                atb.setValueAt(String.valueOf(false), row, column);
                            }
                        }
                    }
                });
                JScrollPane arrayTableScrollPane = new JScrollPane(arrayTable);
                arrayTableScrollPane.setPreferredSize(new Dimension(400, 400));
                mainPanel.add(arrayTableScrollPane, new GridBagConstraints(0, 0, 1, 1, 1.0f, 1.0f,
                        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));

                JButton ConfirmButton = new JButton("Выполнить");
                mainPanel.add(ConfirmButton, new GridBagConstraints(0, 1, 1, 1, 1.0f, 1.0f,
                        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
                JTextField jTextField = new JTextField(10);
                mainPanel.add(jTextField, new GridBagConstraints(0, 2, 1, 1, 1.0f, 1.0f,
                        GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
                jTextField.setEditable(false);

                ConfirmButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Task_8_19 task_8_19 = new Task_8_19();
                        jTextField.setText(task_8_19.GetTask(atb.getData()));
                    }
                });

                mainPanel.revalidate();

                mainFrame.pack();
            }
        });


    }

    @Override
    public String toString() {
        return "Вариант 15";
    }

    @Override
    public void Run() {
        this.GetForm();
    }

}

class ArrayTableModel extends AbstractTableModel {

    private int columnCount, rowCount;
    private boolean[][] data;

    public ArrayTableModel(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        data = new boolean[rowCount][columnCount];
    }

    public boolean[][] getData() {
        return data;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }


    public Object getValueAt(int rowIndex, int columnIndex) {
        return String.valueOf(data[rowIndex][columnIndex]);
    }

    public void setValueAt(Object value, int row, int col) {
        data[row][col] = Boolean.parseBoolean(String.valueOf(value));
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

}
