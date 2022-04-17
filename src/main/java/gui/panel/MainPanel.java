package gui.panel;

import essence.Exception.NotSelectException;
import essence.Order;
import gui.table.MyTableModel;
import repository.OLRepoDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainPanel extends JFrame {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane1;
    private JTable table;
    private JButton saveToDB;
    private JButton saveToXLS;
    private JScrollPane scroll;
    private JButton deleteButton;
    private JButton addPosition;

    public MainPanel(String title, Order order) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        MyTableModel myTableModel = new MyTableModel(order);
        this.table.setModel(myTableModel);
        this.deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (table.getSelectedRows()[0] == 0) {
                        NotSelectException e;
                    }
                    myTableModel.delete(table.getSelectedRows());
                } catch (Exception e) {
                    e.printStackTrace();
                    JLabel messageJLabel = new JLabel("Виділіть позицію для видалення!");
                    messageJLabel.setHorizontalAlignment(JLabel.CENTER);
                    messageJLabel.setVerticalAlignment(JLabel.CENTER);

                    JDialog jDialog = new JDialog(MainPanel.this, "Увага, помилка видалення!!!");
                    jDialog.setBounds(table.getX() + 1200, table.getY() + 600, 300, 100);
                    jDialog.add(messageJLabel);
                    jDialog.setVisible(true);
                }
            }
        });

        this.saveToDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OLRepoDB.crOrTab(order);
                } catch (SQLException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
