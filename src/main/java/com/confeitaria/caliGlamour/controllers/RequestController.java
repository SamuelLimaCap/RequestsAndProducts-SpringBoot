package com.confeitaria.caliGlamour.controllers;


import com.confeitaria.caliGlamour.entities.Product;
import com.confeitaria.caliGlamour.entities.Request;
import com.confeitaria.caliGlamour.entities.RequestWithinProduct;
import com.confeitaria.caliGlamour.repositories.ProductRepository;
import com.confeitaria.caliGlamour.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/request")
public class RequestController {

    @Autowired
    private RequestRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/requests")
    public ResponseEntity<List<Request>> listAll() {
        List<Request> requests = repository.findAll();
        return ResponseEntity.ok().body(requests);
    }

    @PostMapping("/requests")
    public Request addRequest(@RequestBody RequestWithinProduct request) {
        try {
            Request requestFinal = new Request(
                null, productRepository.findById(request.getProductId()).get(), request.getQuantity(), request.getUsername());
            return repository.save(requestFinal);
        } catch (Exception e) {
            System.out.println("Não existe este id de produto");
            return null;
            //TODO transformar isso numa exception;
        }

    }

    @DeleteMapping("/requests/{id}")
    public Map<String, Boolean> deleteRequest(@PathVariable(value = "id") Long id) throws Exception {

        Request request = repository.findById(id).orElseThrow(() -> new Exception("request id not found"));

        repository.delete(request);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return response;
    }

}
