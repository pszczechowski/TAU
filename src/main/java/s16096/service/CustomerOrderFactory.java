package s16096.service;

import s16096.model.CustomerOrder;

import java.util.ArrayList;

public class CustomerOrderFactory {

    public static CustomerOrder create(long id, ArrayList<String> orderName) {
        return new CustomerOrder(id, orderName);

    }
}
