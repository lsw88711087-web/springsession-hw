package com.likelion.springsession_hw.guestbook.controller;

import com.likelion.springsession_hw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion.springsession_hw.guestbook.service.GuestbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping("/api/guestbooks")
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbookSummaries();
    }
}