package com.pard5.seminar4.book;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookReq {
    private String title;
    private Long userId; // 어떤 유저의 책인지 명시해야 하니까
}