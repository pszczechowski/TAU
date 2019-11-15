package bdd.cucumber;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import s16096.model.CustomerOrder;
import s16096.repository.WorkToDoneRepo;
import s16096.service.CrudService;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;
import java.util.List;


public class AddCucumberTest {

    private CrudService crudService = new CrudService();
    private WorkToDoneRepo repository = WorkToDoneRepo.getInstance();
    private CustomerOrder customerOrder;

    private boolean isRemoved;
    private List<CustomerOrder> customerOrders = new ArrayList<>();

    @Given("^a new order$")
    public void orderIsDone() {
        customerOrder = new CustomerOrder();
    }

    @When("^order get own pizzas (.*)$")
    public void setOrderedPizza(ArrayList<String> orderedPizzas) {
        customerOrder.setOrderedPizzas(orderedPizzas);
    }

    @Then("^user can show (.*)$")
        public void orderPizzasIsCorrect(ArrayList<String> orderedPizzas){
        MatcherAssert.assertThat(customerOrder.getOrderedPizzas(), equalTo(orderedPizzas));
        }

    @Given("^init order list$")
    public void initOrderList() {
        ArrayList<String> order1 = new ArrayList<String>();
        ArrayList<String> order2 = new ArrayList<String>();
        ArrayList<String> order3 = new ArrayList<String>();
        order1.add("Hawai");
        order2.add("Americana");
        order3.add("Wiejska");

        repository.collectionAccess().add(new CustomerOrder(1,order1));
        repository.collectionAccess().add(new CustomerOrder(2, order2));
        repository.collectionAccess().add(new CustomerOrder(3, order3));
    }

    @When("^user wanna order with (.*) \\[Hawai,Americana\\]$")
    public void getOrderByRegex(String regex) {
        customerOrders = crudService.getCustomerOrderByRegex(regex);
    }

    @Then("^user get all order with (.*) \\[Hawai,Americana\\]$")
    public void orderByRegexPassed(String regex) {
        MatcherAssert.assertThat(customerOrders.size(),equalTo(0));
    }


}
