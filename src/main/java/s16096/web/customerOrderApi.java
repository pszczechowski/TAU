package s16096.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import s16096.model.CustomerOrder;
import s16096.service.CrudService;

@RestController
@RequestMapping("/api")
public class customerOrderApi {

    private CrudService crudService;

    @Autowired
    public customerOrderApi(CrudService crudService) {
        this.crudService = crudService;
    }

   @PostMapping("/add")
   public ResponseEntity<Boolean> createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.ok(crudService.createCustomerOrder(customerOrder));
   }

   @GetMapping("/{id}")
   public ResponseEntity<CustomerOrder> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(crudService.getOrderById(id));
   }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomerOrder(@PathVariable("id") Long id) {
        return ResponseEntity.ok(crudService.deleteCustomerOrder(id));
    }

    @PutMapping
    public ResponseEntity<CustomerOrder> updateCustomer(@PathVariable("id") Long id, @RequestBody CustomerOrder customerOrder) {
        return ResponseEntity.ok(crudService.updateCustomer(id, customerOrder));
    }
}
