package com.testJPA.testJPA.jpa.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = {"id"})
@Table(name="tbl_student")
@Entity
public class Student {

    @Id
    @GeneratedValue(generator = "uid")
    @GenericGenerator(name="uid",strategy = "uuid")
    private String id;

    @Column(name="stu_name", nullable = false)
    private String name;

    private String city;
    private String major;


}
