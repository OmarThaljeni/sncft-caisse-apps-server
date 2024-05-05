package com.online.platform.learning.service;

import com.online.platform.learning.models.Transcation;
import com.online.platform.learning.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionSevice {

    @Autowired
    private TransactionRepository transactionRepository;

    // Method to get all transcation
    public List<Transcation> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // Method to get bank by ID
    public Transcation getTrasactionById(Integer id) {
        Optional<Transcation> optionalTranscation = transactionRepository.findById(id);
        return optionalTranscation.orElse(null);
    }

    // Method to create a new transcation
    public Transcation createTransaction(Transcation transcation) {
        return transactionRepository.save(transcation);
    }

    // Method to update an existing transcation
    public Transcation updateTranscation(Integer id, Transcation transcationDetails) {
        Optional<Transcation> optionalTranscation = transactionRepository.findById(id);
        if (optionalTranscation.isPresent()) {
            Transcation existingoptionalTranscation = optionalTranscation.get();
            existingoptionalTranscation.setCodeTransaction(transcationDetails.getCodeTransaction());
            existingoptionalTranscation.setNomTransaction(transcationDetails.getCodeTransaction());
            existingoptionalTranscation.setTypeOperation(transcationDetails.getTypeOperation());
            return transactionRepository.save(existingoptionalTranscation);
        }
        return null; // or throw an exception
    }

    // Method to delete a transcation
    public void deleteTranscation(Integer id) {
        transactionRepository.deleteById(id);
    }

}
