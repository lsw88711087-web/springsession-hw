package com.likelion.springsession_hw.guestbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "guestbooks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guestbook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;

    @Column(nullable = false, length = 20)
    private String writer;

    @Column(length = 200)
    private String ps;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public Guestbook(
            String title,
            String content,
            String writer,
            String ps,
            LocalDateTime createdAt
    ) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.ps = ps;
        this.createdAt = createdAt;
    }

    public void update(
            String title,
            String content,
            String writer,
            String ps
    ) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.ps = ps;
    }
}