import essence.Order;
import gui.panel.MainPanel;
import repository.OLRepoDB;

import javax.swing.*;
import java.sql.SQLException;

public class Start {
    public static void main(String[] args) throws InterruptedException {

        Order order;
        try {
            order = OLRepoDB.readOrder("order #1");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        JFrame frame = new MainPanel("Main panel", order);
        frame.setVisible(true);


//        try {
//            EquipmentRepositoryDB.create(equipments);
//            Equipment equipment = EquipmentRepositoryDB.findByVendorCode("0010024597");
//            EquipmentRepositoryDB.deleteTable();
//        } catch (SQLException | RuntimeException e) {
//            e.printStackTrace();
//        }
    }
}