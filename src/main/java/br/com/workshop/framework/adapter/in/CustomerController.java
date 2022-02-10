package br.com.workshop.framework.adapter.in;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.framework.adapter.in.dto.CustomerOutDTO;
import br.com.workshop.framework.helper.ModelMapperHelper;
import br.com.workshop.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customerdomain/v1/customerManagement")
public class CustomerController {

    @Autowired
    private ModelMapperHelper mapper;

    @Autowired
    private CustomerCrudUseCase useCase;

    @GetMapping
    public ResponseEntity<List<CustomerOutDTO>> findAll() {
        return ResponseEntity.ok(mapper.mapToList(useCase.findAll(), CustomerOutDTO.class));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(useCase.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Customer customer) {
        useCase.insert(customer);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Customer customer) {
        useCase.update(id,customer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        useCase.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
