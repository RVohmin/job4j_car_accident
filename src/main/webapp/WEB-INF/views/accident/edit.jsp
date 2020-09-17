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
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700,900&display=swap&subset=cyrillic"
          rel="stylesheet">
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="shortcut icon" href="../../../img/favicon.ico"
          type="image/x-icon">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        <%@include file='../../../css/base.css' %>
        <%@include file='../../../css/main.css' %>

    </style>
    <title>Accident</title>
</head>
<body>
<div class="container">
    <div class="alert alert-success" role="alert">
        <a href="<c:url value='/logout'/>">Пользователь :
            ${user.username} | Выйти</a>
        <a href="<c:url value='/'/>">На главную</a>
    </div>

    <form action="<c:url value='/save'/>" method='POST' enctype="multipart/form-data">
        <div class="form-row">
            <div class="col-md-4 mb-6">
                <label for="form1">Имя заявителя</label>
                <input class="form-control" type='text' name='name' id="form1"
                       value="${accident.name}"
                       required>
            </div>
            <div class="col-md-4 mb-6">
                <label for="form">Адрес заявителя</label>
                <input class="form-control" type='text' name='address' id="form"
                       value="${accident.address}" required>
            </div>
            <div class="col-md-4 mb-3">
                <label for="form3">Номер авто</label>
                <input class="form-control" type='text' id="form3" name='carNumber'
                       value="${accident.carNumber}" required>
            </div>
            <div class="form-group col-md-12">
                <label for="exampleFormControlTextarea1">Описание происшествия</label>
                <textarea class="form-control" name="describe" id="exampleFormControlTextarea1"
                          rows="3">${accident.describe}</textarea>
            </div>

            <div class="col-md-6 mb-3">
                <label for="stat">Статус:</label>
                <select class="form-control" name="statusID" id="stat">
                    <c:forEach var="state" items="${statuses}">
                        <option value="${state.id}">
                            <c:out value="${state.id}"/>. <c:out value="${state.name}"/>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-md-6 mb-3">
                <label for="form4">Фото</label>
                <br>
                <input type='file' name='file' id="form4" value="${accident.fileName}">
            </div>
        </div>
        <input type='hidden' name='id' value="${accident.id}">
        <input name="submit" type="submit" value="Сохранить"/>
    </form>
</div>
</body>
</html>

