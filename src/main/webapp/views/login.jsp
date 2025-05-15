<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Đăng Nhập</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-container {
      background-color: white;
      padding: 30px 40px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      width: 300px;
    }

    h2 {
      text-align: center;
      margin-bottom: 20px;
    }

    input[type="text"],
    input[type="password"] {
      width: 100%;
      padding: 10px;
      margin: 8px 0 16px 0;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    input[type="submit"] {
      width: 100%;
      background-color: #4CAF50;
      color: white;
      padding: 10px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #45a049;
    }

    .note {
      text-align: center;
      margin-top: 10px;
      font-size: 0.9em;
      color: gray;
    }
  </style>
</head>
<body>
<div class="login-container">
  <h2>Đăng Nhập</h2>
  <form action="login" method="post">
    <label for="username">Tên đăng nhập:</label>
    <input type="text" id="username" name="username" required>
    <label for="password">Mật khẩu:</label>
    <input type="password" id="password" name="password" required>
    <input type="submit" value="Đăng nhập">
  </form>
  <c:if test="${error != null}">
    <h4>${error}</h4>
  </c:if>
</div>
</body>
</html>
