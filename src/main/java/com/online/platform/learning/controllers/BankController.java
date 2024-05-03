package com.online.platform.learning.controllers;

import com.online.platform.learning.models.Bank;
import com.online.platform.learning.service.BankService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banks")
public class BankController {

    @Autowired
    private BankService bankService;

    // Get all banks
    @GetMapping("/")
    public List<Bank> getAllBanks() {
        return bankService.getAllBanks();
    }

    // Get bank by ID
    @GetMapping("/{id}")
    public ResponseEntity<Bank> getBankById(@PathVariable(value = "id") Integer bankId) {
        Bank bank = bankService.getBankById(bankId);
        if (bank == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(bank);
    }

    // Create a new bank
    @PostMapping("/")
    public Bank createBank(@Valid @RequestBody Bank bank) {
        return bankService.createBank(bank);
    }

    // Update an existing bank
    @PutMapping("/{id}")
    public ResponseEntity<Bank> updateBank(@PathVariable(value = "id") Integer bankId,
                                           @Valid @RequestBody Bank bankDetails) {
        Bank updatedBank = bankService.updateBank(bankId, bankDetails);
        if (updatedBank == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedBank);
    }

    // Delete a bank
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable(value = "id") Integer bankId) {
        bankService.deleteBank(bankId);
        return ResponseEntity.ok().build();
    }
}
