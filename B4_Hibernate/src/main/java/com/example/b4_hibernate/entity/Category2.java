package com.example.b4_hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity // Danh dau day la thuc the
@Table(name = "category") // ten table trong SQL
@AllArgsConstructor // contructor full ths
@NoArgsConstructor // contructor k ts
@Getter
@Setter
@ToString
public class Category2 {
    // Trong 1 bang SQL(table): tung cot(column):
    // 1. Khoa chinh
    // 2. Khoa ngoai
    // 3. Cot binh binh
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // chi danh cho khoa chinh tu tang
    @Column(name = "id")
    private Long id;  // Nen mapping kieu du lieu Object
//    float -> Float
//    boolean -> Boolean

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
