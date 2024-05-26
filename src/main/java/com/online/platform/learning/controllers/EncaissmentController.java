package com.online.platform.learning.controllers;

import com.online.platform.learning.models.Encaissment;
import com.online.platform.learning.models.Transcation;
import com.online.platform.learning.service.EncaissmentService;
import com.online.platform.learning.service.TransactionSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operations")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EncaissmentController {

    @Autowired
    private EncaissmentService encaissmentService;

    // Get all transcation
    @GetMapping("/")
    public  List<Encaissment> getAll() {
        return encaissmentService.getAll();
    }

    // Get transcation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Encaissment> getEncaissmentById(@PathVariable(value = "id") Integer id) {
        Encaissment encaissment = encaissmentService.getEncaissmentById(id);
        if (encaissment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(encaissment);
    }

    // Create a new transcation
    @PostMapping("/add")
    public Encaissment createEncaissement(@Valid @RequestBody Encaissment encaissment) {
        return encaissmentService.createEncaissment(encaissment);
    }

    // Update an existing transcation
    @PutMapping("/{id}")
    public ResponseEntity<Encaissment> updateEncaissment(@PathVariable(value = "id") Integer encaissmentId,
                                           @Valid @RequestBody Encaissment encaissmentDetails) {
        Encaissment updatedEncaissment = encaissmentService.updateEncaissement(encaissmentId, encaissmentDetails);
        if (updatedEncaissment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedEncaissment);
    }

    // Delete a transcation
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTranscation(@PathVariable(value = "id") Integer id) {
        encaissmentService.deleteEncaissment(id);
        return ResponseEntity.ok().build();
    }
}
