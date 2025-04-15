<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Kết quả tìm kiếm người dùng</title>
    <style>
        .user-card {
            background: #f9f9f9;
            border-radius: 12px;
            padding: 20px;
            margin-bottom: 16px;
            box-shadow: 0 2px 6px rgba(0,0,0,0.1);
        }
        .not-found {
            text-align: center;
            margin-top: 40px;
        }
        .not-found img {
            width: 300px;
            opacity: 0.8;
        }
    </style>
</head>
<body>

<h2>Kết quả tìm kiếm người dùng</h2>

<c:choose>
    <c:when test="${not empty users}">
        <c:forEach var="user" items="${users}">
            <div class="user-card">
                <strong>${user.username}</strong>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <div class="not-found">
            <img src="assets/not-found.png" alt="Không tìm thấy người dùng">
            <p>Không có người dùng phù hợp</p>
        </div>
    </c:otherwise>
</c:choose>

</body>
</html>
