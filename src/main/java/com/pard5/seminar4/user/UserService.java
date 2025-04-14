package com.pard5.seminar4.user;

import com.pard5.seminar4.book.BookRes;
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
                .map(b -> new BookRes(b.getId(), b.getTitle()))
                .toList();
        return new UserRes(user.getId(), user.getName(), books);
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
