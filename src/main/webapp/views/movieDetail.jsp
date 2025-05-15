
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Chi tiết lịch chiếu</h2>

<p><strong>Phim:</strong> ${schedule.movieTitle}</p>
<p><strong>Thời gian chiếu:</strong> <fmt:formatDate value="${schedule.showTime}" pattern="dd/MM/yyyy HH:mm" /></p>
<p><strong>Phòng chiếu:</strong> ${schedule.screenRoomName}</p>
<p><strong>Số ghế còn trống:</strong> ${schedule.availableSeats}</p>
<p><strong>Định dạng:</strong> ${schedule.format}</p>
<a href="/book/${schedule.id}"><h4>Đặt vé</h4></a>
<a href="<c:url value='/schedules' />">Quay lại danh sách</a>
