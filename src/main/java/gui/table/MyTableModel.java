package gui.table;

import essence.Order;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MyTableModel extends AbstractTableModel {
    private Order order;

    public MyTableModel(Order order) {
        this.order = order;
    }

    @Override
    public int getRowCount() {
        return order.getEquipmentList().size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "№";
            case 1:
                return "Найменування";
            case 2:
                return "Позначення";
            case 3:
                return "Виробник";
            case 4:
                return "Артикул";
            case 5:
                return "Од.вим.";
            case 6:
                return "Кількість";
        }
        return "default";
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return order.getEquipmentList().get(rowIndex).getEqId();
            case 1:
                return order.getEquipmentList().get(rowIndex).getName();
            case 2:
                return order.getEquipmentList().get(rowIndex).getShortName();
            case 3:
                return order.getEquipmentList().get(rowIndex).getVendorName();
            case 4:
                return order.getEquipmentList().get(rowIndex).getVendorCode();
            case 5:
                return order.getEquipmentList().get(rowIndex).getUnits();
            case 6:
                return order.getEquipmentList().get(rowIndex).getQuantity();
        }
        return "default";
    }

    public void delete(int[] index) {
        System.out.println(Arrays.toString(index));
        for (int i = index.length - 1; i >= 0; i--) {
            this.order.remove(index[i]);
            System.out.println(index[i]);
        }
        fireTableDataChanged();
    }
}
