package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.DAO.UserDAO;
import org.example.DAO.UserDAOImpl;
import org.example.model.User;

import java.io.IOException;
import java.util.List; 

@WebServlet("/searchUser")
public class SearchUserServlet extends HttpServlet {

    private final UserDAO userDAO = new UserDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int minFollowers = parseInt(request.getParameter("minFollowers"), 0);
        int minFollowing = parseInt(request.getParameter("minFollowing"), 0);

        List<User> matchedUsers = userDAO.searchUsersByFollow(minFollowers, minFollowing);

        request.setAttribute("users", matchedUsers);
        request.getRequestDispatcher("searchUser.jsp").forward(request, response);
    }

    private int parseInt(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
