package s16096.model;

import java.util.List;

public class WorkToDone {
    private long id;
    private List<Pizza> pizzas;

    public WorkToDone() {

    }

    public WorkToDone(long id, List<Pizza> pizzas) {
        this.id = id;
        this.pizzas = pizzas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
