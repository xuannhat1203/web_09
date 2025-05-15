<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Đặt vé xem phim</h2>
<form action="/book" method="post">
  <input type="hidden" name="scheduleId" value="${scheduleId}" />
  <input type="hidden" name="customerId" value="1" /> <!-- giả lập -->

  <c:forEach var="seat" items="${seats}">
    <c:if test="${seat.status == 'available'}">
      <label>
        <input type="checkbox" name="seatIds" value="${seat.id}" />
          ${seat.seatNumber} - ${seat.price}đ
      </label><br/>
    </c:if>
  </c:forEach>

  <button type="submit">Đặt vé</button>
</form>

