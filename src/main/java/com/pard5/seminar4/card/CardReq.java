package com.pard5.seminar4.card;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardReq {
    private String name;
    private Long userId;
}
