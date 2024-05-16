package com.online.platform.learning.service;

import com.online.platform.learning.models.Encaissment;
import com.online.platform.learning.repository.EncaissmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EncaissmentService {
    @Autowired
    private EncaissmentRepository encaissmentRepository;

    // Method to get all transcation
    public List<Encaissment> getAll() {
        return encaissmentRepository.findAll();
    }

    // Method to get bank by ID
    public Encaissment getEncaissmentById(Integer id) {
        Optional<Encaissment> optionalEncaissment = encaissmentRepository.findById(id);
        return optionalEncaissment.orElse(null);
    }

    // Method to create a new transcation
    public Encaissment createEncaissment(Encaissment encaissment) {
        return encaissmentRepository.save(encaissment);
    }

    // Method to update an existing transcation
    public Encaissment updateEncaissement(Integer id, Encaissment encaissment) {
        Optional<Encaissment> optionalEncaissment = encaissmentRepository.findById(id);
        if (optionalEncaissment.isPresent()) {
            Encaissment existingoptionalEncaissment = optionalEncaissment.get();
            existingoptionalEncaissment.setRef(encaissment.getRef());
            existingoptionalEncaissment.setCin(encaissment.getCin());
            existingoptionalEncaissment.setSomme(encaissment.getSomme());
            existingoptionalEncaissment.setMotif(encaissment.getMotif());
            existingoptionalEncaissment.setMatricule(encaissment.getMatricule());
            return encaissmentRepository.save(existingoptionalEncaissment);
        }
        return null; // or throw an exception
    }

    // Method to delete a transcation
    public void deleteEncaissment(Integer id) {
        encaissmentRepository.deleteById(id);
    }

}