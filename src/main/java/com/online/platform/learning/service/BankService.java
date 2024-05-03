package com.online.platform.learning.service;

import com.online.platform.learning.models.Bank;
import com.online.platform.learning.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    // Method to get all banks
    public List<Bank> getAllBanks() {
        return bankRepository.findAll();
    }

    // Method to get bank by ID
    public Bank getBankById(Integer id) {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        return optionalBank.orElse(null);
    }

    // Method to create a new bank
    public Bank createBank(Bank bank) {
        return bankRepository.save(bank);
    }

    // Method to update an existing bank
    public Bank updateBank(Integer id, Bank bankDetails) {
        Optional<Bank> optionalBank = bankRepository.findById(id);
        if (optionalBank.isPresent()) {
            Bank existingBank = optionalBank.get();
            existingBank.setCodeBank(bankDetails.getCodeBank());
            existingBank.setSocialRaison(bankDetails.getSocialRaison());
            existingBank.setCodeComptable(bankDetails.getCodeComptable());
            existingBank.setRib(bankDetails.getRib());
            return bankRepository.save(existingBank);
        }
        return null; // or throw an exception
    }

    // Method to delete a bank
    public void deleteBank(Integer id) {
        bankRepository.deleteById(id);
    }
}
