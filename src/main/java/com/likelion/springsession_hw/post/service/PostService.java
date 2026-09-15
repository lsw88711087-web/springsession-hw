package com.likelion.springsession_hw.post.service;

import com.likelion.springsession_hw.post.dto.PostSummaryResponse;
import com.likelion.springsession_hw.post.entity.Post;
import com.likelion.springsession_hw.post.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostSummaryResponse> getPostSummaries() {

        List<Post> posts = postRepository.findAll();
        List<PostSummaryResponse> responses = new ArrayList<>();

        for (Post post : posts) {

            PostSummaryResponse response = new PostSummaryResponse(
                    post.getId(),
                    post.getTitle(),
                    post.getCreatedAt()
            );

            responses.add(response);
        }

        return responses;
    }
}