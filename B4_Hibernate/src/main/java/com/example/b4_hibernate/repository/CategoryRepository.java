package com.example.b4_hibernate.repository;

import com.example.b4_hibernate.entity.Category2;
import com.example.b4_hibernate.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // Viet cac ham CRUD -> Lam viec truc tiep vs CSDL

    private Session sess;

    public CategoryRepository() {
        sess = HibernateUtil.getFACTORY().openSession(); // Mo phien lam viec session trong contructor
    }

    public List<Category2> getAll() {
        return sess.createQuery("FROM Category2").list();
    }

    public Category2 getOne(Long id1) {
        return sess.find(Category2.class, id1); // Tim kiem theo id - khoa chinh
    }

    public void add(Category2 cate) {
        try {
            // B1: Bat dau 1 tran -> tinh toan ven
            sess.getTransaction().begin();
            // B2: Thuc hien tinh nang
            sess.persist(cate);
            // B3: Day du lieu di
            sess.getTransaction().commit();
        } catch (Exception e) {
            sess.getTransaction().rollback(); // loi quay ve trang thao ban dau
            e.printStackTrace();
        }
    }

    public void update(Category2 cate) {
        try {
            // B1: Bat dau 1 tran -> tinh toan ven
            sess.getTransaction().begin();
            // B2: Thuc hien tinh nang
            sess.merge(cate);
            // B3: Day du lieu di
            sess.getTransaction().commit();
        } catch (Exception e) {
            sess.getTransaction().rollback(); // loi quay ve trang thao ban dau
            e.printStackTrace();
        }
    }

    public void delete(Category2 cate) {
        try {
            // B1: Bat dau 1 tran -> tinh toan ven
            sess.getTransaction().begin();
            // B2: Thuc hien tinh nang
            sess.delete(cate);
            // B3: Day du lieu di
            sess.getTransaction().commit();
        } catch (Exception e) {
            sess.getTransaction().rollback(); // loi quay ve trang thao ban dau
            e.printStackTrace();
        }
    }

    // is not mapped
    // 1. chua co @Entity
    // 2. Chua dk class Category2 ben Hibernate Util
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
