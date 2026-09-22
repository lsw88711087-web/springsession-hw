package com.likelion.springsession_hw.guestbook.service;

import com.likelion.springsession_hw.guestbook.dto.GuestbookCreateRequest;
import com.likelion.springsession_hw.guestbook.dto.GuestbookDetailResponse;
import com.likelion.springsession_hw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion.springsession_hw.guestbook.dto.GuestbookUpdateRequest;
import com.likelion.springsession_hw.guestbook.entity.Guestbook;
import com.likelion.springsession_hw.guestbook.repository.GuestbookRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    @Transactional
    public void createGuestbook(GuestbookCreateRequest request) {
        Guestbook guestbook = new Guestbook(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPs(),
                LocalDateTime.now()
        );

        guestbookRepository.save(guestbook);
    }

    @Transactional(readOnly = true)
    public List<GuestbookSummaryResponse> getGuestbookSummaries() {
        return guestbookRepository.findAll()
                .stream()
                .map(guestbook -> new GuestbookSummaryResponse(
                        guestbook.getTitle(),
                        guestbook.getWriter(),
                        guestbook.getPs()
                ))
                .toList();
    }

    @Transactional(readOnly = true)
    public GuestbookDetailResponse getGuestbook(Long guestbookId) {
        Guestbook guestbook = findGuestbook(guestbookId);

        return new GuestbookDetailResponse(
                guestbook.getId(),
                guestbook.getTitle(),
                guestbook.getContent(),
                guestbook.getWriter(),
                guestbook.getCreatedAt(),
                guestbook.getPs()
        );
    }

    @Transactional
    public void updateGuestbook(
            Long guestbookId,
            GuestbookUpdateRequest request
    ) {
        Guestbook guestbook = findGuestbook(guestbookId);

        guestbook.update(
                request.getTitle(),
                request.getContent(),
                request.getWriter(),
                request.getPs()
        );

        // save()를 호출하지 않아도 트랜잭션 종료 시 변경 감지로 UPDATE됩니다.
    }

    @Transactional
    public void deleteGuestbook(Long guestbookId) {
        Guestbook guestbook = findGuestbook(guestbookId);
        guestbookRepository.delete(guestbook);
    }

    private Guestbook findGuestbook(Long guestbookId) {
        return guestbookRepository.findById(guestbookId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "방명록을 찾을 수 없습니다."
                ));
    }
}