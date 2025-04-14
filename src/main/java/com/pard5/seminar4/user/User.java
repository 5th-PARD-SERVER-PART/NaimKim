package com.pard5.seminar4.user;

import com.pard5.seminar4.book.Book;
import com.pard5.seminar4.card.Card;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Card card;

    public void assignCard(Card card) {
        this.card = card;
    }
}