package com.example.b4_hibernate.repository;

import com.example.b4_hibernate.entity.Category2;
import com.example.b4_hibernate.util.HibernateUtil;
import jakarta.persistence.Query;
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

    // 1. Tim kiem danh sach cate theo ten - chua ten
    // 2. Tim kiem ds cate theo khoang id
    // 3. Sap xep giam danh theo id
    // 4. Phan trang - 3 phan tu /trang
    public List<Category2> searchByName(String name) {
        // B1: Tao query
        String hql = "SELECT c FROM Category2 c WHERE c.categoryName LIKE ?1";
        // B2: Khoi tao query
        Query q = sess.createQuery(hql);
        // B3: Set tham so cho dau ?
        q.setParameter(1, "%" + name + "%");
        // B4: Return list
        return q.getResultList();
        // NEU HAM TRA VE DS -> getResultList
        // NEU HAM TRA VE 1 DOI TUONG -> getSingleResult
    }

    public Category2 getOne2(Long id) {
        String hql = "SELECT c FROM Category2 c WHERE c.id = ?1";
        Query q = sess.createQuery(hql);
        q.setParameter(1, id);
        return (Category2) q.getSingleResult();
    }
    // phan trang => dung offset trong SQL

    /**
     * -- giai thich ham nay la gi lam gi
     *
     * @param pageNo:   gt gia tri cua bien nay: so Trang (trang so 1, trang 2..)
     * @param pageSize: so luong phan tu trong 1 trang
     * @return : gt gia tri tra ve
     */
    public List<Category2> phanTrangSQl(Integer pageNo, Integer pageSize) {
        // TRANG DAU TIEN BAT DAU BANG 0
        Integer offset1 = pageNo * pageSize;
        // B1: Tao cau lenh SQL
//        String sql = "SELECT * from category " +
//                "ORDER BY id  " +
//                "OFFSET :offset ROWS \n" +
//                "FETCH NEXT :pageSize1 ROWS ONLY ";
        String sql = "select * from category ORDER BY id  OFFSET :offset ROWS FETCH NEXT :pageSize1 ROWS ONLY;";
//        String sql1="select * from category\n" +
//                "ORDER BY id \n" +
//                "OFFSET9 ROWS \n" +
//                "FETCH NEXT 3 ROWS ONLY ";
        // B2: Tao query
        Query query = sess.createNativeQuery(sql, Category2.class);
        // B3: Set value
        query.setParameter("offset", offset1);
        query.setParameter("pageSize1", pageSize);
        return query.getResultList();
    }

    public List<Category2> phanTrangHQl(Integer pageNo, Integer pageSize) {
        int offset = pageNo * pageSize;
        String hql = "SELECT p FROM Category2 p  ORDER BY p.id ";
        Query query = sess.createQuery(hql);
        query.setFirstResult(offset); // NGANG HANG VS OFFSET => KET QUA TRA RA LA +1
        query.setMaxResults(pageSize); // SO LUONG MAX/TRANG
        return query.getResultList();
    }

    public List<Category2> getAll1() {
        String hql = "SELECT c FROM Category2 c ";
        Query q = sess.createQuery(hql);
        return q.getResultList();
    }

    public List<Category2> search() {
        String hql = "SELECT c FROM Category2 c ORDER BY c.id DESC";
        Query q = sess.createQuery(hql);
        return q.getResultList();
    }

    // is not mapped
    // 1. chua co @Entity
    // 2. Chua dk class Category2 ben Hibernate Util
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
    }
}
