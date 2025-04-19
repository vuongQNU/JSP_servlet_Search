package org.example.controller;


import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


import org.example.DAO.ProvinceDAO;
import org.example.DAO.UserDAO;
import org.example.DAO.UserDAOImpl;
import org.example.model.Province;
import org.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet("/userprofile")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 200 * 1024,
        maxRequestSize = 1024 * 1024)
public class UserProfileServlet extends HttpServlet {
    private final UserDAO userDAO = new UserDAOImpl();
    private final ProvinceDAO provinceDAO = new ProvinceDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Province> provinces = provinceDAO.getAll();
        request.setAttribute("provinces", provinces);
        request.getRequestDispatcher("/user_form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession(false);
    	User currentUser = (User) session.getAttribute("user");
        List<String> errors = new ArrayList<>();
        String email = request.getParameter("email");
        String dob = request.getParameter("dob");
        String provinceIdStr = request.getParameter("province_id");
        Part avatarPart = request.getPart("avatar");

        // Validate email format
        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            errors.add("Email không hợp lệ.");
        }

        // Validate email duplication
        if (userDAO.existsByEmail(email)) {
            errors.add("Email đã tồn tại.");
        }

        // Validate dob
        LocalDate birthDate = LocalDate.parse(dob);
        if (ChronoUnit.YEARS.between(birthDate, LocalDate.now()) < 15) {
            errors.add("Bạn phải đủ 15 tuổi để đăng ký.");
        }

        // Validate file upload
        String avatarPath = null;
        if (avatarPart != null && avatarPart.getSize() > 0) {
            String contentType = avatarPart.getContentType();
            if (!(contentType.equals("image/jpeg") || contentType.equals("image/png"))) {
                errors.add("Ảnh đại diện phải là định dạng JPG hoặc PNG.");
            } else if (avatarPart.getSize() > 200 * 1024) {
                errors.add("Kích thước ảnh không được vượt quá 200KB.");
            } else {
                String fileName = Paths.get(avatarPart.getSubmittedFileName()).getFileName().toString();

                // Đường dẫn tuyệt đối tới thư mục /img
                String uploadPath = getServletContext().getRealPath("/img");
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) uploadDir.mkdirs(); // tạo thư mục nếu chưa có

                // Ghi file ảnh vào thư mục /img
                avatarPart.write(uploadPath + File.separator + fileName);

                // Lưu đường dẫn tương đối vào DB
                avatarPath = "img/" + fileName;
            }
        }


        // Nếu có lỗi, quay lại form
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            doGet(request, response);
            return;
        }

        currentUser.setEmail(email);
        currentUser.setDob(birthDate);
        currentUser.setProvince_id(Integer.parseInt(provinceIdStr));
        if (avatarPath != null) {
            currentUser.setAvatar(avatarPath);
        }
        userDAO.update(currentUser); // gọi update thay vì insert

        request.setAttribute("success", "Cập nhật thông tin thành công!");
        doGet(request, response); // load lại form kèm message
    }
}
