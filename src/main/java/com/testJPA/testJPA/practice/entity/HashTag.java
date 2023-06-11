package com.testJPA.testJPA.practice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@ToString(exclude ={"post"} )
@Builder
@Table(name="test_hash_tag")
public class HashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tagName; // 해시태그 이름

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="fk_post")
    private Post post;



}
