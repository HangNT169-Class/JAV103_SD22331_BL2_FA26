package com.example.demo4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// value -> CHUA TAT CAC CAC DUONG DAN THEO YEU CAU CUA DE
@WebServlet(name = "DangKyServlet", value = {
        "/dang-ki",
        "/ket-qua"
})
public class DangKyServlet extends HttpServlet {
    // 2 phuong GET & POST
    // POST: che giau thong tin -> k hien thi gia tri vua nhap tu ban phim/chon tren giao dien
    // GET: hien thi
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/dang-ky-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu o input(jsp) -> getParameter
        String ma = request.getParameter("mssv1");
        String ten = request.getParameter("ten1");
        String tuoi = request.getParameter("tuoi");
        String gioiTinh = request.getParameter("gioiTinh");
        String chuyenNganh = request.getParameter("chuyenNganh");
        // B2: Truyen gia tri servlet -> jsp moi: request.setAttribute
        request.setAttribute("a1",ma);
        request.setAttribute("a2",ten);
        request.setAttribute("a3",tuoi);
        request.setAttribute("a4",gioiTinh);
        request.setAttribute("a5",chuyenNganh);
        // B3: Chuyen trang moi
        request.getRequestDispatcher("/WEB-INF/ket-qua-hien-thi.jsp").forward(request, response);
    }
}
