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

        }else if(uri.contains("/category/detail")){

        }else if(uri.contains("/category/delete")){

        }else if(uri.contains("/category/view-update")){

        }else if (uri.contains("/category/search")){

        }else if (uri.contains("/category/view-add")) {

        }else {}
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uri = request.getRequestURI();
        System.out.println("URI la: " + uri);

        if (uri.contains("/category/add")) {

        } else if (uri.contains("/category/update")) {

        }else {}
    }
}