package com.likelion.springsession_hw.guestbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestbookUpdateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100)
    private String title;

    @NotBlank(message = "내용은 필수입니다.")
    @Size(max = 500)
    private String content;

    @NotBlank(message = "작성자는 필수입니다.")
    @Size(max = 20)
    private String writer;

    @Size(max = 200)
    private String ps;
}