package com.pard5.seminar4.card;

import com.pard5.seminar4.user.User;
import com.pard5.seminar4.user.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepo cardRepo;
    private final UserRepo userRepo;

    public void createCard(CardReq req) {
        User user = userRepo.findById(req.getUserId()).orElseThrow();
        Card card = Card.builder().name(req.getName()).user(user).build();
        cardRepo.save(card);
    }

    public CardRes readCard(Long id) {
        Card card = cardRepo.findById(id).orElseThrow();
        return new CardRes(card.getId(), card.getName());
    }
}
