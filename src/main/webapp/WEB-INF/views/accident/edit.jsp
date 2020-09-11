<%--
  Created by IntelliJ IDEA.
  User: romanvohmin
  Date: 11.09.2020
  Time: 08:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/update'/>" method='POST'>
    <table>
        <tr>
        <tr>
            <td>
                <input type='hidden' name='id' value="${accident.id}">
                <label>Имя заявителя
                    <input type='text' name='name' value="${accident.name}">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>Адрес заявителя
                    <input type='text' name='address' value="${accident.address}">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>Номер авто
                    <input type='text' name='carNumber' value="${accident.carNumber}">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>Описание происшествия
                    <input type='text' name='describe' value="${accident.describe}">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>Фото
                    <input type='text' name='photo' value="${accident.photo}">
                </label>
            </td>
        </tr>
        <tr>
            <td>
                <label>Статус
                    <input type='text' name='status' value="${accident.status}">
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

