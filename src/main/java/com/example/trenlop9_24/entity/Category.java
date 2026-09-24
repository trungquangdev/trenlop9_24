package com.example.trenlop9_24.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity //ds thuc the
@Table (name = "category") //name lay tu ten bang trong sql
//add lombox
@Getter
@Setter
@AllArgsConstructor //contructor full tham so
@NoArgsConstructor //contructor khong tham so
@Builder // tao ra contructor tuy y tham so
@ToString
public class Category {
    // select * from table -> truy van sql
    // hibernate -> truy van entity (class trong java) truy van HQL
    // ORM - mapping quan he cac bang va cac thuoc tinh trong bang
    // attribute in table: 1.PK 2.FK 3.column binh thuong
    @Id
    // if id tu tang/tu gen - UUID
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_code")
    private String categoryCode;
    @Column(name = "category_name")
    private String categoryName;
}
