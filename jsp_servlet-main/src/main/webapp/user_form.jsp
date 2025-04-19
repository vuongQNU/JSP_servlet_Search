
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Cập nhật hồ sơ</title>
</head>
<body>
<c:if test="${not empty success}">
    <p style="color: green;">${success}</p>
</c:if>

    <h2>Cập nhật hồ sơ người dùng</h2>

    <c:if test="${not empty errors}">
        <ul style="color:red;">
            <c:forEach var="err" items="${errors}">
                <li>${err}</li>
            </c:forEach>
        </ul>
    </c:if>

    <form action="userprofile" method="post" enctype="multipart/form-data">
        Email: <input type="email" name="email" required><br><br>
        Ngày sinh: <input type="date" name="dob" required><br><br>
        Nơi ở:
        <select name="province_id" required>
            <c:forEach var="p" items="${provinces}">
                <option value="${p.idProvince}">${p.nameProvince}</option>
            </c:forEach>
        </select><br><br>
        Ảnh đại diện: <input type="file" name="avatar" accept=".jpg,.png"><br><br>
        <input type="submit" value="Lưu thông tin">
    </form>
    
    <c:if test="${not empty user.avatar}">
    <img src="${pageContext.request.contextPath}/${user.avatar}" width="100" height="100" />
</c:if>
    
</body>
</html>
