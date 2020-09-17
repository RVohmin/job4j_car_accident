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
    <title>Accident - Create</title>
</head>

<body>
<div class="container">
    <div class="alert alert-success" role="alert">
        <a href="<c:url value='/logout'/>">Login as :
            ${user.username} | Выйти</a>
        <a href="<c:url value='/'/>">На главную</a>
    </div>
    <form action="<c:url value='/save'/>" method="post" enctype="multipart/form-data">
        <div class="input-group col-md-6 mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="basic-addon3">Имя заявителя</span>
            </div>
            <input type="text" class="form-control" name='name' aria-describedby="basic-addon3">
        </div>
        <div class="input-group col-md-6 mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="input2">Адрес</span>
            </div>
            <input type="text" class="form-control" name='address' aria-describedby="input2">
        </div>
        <div class="input-group col-md-6 mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" id="input3">Номер авто</span>
            </div>
            <input type="text" class="form-control" name='carNumber' aria-describedby="input3">
        </div>
        <div class="input-group col-md-6">
            <div class="input-group-prepend">
                <span class="input-group-text">Описание<br/>происшествия</span>
            </div>
            <textarea class="form-control" name='describe' rows="3"
                      aria-label="With textarea"></textarea>
        </div>
        <br/>

        <div class="input-group col-md-6 mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text" for="stat">Статус заявления</span>
            </div>
            <select class="custom-select" name="statusID" id="stat">
                <c:forEach var="state" items="${statuses}">
                    <option value="${state.id}">
                        <c:out value="${state.id}"/>. <c:out value="${state.name}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <br/>
        <div class="input-group col-md-6">
            <div class="input-group-prepend">
                <%--                <span class="input-group-text" id="input5">Фото</span>--%>
                <input type='file' name='file'>
            </div>
        </div>
        <br/>

        <div class="input-group col-md-6 mb-3">
            <input class="btn btn-primary" name="submit" type="submit" value="Сохранить"/>
        </div>

    </form>
</div>
</body>
</html>
