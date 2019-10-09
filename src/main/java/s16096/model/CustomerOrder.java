package s16096.model;

public class CustomerOrder {
    private long id;
    private String orderName;
    private boolean isDone;
    private Pizza pizza;

    public CustomerOrder(){

    }
    public CustomerOrder(long id, String orderName) {
        this.id = id;
        this.orderName = orderName;
        this.isDone = false;
        this.pizza = new Pizza();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
