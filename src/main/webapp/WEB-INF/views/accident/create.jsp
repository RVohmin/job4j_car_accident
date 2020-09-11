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
<form  action="<c:url value='/save'/>" method='POST'>
    <table>
        <tr>
            <td>Название:</td>
            <td><label>
                <input type='text' name='name'>
            </label>Имя</td>
            <td><label>
                <input type='text' name='text'>
            </label>Текст</td>
            <td><label>
                <input type='text' name='address'>
            </label>Адрес</td>
        </tr>
        <tr>
            <td colspan='2'><input name="submit" type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form>
</body>
</html>
