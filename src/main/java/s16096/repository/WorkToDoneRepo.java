package s16096.repository;

import s16096.model.CustomerOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkToDoneRepo {
    private static WorkToDoneRepo ourInstance = new WorkToDoneRepo();

    public static WorkToDoneRepo getInstance() {
        return ourInstance;
    }

    private WorkToDoneRepo() {
    }

    private List<CustomerOrder> customerOrders = new ArrayList<>();

    public List<CustomerOrder> collectionAccess() {
        return customerOrders;
    }

    public void setCustomerOrders(List<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public Optional<CustomerOrder> getOrderById(long id) {

        return customerOrders.stream().filter(x -> x.getOrderId().equals(id)).findFirst();

    }

    public boolean isInRepoById(final long id) {
        return customerOrders.stream().anyMatch(u -> u.getOrderId().equals(id));
    }
}
