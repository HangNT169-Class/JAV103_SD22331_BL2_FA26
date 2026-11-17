package com.example.b4_hibernate.controller;

import com.example.b4_hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "CategoryServlet", value = {
        // duong dan bat dau bang dau /
        // duong dan la duy nhat trong ca project
        "/category/hien-thi", // GET
        "/category/detail",// GET
        "/category/delete",// GET
        "/category/search",// GET (Co the de post tuy)
        "/category/update", // POST
        "/category/add", // POST
        "/category/view-add", // GET
        "/category/view-update",// GET
})
public class CategoryServlet extends HttpServlet {

    private CategoryRepository cateRepo = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            // hien thi
            this.hienThiDuLieu(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailCate(request, response);
        } else if (uri.contains("delete")) {
            // delete
            this.deleteCate(request, response);
        } else if (uri.contains("search")) {
            // search
            this.searchCate(request, response);
        } else if (uri.contains("view-add")) {
            // view-add
            this.viewAddCate(request, response);
        } else {
            // view-update
            this.viewUpdateCate(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            // add
            this.add(request, response);
        } else {
            // post
            this.update(request, response);
        }
    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void searchCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("lists1", cateRepo.getAll());
        request.getRequestDispatcher("/buoi3/categorys.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }
}
