<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${success}">
    <h2>Đặt vé thành công!</h2>
    <p>Tổng tiền: ${total}đ</p>
</c:if>
<c:if test="${!success}">
    <h2>Đặt vé thất bại. Vui lòng thử lại.</h2>
</c:if>
