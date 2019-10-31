package s16096.model;

public class Customer {
    private Long id;
    private String name;
    private String surname;
    private boolean isActive = false;
    private CustomerOrder customerOrder;


    public Customer() {

    }

    public Customer (Long id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isActive = false;
        this.customerOrder = new CustomerOrder();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}