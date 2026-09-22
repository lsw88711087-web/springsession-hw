package com.likelion.springsession_hw.guestbook.controller;

import com.likelion.springsession_hw.guestbook.dto.GuestbookCreateRequest;
import com.likelion.springsession_hw.guestbook.dto.GuestbookDetailResponse;
import com.likelion.springsession_hw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion.springsession_hw.guestbook.dto.GuestbookUpdateRequest;
import com.likelion.springsession_hw.guestbook.service.GuestbookService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/guestbooks")
public class GuestbookController {

    private final GuestbookService guestbookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGuestbook(
            @Valid @RequestBody GuestbookCreateRequest request
    ) {
        guestbookService.createGuestbook(request);
    }

    @GetMapping
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbookSummaries();
    }

    @GetMapping("/{guestbookId}")
    public GuestbookDetailResponse getGuestbook(
            @PathVariable Long guestbookId
    ) {
        return guestbookService.getGuestbook(guestbookId);
    }

    @PutMapping("/{guestbookId}")
    public ResponseEntity<Void> updateGuestbook(
            @PathVariable Long guestbookId,
            @Valid @RequestBody GuestbookUpdateRequest request
    ) {
        guestbookService.updateGuestbook(guestbookId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{guestbookId}")
    public ResponseEntity<Void> deleteGuestbook(
            @PathVariable Long guestbookId
    ) {
        guestbookService.deleteGuestbook(guestbookId);
        return ResponseEntity.noContent().build();
    }
}