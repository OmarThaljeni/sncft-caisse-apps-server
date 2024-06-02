package com.online.platform.learning.service;

import com.online.platform.learning.models.Decaissement;
import com.online.platform.learning.repository.DecaissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DecaissementService {
    @Autowired
    private DecaissementRepository decaissementRepository;

    // Method to get all transactions
    public List<Decaissement> getAllDencaissement(String email) {
        return decaissementRepository.findAllByEmailUser(email);
    }

    // Method to get bank by ID
    public Decaissement getDecaissementById(Integer id) {
        Optional<Decaissement> optionalDecaissement = decaissementRepository.findById(id);
        return optionalDecaissement.orElse(null);
    }

    // Method to create a new transaction
    public Decaissement createDecaissement(Decaissement decaissement) {
        return decaissementRepository.save(decaissement);
    }

    // Method to update an existing transaction
    public Decaissement updateDecaissement(Integer id, Decaissement decaissement) {
        Optional<Decaissement> optionalDecaissement = decaissementRepository.findById(id);
        if (optionalDecaissement.isPresent()) {
            Decaissement existingDecaissement = optionalDecaissement.get();
            existingDecaissement.setRef(decaissement.getRef());
            existingDecaissement.setCin(decaissement.getCin());
            existingDecaissement.setSomme(decaissement.getSomme());
            existingDecaissement.setMotif(decaissement.getMotif());
            existingDecaissement.setMatricule(decaissement.getMatricule());
            existingDecaissement.setBanqueName(decaissement.getBanqueName());
            return decaissementRepository.save(existingDecaissement);
        }
        return null; // or throw an exception
    }

    // Method to delete a transaction
    public void deleteDecaissement(Integer id) {
        decaissementRepository.deleteById(id);
    }
}
