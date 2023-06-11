package com.testJPA.testJPA.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@Builder
@Table(name="tbl_dept")
@ToString(exclude = {"employees"}) // 필드명!!
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private Long id;

    @Column(name="dept_name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "department")
    @Builder.Default // 상대방 entity 에 조인되는 필드명
    private List<Employee> employees= new ArrayList<>();

}
