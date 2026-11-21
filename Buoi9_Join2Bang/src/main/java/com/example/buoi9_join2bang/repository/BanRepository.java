package com.example.buoi9_join2bang.repository;

import com.example.buoi9_join2bang.entity.Ban1;
import com.example.buoi9_join2bang.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BanRepository {

    private Session s;

    public BanRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<Ban1> getAll() {
        return s.createQuery("FROM Ban1 ").list();
    }
}
