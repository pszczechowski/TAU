package s16096.service;

import org.springframework.stereotype.Service;
import s16096.model.CustomerOrder;
import s16096.model.CustomerOrderDate;
import s16096.repository.WorkToDoneRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CrudService {

    public CrudService() {
//Make crud Service
    }

    public boolean createCustomerOrder(CustomerOrder order) {
        if (order == null) throw new IllegalArgumentException("Object is null");

        WorkToDoneRepo.getInstance().collectionAccess().add(order);
        return true;
    }

    public CustomerOrder getOrderById(Long id) {
        if (WorkToDoneRepo.getInstance().isInRepoById(id)) {

            Optional<CustomerOrder> optionalCustomerOrder = WorkToDoneRepo.getInstance().getOrderById(id);
            if (optionalCustomerOrder.isPresent()) {
                CustomerOrder customerOrder = optionalCustomerOrder.get();
                if (customerOrder.isRecordTimes()) {
                    customerOrder.setLastReadingTime(LocalDateTime.now());
                }
                return optionalCustomerOrder.get();
            }
        }
        throw new NoSuchElementException("Element doesn't exist");
    }

    public boolean deleteCustomerOrder(Long id) {
        if (WorkToDoneRepo.getInstance().isInRepoById(id)) {
            WorkToDoneRepo.getInstance().collectionAccess().remove(getOrderById(id));
            return true;
        }
        return false;
    }

    public List<CustomerOrder> getAllCustomerOrder() {
        return new ArrayList<>(WorkToDoneRepo.getInstance().collectionAccess());
    }

    public CustomerOrder updateCustomer(Long id, CustomerOrder customer) {
        if (WorkToDoneRepo.getInstance().isInRepoById(id)) {
            CustomerOrder customerToUpdate = getOrderById(id);

            customerToUpdate.setOrderedPizzas(customer.getOrderedPizzas());
            customerToUpdate.setDone(customer.isDone());
            customerToUpdate.setRecordTimes(customer.isRecordTimes());

            if (customer.isRecordTimes()) {
                customerToUpdate.setModernizeTime(LocalDateTime.now());
                customerToUpdate.setLastReadingTime(customer.getLastReadingTime());
            }

            WorkToDoneRepo.getInstance().collectionAccess().remove(getOrderById(id));
            WorkToDoneRepo.getInstance().collectionAccess().add(customerToUpdate);


            return customerToUpdate;
        }

        throw new NoSuchElementException("Element doesn't exist");
    }

    public CustomerOrderDate getTimeById(long id) {
        return new CustomerOrderDate().create((getOrderById(id)));
    }

    public List<CustomerOrder> getCustomerOrderByRegex(String regex) {
        if (regex == null) {
            throw new IllegalArgumentException("regex can't by null");
        }
        return WorkToDoneRepo.getInstance().collectionAccess().stream()
                .filter(x -> x.getOrderedPizzas().contains(regex))
                .collect(Collectors.toList());

    }

    public boolean deleteCustomerOrderByRegex(String regex) {
        if(regex == null){
            throw new IllegalArgumentException("regex can't by null");
        }

        List<CustomerOrder> ordersToRemove = getCustomerOrderByRegex(regex);
        if(ordersToRemove.size() == 0) {
            return false;
        }

        ordersToRemove.forEach(x -> deleteCustomerOrder(x.getOrderId()));
        return true;
    }

}


