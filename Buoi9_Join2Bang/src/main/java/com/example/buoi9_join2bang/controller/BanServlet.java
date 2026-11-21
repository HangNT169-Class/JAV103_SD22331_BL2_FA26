package com.example.buoi9_join2bang.controller;

import com.example.buoi9_join2bang.repository.BanRepository;
import com.example.buoi9_join2bang.repository.MQHRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BanServlet", value = "/BanServlet")
public class BanServlet extends HttpServlet {

    private BanRepository banRepository = new BanRepository();

    private MQHRepository mqhRepository = new MQHRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("BanServlet")) {
            this.hienThiDuLieu(request, response);
        }
    }

    private void hienThiDuLieu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listBan", banRepository.getAll());
        request.setAttribute("listMQH", mqhRepository.getAll());
        request.getRequestDispatcher("/ban.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
