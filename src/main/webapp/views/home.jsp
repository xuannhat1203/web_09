<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách phim</title>
  <style>
    body { font-family: Arial; padding: 20px; }
    .movie-list { display: grid; grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); gap: 15px; }
    .movie-card {
      border: 1px solid #ccc; border-radius: 8px; padding: 15px;
      background-color: #f9f9f9;
    }
    .movie-card h2 { margin: 0 0 10px; color: #333; }
    .movie-card p { margin: 5px 0; }
    .movie-card a {
      display: inline-block; margin-top: 10px;
      text-decoration: none; color: white; background-color: #007BFF;
      padding: 6px 12px; border-radius: 4px;
    }
  </style>
</head>
<body>

<h1>Phim đang chiếu</h1>
<div class="movie-list">
  <c:forEach var="movie" items="${movieList}">
    <div class="movie-card">
      <h2>${movie.title}</h2>
      <p><strong>Đạo diễn:</strong> ${movie.director}</p>
      <p><strong>Thể loại:</strong> ${movie.genre}</p>
      <a href="movie-detail?id=${movie.id}">Xem chi tiết</a>
    </div>
  </c:forEach>
</div>

</body>
</html>

