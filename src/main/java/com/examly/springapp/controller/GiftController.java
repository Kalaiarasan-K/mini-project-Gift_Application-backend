package com.examly.springapp.controller;

import com.examly.springapp.model.Gift;
import com.examly.springapp.service.GiftService;
import com.examly.springapp.exception.InvalidPhoneNumberException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GiftController {

    private final GiftService giftService;

    public GiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @PostMapping("/addGift")
    public ResponseEntity<?> addGift(@RequestBody Gift gift) {
        String phone = gift.getPhoneNumber();
        if (phone == null || !phone.startsWith("+91")) {
            throw new InvalidPhoneNumberException("Phone number must start with +91.");
        }
        Gift saved = giftService.addGift(gift);
        return ResponseEntity.status(200).body(saved);
    }

    @GetMapping("/getAllGifts")
    public ResponseEntity<List<Gift>> getAllGifts() {
        return ResponseEntity.ok(giftService.getAllGifts());
    }

    @ExceptionHandler(InvalidPhoneNumberException.class)
    public ResponseEntity<String> handlePhoneError(InvalidPhoneNumberException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @GetMapping("/getGift/{id}")
    public ResponseEntity<Gift> getGiftById(@PathVariable int id) {
        Gift gift = giftService.getGiftById(id);
        return ResponseEntity.ok(gift);
    }

    @PutMapping("/updateGift/{id}")
    public ResponseEntity<Gift> updateGift(@PathVariable int id, @RequestBody Gift updateGift) {
        Gift gift = giftService.updateGift(id, updateGift);
        return ResponseEntity.ok(gift);
    }
    
    // Delete gift
    @DeleteMapping("/deleteGift/{id}")
    public ResponseEntity<String> deleteGift(@PathVariable int id) {
        giftService.deleteGift(id);
        return ResponseEntity.ok("Gift deleted successfully.");
    }

}