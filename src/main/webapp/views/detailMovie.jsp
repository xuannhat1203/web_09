<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.baitap.session09.modal.Movie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết phim</title>
    <style>
        body { font-family: Arial; padding: 30px; }
        .movie-detail {
            max-width: 600px; margin: auto; border: 1px solid #ddd;
            padding: 20px; border-radius: 8px; background-color: #fefefe;
        }
        h1 { color: darkred; }
        p { line-height: 1.6; }
        .label { font-weight: bold; }
        a {
            display: inline-block; margin-top: 20px; text-decoration: none;
            color: white; background-color: #28a745; padding: 8px 14px; border-radius: 4px;
        }
    </style>
</head>
<body>
<%
    Movie movie = (Movie) request.getAttribute("movie");
%>
<c:if test="${movie != null}">
    <div class="movie-detail">
        <h1><%= movie.getTitle() %></h1>
        <p><span class="label">Đạo diễn:</span> <%= movie.getDirector() %></p>
        <p><span class="label">Thể loại:</span> <%= movie.getGenre() %></p>
        <p><span class="label">Ngôn ngữ:</span> <%= movie.getLanguage() %></p>
        <p><span class="label">Thời lượng:</span> <%= movie.getDuration() %> phút</p>
        <p><span class="label">Mô tả:</span> <%= movie.getDescription() %></p>
        <a href="home">Quay lại danh sách</a>
    </div>
</c:if>
</body>
</html>
