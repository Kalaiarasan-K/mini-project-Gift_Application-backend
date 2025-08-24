package com.examly.springapp.service;

import com.examly.springapp.model.Provider;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.ProviderRepository;
import com.examly.springapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private UserRepository userRepository;

    // Get all providers
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    // Get provider by ID
    public Provider getProviderById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    // Create provider (usually after approval)
    public Provider createProvider(Long userId, Provider provider) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        provider.setUser(user);
        return providerRepository.save(provider);
    }

    // Update provider
    public Provider updateProvider(Long id, Provider updatedProvider) {
        return providerRepository.findById(id).map(provider -> {
            provider.setBusinessName(updatedProvider.getBusinessName());
            provider.setContactPerson(updatedProvider.getContactPerson());
            provider.setEmail(updatedProvider.getEmail());
            provider.setPhoneNumber(updatedProvider.getPhoneNumber());
            return providerRepository.save(provider);
        }).orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    // Delete provider
    public void deleteProvider(Long id) {
        if (!providerRepository.existsById(id)) {
            throw new RuntimeException("Provider not found");
        }
        providerRepository.deleteById(id);
    }
}
