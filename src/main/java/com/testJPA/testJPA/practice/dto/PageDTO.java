package com.testJPA.testJPA.practice.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class PageDTO {

    private int pageNo;
    private int amount;

    public PageDTO (){
        this.pageNo=1;
        this.amount=10;
    }

}
