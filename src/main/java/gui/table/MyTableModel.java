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
        return switch (column) {
            case 0 -> "№";
            case 1 -> "Найменування";
            case 2 -> "Позначення";
            case 3 -> "Виробник";
            case 4 -> "Артикул";
            case 5 -> "Од.вим.";
            case 6 -> "Кількість";
            default -> "default";
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> order.getEquipmentList().get(rowIndex).getEqId();
            case 1 -> order.getEquipmentList().get(rowIndex).getName();
            case 2 -> order.getEquipmentList().get(rowIndex).getShortName();
            case 3 -> order.getEquipmentList().get(rowIndex).getVendorName();
            case 4 -> order.getEquipmentList().get(rowIndex).getVendorCode();
            case 5 -> order.getEquipmentList().get(rowIndex).getUnits();
            case 6 -> order.getEquipmentList().get(rowIndex).getQuantity();
            default -> "default";
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return switch (columnIndex) {
            case 1, 6 -> true;
            default -> false;
        };
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
