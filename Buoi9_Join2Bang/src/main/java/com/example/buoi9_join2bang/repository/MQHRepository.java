package com.example.buoi9_join2bang.repository;

import com.example.buoi9_join2bang.entity.MQH;
import com.example.buoi9_join2bang.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class MQHRepository {

    private Session s;

    public MQHRepository() {
        s = HibernateUtil.getFACTORY().openSession();
    }

    public List<MQH> getAll() {
        return s.createQuery("FROM MQH ").list();
    }
}
