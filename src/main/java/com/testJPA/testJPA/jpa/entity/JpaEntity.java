package com.testJPA.testJPA.jpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Table(name="test_jpa_table")
public class JpaEntity {

    @Id
    @Column(name="emp_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="emp_name")
    private String name;

    @Builder.Default
    private int salary=0;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime hiredDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;


    public enum Gender {
        M,F
    }
}
