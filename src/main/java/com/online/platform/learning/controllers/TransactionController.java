package com.online.platform.learning.controllers;

import com.online.platform.learning.models.Bank;
import com.online.platform.learning.models.Transcation;
import com.online.platform.learning.service.BankService;
import com.online.platform.learning.service.TransactionSevice;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionSevice transactionSevice;

    // Get all transcation
    @GetMapping("/")
    public  List<Transcation> getAllTransactions() {
        return transactionSevice.getAllTransactions();
    }

    // Get transcation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Transcation> getTranscationById(@PathVariable(value = "id") Integer TranscationId) {
        Transcation transcation = transactionSevice.getTrasactionById(TranscationId);
        if (transcation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(transcation);
    }

    // Create a new transcation
    @PostMapping("/")
    public Transcation createTranscation(@Valid @RequestBody Transcation transcation) {
        return transactionSevice.createTransaction(transcation);
    }

    // Update an existing transcation
    @PutMapping("/{id}")
    public ResponseEntity<Transcation> updateTranscation(@PathVariable(value = "id") Integer transcationId,
                                           @Valid @RequestBody Transcation transcationDetails) {
        Transcation updatedTranscation = transactionSevice.updateTranscation(transcationId, transcationDetails);
        if (updatedTranscation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedTranscation);
    }

    // Delete a transcation
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTranscation(@PathVariable(value = "id") Integer bankId) {
        transactionSevice.deleteTranscation(bankId);
        return ResponseEntity.ok().build();
    }
}
