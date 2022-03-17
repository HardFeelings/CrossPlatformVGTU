package ru.shatsckij.forms;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import ru.shatsckij.mainFrame.IVariant;

public class Form_8_15 implements IVariant {

    private JFrame GetFrame(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        JFrame jframe = new JFrame();
        jframe.setVisible(true);
        jframe.setBounds(dimension.width/2 - 300,dimension.height/2 - 300,600,600);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setResizable(true);
        jframe.setTitle("Task_8");
        return jframe;
    }


    public static void main(String[] args) {
        JFrame mainFrame = new Form_8_15().GetFrame();
        JPanel mainPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        mainFrame.add(mainPanel);
        mainPanel.setLayout(gridBagLayout);
        ArrayTableModel atb = new ArrayTableModel(5, 5);
        JTable arrayTable = new JTable(atb);

        JScrollPane arrayTableScrollPane = new JScrollPane(arrayTable);
        arrayTableScrollPane.setPreferredSize(new Dimension(400, 400));
        mainPanel.add(arrayTableScrollPane, new GridBagConstraints(0, 0, 1, 1, 1.0f, 1.0f,
                GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));

        mainPanel.revalidate();
        ;
        mainFrame.pack();
    }
    
    @Override
    public String toString() {
        return "Вариант 15";
    }

    @Override
    public void Run() {
        throw new RuntimeException("Not implemented yet");
    }

}

class ArrayTableModel extends AbstractTableModel {

    private int columnCount,rowCount;
    private ArrayList<String[]> dataList;

    public ArrayTableModel(int columnCount, int rowCount) {
        this.columnCount = columnCount;
        this.rowCount = rowCount;
        dataList = new ArrayList<String[]>();
        for (int i = 0; i < dataList.size(); i++) {
            dataList.add(new String[getColumnCount()]);
        }
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
        return  null;
    }

    public void addDate(String[] row){
        String[] rowTable = new String[getColumnCount()];
        rowTable = row;
        dataList.add(rowTable);
    }

    public void setValueAt(Object value, int row, int col) {
        dataList.get(row)[col] = String.valueOf(value);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

}
