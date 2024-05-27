package com.online.platform.learning.controllers;

import com.online.platform.learning.models.Decaissement;
import com.online.platform.learning.service.DecaissementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operations-dec")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DecaissementController {

    @Autowired
    private DecaissementService decaissementService;

    // Get all transactions
    @GetMapping("/")
    public List<Decaissement> getAll() {
        return decaissementService.getAll();
    }

    // Get transaction by ID
    @GetMapping("/{id}")
    public ResponseEntity<Decaissement> getDecaissementById(@PathVariable(value = "id") Integer id) {
        Decaissement decaissement = decaissementService.getDecaissementById(id);
        if (decaissement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(decaissement);
    }

    // Create a new transaction
    @PostMapping("/add")
    public Decaissement createDecaissement(@Valid @RequestBody Decaissement decaissement) {
        return decaissementService.createDecaissement(decaissement);
    }

    // Update an existing transaction
    @PutMapping("/{id}")
    public ResponseEntity<Decaissement> updateDecaissement(@PathVariable(value = "id") Integer decaissementId,
                                                           @Valid @RequestBody Decaissement decaissementDetails) {
        Decaissement updatedDecaissement = decaissementService.updateDecaissement(decaissementId, decaissementDetails);
        if (updatedDecaissement == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedDecaissement);
    }

    // Delete a transaction
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable(value = "id") Integer id) {
        decaissementService.deleteDecaissement(id);
        return ResponseEntity.ok().build();
    }
}
