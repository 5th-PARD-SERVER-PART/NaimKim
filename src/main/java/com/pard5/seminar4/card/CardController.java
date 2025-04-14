package com.pard5.seminar4.card;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @PostMapping("")
    public void createCard(@RequestBody CardReq req) {
        cardService.createCard(req);
    }

    @GetMapping("/{id}")
    public CardRes readCard(@PathVariable Long id) {
        return cardService.readCard(id);
    }
}
