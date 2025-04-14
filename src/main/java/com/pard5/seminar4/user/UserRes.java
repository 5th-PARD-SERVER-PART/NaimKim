package com.pard5.seminar4.user;
import com.pard5.seminar4.book.BookRes;
import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRes {
    private Long id;
    private String name;
    private List<BookRes> books;
}