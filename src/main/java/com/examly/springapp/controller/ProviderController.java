package com.examly.springapp.controller;

import com.examly.springapp.model.Provider;
import com.examly.springapp.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    // Get all providers
    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    // Get provider by ID
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(providerService.getProviderById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Create provider (link with User)
    @PostMapping("/user/{userId}")
    public ResponseEntity<Provider> createProvider(@PathVariable Long userId, @RequestBody Provider provider) {
        return ResponseEntity.ok(providerService.createProvider(userId, provider));
    }

    // Update provider
    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id, @RequestBody Provider updatedProvider) {
        try {
            return ResponseEntity.ok(providerService.updateProvider(id, updatedProvider));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete provider
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        try {
            providerService.deleteProvider(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
