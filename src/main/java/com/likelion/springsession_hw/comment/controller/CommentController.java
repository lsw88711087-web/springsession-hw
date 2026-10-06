package com.likelion.springsession_hw.comment.controller;

import com.likelion.springsession_hw.comment.dto.CommentCreateRequest;
import com.likelion.springsession_hw.comment.dto.CommentResponse;
import com.likelion.springsession_hw.comment.service.CommentService;
import com.likelion.springsession_hw.comment.dto.CommentUpdateRequest;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/posts/{postId}/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentResponse create(@PathVariable("postId") Long postId,
                                  @Valid @RequestBody CommentCreateRequest request) {
        return commentService.addComment(postId, request);
    }

    @GetMapping
    public List<CommentResponse> list(@PathVariable("postId") Long postId){
        return commentService.getComments(postId);
    }

    @PutMapping("/{commentId}")
    public CommentResponse update(
            @PathVariable("postId") Long postId,
            @PathVariable("commentId") Long commentId,
            @Valid @RequestBody CommentUpdateRequest request
    ) {
        return commentService.updateComment(postId, commentId, request);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(
            @PathVariable("postId") Long postId,
            @PathVariable("commentId") Long commentId
    ) {
        commentService.deleteComment(postId, commentId);
    }
}
