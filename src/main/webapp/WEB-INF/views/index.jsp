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
    <link rel="shortcut icon" href="../../img/favicon.ico"
          type="image/x-icon">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        <%@include file='../../css/base.css' %>
        <%@include file='../../css/main.css' %>

    </style>
    <title>Accident</title>
</head>
<body>
<div class="container">
    <div class="alert alert-success" role="alert">
        <a href="<c:url value='/logout'/>">Login as :
            ${user.username} | Выйти</a>
    </div>
    <table class="table table-sm table-striped table-bordered table-hover">
        <thead class="thead-light">
        <tr>
            <th scope="col">id</th>
            <th scope="col">Заявитель</th>
            <th scope="col">Адрес</th>
            <th scope="col">№ Автомобиля</th>
            <th scope="col">Описание</th>
            <th scope="col">Фото</th>
            <th scope="col">Статус заявления</th>
            <th scope="col">Опции</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${accidents}" var="accident">
            <tr>
                <td>
                    <c:out value="${accident.id}"/>
                </td>
                <td>
                    <c:out value="${accident.name}"/>
                </td>
                <td>
                    <c:out value="${accident.address}"/>
                </td>
                <td>
                    <c:out value="${accident.carNumber}"/>
                </td>
                <td>
                    <c:out value="${accident.describe}"/>
                </td>
                <td>
                    <img src="<c:url value='/show?name=${accident.fileName}'/>" alt="File"
                         width="150px"
                         height="150px">
                </td>
                <td>
                    <c:out value="${accident.status.name}"/>
                </td>
                <td>
                    <a href='<c:url value="/edit?id=${accident.id}"/>'>
                        <i class="fa fa-edit mr-3"></i>
                    </a>
                    <a href='<c:url value="/delete?id=${accident.id}"/>'>
                        <span class="glyphicon glyphicon-trash"></span> <i class="fa fa-trash"
                                                                           style="color: red"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a class="btn btn-primary" href="<c:url value='/create'/>">Добавить инцидент</a>
</div>
</body>
</html>