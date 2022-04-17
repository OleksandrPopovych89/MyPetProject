package essence;

import java.util.ArrayList;
import java.util.List;

public class Order {
    String orderName;
    List<Equipment> equipmentList = new ArrayList<>();

    public Order(String orderName, List<Equipment> equipmentList) {
        this.orderName = orderName;
        this.equipmentList = equipmentList;
    }

    public Order() {
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public List<Equipment> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(List<Equipment> equipmentList) {
        this.equipmentList = equipmentList;
    }

    public void remove(int index) {
        equipmentList.remove(index);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderName +
                ", equipmentList=" + equipmentList +
                '}';
    }
}
