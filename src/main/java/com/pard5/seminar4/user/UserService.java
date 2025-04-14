package com.pard5.seminar4.user;

import com.pard5.seminar4.book.BookRes;
import com.pard5.seminar4.card.CardRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public UserRes getUser(Long id) {
        User user = userRepo.findById(id).orElseThrow();

        List<BookRes> books = user.getBooks().stream()
                .map(book -> new BookRes(book.getId(), book.getTitle()))
                .toList();

        CardRes card = null;
        if (user.getCard() != null) {
            card = new CardRes(user.getCard().getId(), user.getCard().getName());
        }

        return UserRes.builder()
                .id(user.getId())
                .name(user.getName())
                .books(books)
                .card(card) // 👈 Include card info
                .build();
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public void createUser(UserReq request) {
        User user = new User();
        user.setName(request.getName());
        userRepo.save(user);
    }
}
