package br.com.workshop.framework.adapter.in;

import br.com.workshop.application.port.in.CustomerCrudUseCase;
import br.com.workshop.framework.adapter.in.dto.CustomerOutDTO;
import br.com.workshop.framework.helper.ModelMapperHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private ModelMapperHelper mapper;

    @Autowired
    private CustomerCrudUseCase useCase;

    @GetMapping
    public ResponseEntity<List<CustomerOutDTO>> findAll() {
        return ResponseEntity.ok(mapper.mapToList(useCase.findAll(), CustomerOutDTO.class));
    }


}
