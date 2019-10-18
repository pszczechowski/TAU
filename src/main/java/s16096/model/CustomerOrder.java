package s16096.model;

import java.util.ArrayList;

public class CustomerOrder {
    private long orderId;
    private boolean isDone = false;
    private ArrayList<String> orderedPizzas;

    public CustomerOrder(){}

    public CustomerOrder(long id, ArrayList<String> orderedPizzas) {
        this.orderId = id;
        this.isDone = false;
        this.orderedPizzas = orderedPizzas;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public ArrayList<String> getOrderedPizzas() {
        return orderedPizzas;
    }

    public void setOrderedPizzas(ArrayList<String> orderedPizzas) {
        this.orderedPizzas = orderedPizzas;
    }
}
