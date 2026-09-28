package com.example.trenlop9_24.repository;

import com.example.trenlop9_24.entity.Category;
import com.example.trenlop9_24.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

public class CategoryRepository {
    // phiên làm việc -> 1 phiên làm việc -> 1 session
//    private Session s;
//    public CategoryRepository() {
//        // mở phiên trong contructor
//        s= HibernateUtil.getFACTORY().openSession();
//    }

//    Nguyên tắc: mỗi request/mỗi thao tác nên mở session riêng, dùng xong đóng ngay (mô hình "session-per-operation" hoặc "session-per-request").

    public List<Category>getAll(){
        try(Session s = HibernateUtil.getFACTORY().openSession()){
            //truy van tren entity _ select entity
            return s.createQuery("from Category", Category.class).list();
        }

    }

    public Category getOne(Long id){
        try(Session s = HibernateUtil.getFACTORY().openSession()){
            return s.find(Category.class, id); //chi ap dung voi fnc find theo id tra id tra ve 1ds
        }
    }
    //dam bao phai ra du lieu ham getAll
    // error  Category is not mapped [from Category ]
    // 1 do chua add @Entity trong class
    // 2 do chua register trong HibernateUtil

    public void add(Category cate){
        try(Session s = HibernateUtil.getFACTORY().openSession()){
            Transaction tx = s.getTransaction();
            // transation -> tinh toan ven
            try{
                //b1: bat dau 1 transiton
                s.getTransaction().begin();
                // b2: thuc hien chuc nang add -> persit
                s.persist(cate);
                //b3: commit
                s.getTransaction().commit();
            }catch (Exception e){
                s.getTransaction().rollback(); // error se quay ve trang thai ban dau
                e.printStackTrace();
            }
        }
    }

    public void update(Category cate){
        // transation -> tinh toan ve,
        try{
            //b1: bat dau 1 transiton
            s.getTransaction().begin();
            // b2: thuc hien chuc nang add -> merge
            s.merge(cate);
            //b3: commit
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback(); // error se quay ve trang thai ban dau
            e.printStackTrace();
        }
    }

    public void delete(Category cate){
        // transation -> tinh toan ve,
        try{
            //b1: bat dau 1 transiton
            s.getTransaction().begin();
            // b2: thuc hien chuc nang add -> delete
            s.delete(cate);
            //b3: commit
            s.getTransaction().commit();
        }catch (Exception e){
            s.getTransaction().rollback(); // error se quay ve trang thai ban dau
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println(new CategoryRepository().getAll());
        System.out.println(new CategoryRepository().getOne(1L));
    }

}
