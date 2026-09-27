package com.example.trenlop9_24.controller;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.example.trenlop9_24.entity.Category;
import com.example.trenlop9_24.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(name = "CategoryServlet", value = {
        "/category/hien-thi",
        "/category/detail",
        "/category/delete",
        "/category/view-update",
        "/category/update",
        "/category/search",
        "/category/view-add",
        "/category/add"
})
public class CategoryServlet extends HttpServlet {
    private CategoryRepository cateRepo = new CategoryRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //kiểm tra chứa trong chuỗi: contains
        //B1: lấy uri trên đường dẫn
        String uri = request.getRequestURI();
        System.out.println("URI laf: "+uri);

        if(uri.contains("/category/hien-thi")){
            this.hienThiCategory(request,response);

        }else if(uri.contains("/category/detail")){
            this.detailCategory(request,response);

        }else if(uri.contains("/category/delete")){
            this.deleteCategory(request,response);

        }else if(uri.contains("/category/view-update")){
            this.viewUpdateCategory(request,response);

        }else if (uri.contains("/category/search")){
            this.searchCategory(request,response);

        }else if (uri.contains("/category/view-add")) {
            this.viewAddCategory(request,response);

        }else {

        }
    }

    private void viewAddCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/add-category.jsp").forward(request,response);
    }

    private void searchCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //b1: lay gia tri duocw truyen tren duong dan
        String id = request.getParameter("a");
        //b2 lay ra doi tuong detail
        Category cate = cateRepo.getOne(Long.valueOf(id));
        //b3: truyen gia tri cate ->jsp
        request.setAttribute("cate",cate);
        //b4 chuyen trang
        request.getRequestDispatcher("/update-cate.jsp").forward(request,response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //b1: lay gia tri duocw truyen tren duong dan
        String id = request.getParameter("a");
        Category cate = cateRepo.getOne(Long.valueOf(id));
        //b2: goi ham xoa trong repo
        cateRepo.delete(cate);
        //b3: chuyen trang - c2=> category/hien-thi
        response.sendRedirect("/category/hien-thi");
    }

    private void detailCategory(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //b1: lay gia tri duocw truyen tren duong dan
        String id = request.getParameter("a");
        //b2 lay ra doi tuong detail
        Category cate = cateRepo.getOne(Long.valueOf(id));
        //b3: truyen gia tri cate ->jsp
        request.setAttribute("cate",cate);
        //b4 chuyen trang
        request.getRequestDispatcher("/detail-cate.jsp").forward(request,response);
    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //b1: lay ra list ->getAll
//        List<Category>lists = cateRepo.getAll();
        //b2: truyen bien servlet -> jsp
        // request.setAttribute("lists1,lists);
        request.setAttribute("listsCate", cateRepo.getAll()); // luu ý
        //chuyen trang
        request.getRequestDispatcher("/categorys.jsp").forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        System.out.println("URI la: " + uri);

        if (uri.contains("/category/add")) {
            this.addCategory(request, response);

        } else if (uri.contains("/category/update")) {
            this.updateCategory(request, response);
        }
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
    }
    @SneakyThrows
    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws IOException{
        Category cate = new Category();

//        try {
//            BeanUtils.populate(cate, request.getParameterMap());
//            cateRepo.add(cate);
//            response.sendRedirect("/category/hien-thi");
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        }
        //b1: lay toan bo gia tri cua cac o input jsp
        // BeanUtil -> mapping toan bo gia tri input - tu dong mapping
        // mapping name input trung` name entity
        BeanUtils.populate(cate,request.getParameterMap());
        // B2: Goi add trong cate
        cateRepo.add(cate);
        // B3: Quay ve trang hien thi
        response.sendRedirect("/category/hien-thi");
    }
}