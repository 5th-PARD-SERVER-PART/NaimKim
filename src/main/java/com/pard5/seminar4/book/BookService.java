package com.pard5.seminar4.book;

import com.pard5.seminar4.user.User;
import com.pard5.seminar4.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public void createBook(BookReq req) {
        User user = userRepo.findById(req.getUserId()).orElseThrow();
        Book book = new Book(null, req.getTitle(), user);
        bookRepo.save(book);
    }

    public BookRes readBook(Long id) {
        Book book = bookRepo.findById(id).orElseThrow();
        return new BookRes(book.getId(), book.getTitle());
    }
}
