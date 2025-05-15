
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách phim đang chiếu</title>
</head>
<body>
<h2>Danh sách phim đang chiếu</h2>
<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>Phim</th>
        <th>Thời gian chiếu</th>
        <th>Phòng chiếu</th>
        <th>Số ghế còn trống</th>
        <th>Định dạng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty scheduleList}">
        <tr><td colspan="6">Không có lịch chiếu nào.</td></tr>
    </c:if>
    <c:forEach var="schedule" items="${scheduleList}">
        <tr>
            <td>${schedule.movieTitle}</td>
            <td><fmt:formatDate value="${schedule.showTime}" pattern="dd/MM/yyyy HH:mm"/></td>
            <td>${schedule.screenRoomName}</td>
            <td>${schedule.availableSeats}</td>
            <td>${schedule.format}</td>
            <td>
                <form action="/detail/${schedule.id}" method="get">
                    <input type="hidden" name="id" value="${schedule.id}" />
                    <input type="submit" value="Xem chi tiết" />
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
