package com.example.buoi9_join2bang.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ban")
@Entity
public class Ban1 {
    // mapping class Ban - KHONG MAPPING KHOA NGOAI

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ma")
    private String soThich;

    @Column(name = "ma")
    private Integer gioiTinh;

    @Column(name = "ma")
    private Integer trangThai;

    @ManyToOne
    @JoinColumn(name = "id_mqh")
    private MQH mqh;

}
