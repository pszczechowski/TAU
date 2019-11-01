package s16096.model;

import java.util.List;

public class CustomerOrderList {
    private Long id;
    private List<CustomerOrder> customerOrders;

    public CustomerOrderList() {

    }
    public CustomerOrderList(Long id, List<CustomerOrder> customerOrders) {
        this.id = id;
        this.customerOrders = customerOrders;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }
}
