package bdd.cucumber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.hamcrest.MatcherAssert;
import s16096.model.CustomerOrder;
import s16096.repository.WorkToDoneRepo;
import s16096.service.CrudService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


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

}
