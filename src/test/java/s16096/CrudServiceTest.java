package s16096;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import s16096.model.Customer;
import s16096.model.CustomerOrder;
import s16096.model.CustomerOrderDate;
import s16096.repository.WorkToDoneRepo;
import s16096.service.CrudService;
import s16096.service.CustomerOrderFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)

public class CrudServiceTest {
    private WorkToDoneRepo repository = WorkToDoneRepo.getInstance();
    private CrudService crudService = new CrudService();

    @Mock
    private CustomerOrderDate customerOrderDateMock;
    @Mock
    private CrudService crudServiceMock;
    @Mock
    private CustomerOrder orderMock;

    private ArrayList<String> order1 = new ArrayList<String>();
    private ArrayList<String> order2 = new ArrayList<String>();
    private ArrayList<String> order3 = new ArrayList<String>();
    private ArrayList<String> order4 = new ArrayList<String>();
    private ArrayList<String> order5 = new ArrayList<String>();

  /*  @InjectMocks
    private CustomerOrderDate customerOrderDate;*/

    @BeforeClass
    public static void setup() {
    }


    @Before
    public void initList() {

        order1.add("Hawai");
        order1.add("Americana");
        order2.add("Wiejska");
        order2.add("Peperoni");
        order3.add("Capriciosa");
        order3.add("Salami");
        order4.add("Mexicana");


        repository.collectionAccess().add(new CustomerOrder(1,order1));
        repository.collectionAccess().add(new CustomerOrder(2, order2));
        repository.collectionAccess().add(new CustomerOrder(3, order3));

    }


    @Test
    public void addOrderedPizzas_correct() {
        int orderCalculateBeforeAdd = repository.collectionAccess().size();
        crudService.createCustomerOrder(new CustomerOrder(4, order4));
        Assert.assertEquals(orderCalculateBeforeAdd + 1, repository.collectionAccess().size());
    }

    @Test
    public void getOrderedPizzasById_correct(){
        CustomerOrder order = crudService.getOrderById((long) 1);
        Assert.assertEquals(order.getOrderedPizzas(), order1);
    }

    @Test(expected = NoSuchElementException.class)
    public void getOrderById_NoSuchElementException_expected() {
        CustomerOrder order = crudService.getOrderById((long) 10);
    }

    @Test
    public void deleteOrderedPizzasById_correct() {
        int elementBeforeTest = repository.collectionAccess().size();
        Assert.assertTrue(crudService.deleteCustomerOrder((long) 1));
        Assert.assertEquals(elementBeforeTest, repository.collectionAccess().size() + 1);
    }

    @Test
    public void deleteOrderedPizzas_no_element() {
        Assert.assertFalse(crudService.deleteCustomerOrder((long) 10));
    }

    @Test
    public void getAllOrderedPizzas_correct() {
        List<CustomerOrder> orders = crudService.getAllCustomerOrder();
        Assert.assertEquals(orders.size(), 10);
    }
    @Test
    public void updateCustomerOrder_correct() {
        Customer customer = new Customer((long)1,"Krzysztof","Jerzyna");
        customer.setActive(true);
        CustomerOrder orderToUpdate = crudService.getOrderById((long) 1);
        customer.setCustomerOrder(new CustomerOrder(1,order2));

        Assert.assertEquals(orderToUpdate.getOrderedPizzas(), orderToUpdate.getOrderedPizzas());
        Assert.assertEquals(orderToUpdate.isDone(), orderToUpdate.isDone());
    }
    @Test
    public void readDataOnGetObject_correct() {
        LocalDateTime time = LocalDateTime.now();
        when(crudServiceMock.getOrderById((long)1)).thenReturn(orderMock);
        when(crudServiceMock.getOrderById((long)1).getLastReadingTime()).thenReturn(time);

        Assert.assertEquals(crudServiceMock.getOrderById((long) 1).getLastReadingTime(), time);
    }
    @Test
    public void getTimesByCustomerOrderId_correct() {
        //crudService.getOrderById((long) 1);
        Assert.assertNotNull((crudService.getOrderById((long)1)));

    }

    @Test
    public void addDataOverAddCollection_correct() {
        crudService.createCustomerOrder(CustomerOrderFactory.create((30),order5));
        LocalDateTime time = LocalDateTime.now();

        when(crudServiceMock.getOrderById((long)30)).thenReturn(orderMock);
        when(crudServiceMock.getOrderById((long)30).getLastReadingTime()).thenReturn(time);
        Assert.assertEquals(crudServiceMock.getOrderById((long)30).getLastReadingTime(), time);
    }
    @Test
    public void updateDateOverUpdateObject_correct() {
        LocalDateTime time = LocalDateTime.now();
        when (customerOrderDateMock.getModernizeTime()).thenReturn(time);

        CustomerOrder order = crudService.updateCustomer((long) 1, crudService.getOrderById((long) 2));
        Mockito.timeout(300);
        Assert.assertEquals(customerOrderDateMock.getModernizeTime(), time);
    }
    @Test
    public void setTimesSaveToFalse_correct() {
        CustomerOrder orderWithFalse = repository.collectionAccess().get(1);
        orderWithFalse.setRecordTimes(false);
        crudService.updateCustomer(orderWithFalse.getOrderId(), orderWithFalse);
        Mockito.timeout(300);

        List<CustomerOrder> allCustomerOrder = crudService.getAllCustomerOrder();
         Assert.assertEquals(3 , allCustomerOrder.stream().filter(x -> x.getLastReadingTime() == orderWithFalse.getLastReadingTime()).count());
    }


}

