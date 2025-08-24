package com.examly.springapp.service;

import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Gift;
import com.examly.springapp.repository.GiftRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    private final GiftRepo giftRepo;

    public GiftService(GiftRepo giftRepo) {
        this.giftRepo = giftRepo;
    }

    public Gift addGift(Gift gift) {
        return giftRepo.save(gift);
    }

    public List<Gift> getAllGifts() {
        return giftRepo.findAll();
    }

    public Gift getGiftById(int id) {
        return giftRepo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Gift not found"));
    }

    public Gift updateGift(int id, Gift updatedGift) {
        Gift gift = getGiftById(id);
        gift.setName(updatedGift.getName());
        gift.setGiftCategories(updatedGift.getGiftCategories());
        gift.setExperience(updatedGift.getExperience());
        gift.setSpecialization(updatedGift.getSpecialization());
        gift.setPhoneNumber(updatedGift.getPhoneNumber());
        return giftRepo.save(gift);
    }

    public void deleteGift(int id) {
        Gift gift = getGiftById(id);
        giftRepo.delete(gift);
    }
}
