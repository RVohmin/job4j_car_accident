<%--
  Created by IntelliJ IDEA.
  User: romanvohmin
  Date: 11.09.2020
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
    <form action="<c:url value='/update'/>" method='POST'>
        <table>
            <tr>
                <td>Название:</td>
                <td>
                    <input type='hidden' name='id' value="${accident.id}">
                    <label>Имя заявителя
                        <input type='text' name='name' value="${accident.name}">
                    </label>
                </td>
                <td>
                    <label>Описание инцидента
                        <input type='text' name='text' value="${accident.text}">
                    </label>
                </td>
                <td>
                    <label>Адрес
                        <input type='text' name='address' value="${accident.address}">
                    </label>
                </td>
            </tr>
            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
            </tr>
        </table>
    </form>
</body>
</html>

