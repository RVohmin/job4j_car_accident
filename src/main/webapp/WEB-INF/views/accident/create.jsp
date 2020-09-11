<%--
  Created by IntelliJ IDEA.
  User: romanvohmin
  Date: 09.09.2020
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<form action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Новое происшествие:</td>
        </tr>
        <tr>
        <td><label> Заявитель
            <input type='text' name='name'>
        </label>
        </td>
        <td><label>Адрес
            <input type='text' name='address'>
        </label>
        </td>
        <td><label>Номер авто
            <input type='text' name='carNumber'>
        </label>
        </td>
            <td><label>Описание
                <input type='text' name='describe'>
            </label>
            </td>
            <td><label>Фото
                <input type='text' name='photo'>
            </label>
            </td>
            <td><label>Статус
                <input type='text' name='status'>
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
