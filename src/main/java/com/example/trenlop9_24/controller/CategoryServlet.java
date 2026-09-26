package com.example.trenlop9_24.controller;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //kiểm tra chứa trong chuỗi: contains
        //B1: lấy uri trên đường dẫn
        String uri = request.getRequestURI();
        System.out.println("URI laf: "+uri);

        if(uri.contains("/category/hien-thi")){
            //chuc nang hien thi
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
            this.hienThiCategory(request,response);
        }
    }

    private void viewAddCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        System.out.println("URI la: " + uri);

        if (uri.contains("/category/add")) {
            this.addCategory(request,response);
        } else if (uri.contains("/category/update")) {
            this.updateCategory(request,response);

        }else {}
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) {
    }
}