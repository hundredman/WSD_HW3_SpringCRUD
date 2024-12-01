<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>게시물 수정</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container mt-5">
    <%@ include file="/inc/top.jsp" %>

    <h1 class="mb-4">게시물 수정</h1>
    <form:form modelAttribute="boardVO" method="post" action="../editok">
        <form:hidden path="id"/>

        <div class="mb-3">
            <label for="category" class="form-label">카테고리</label>
            <form:input path="category" class="form-control" id="category" />
        </div>

        <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <form:input path="title" class="form-control" id="title" />
        </div>

        <div class="mb-3">
            <label for="writer" class="form-label">글쓴이</label>
            <form:input path="writer" class="form-control" id="writer" />
        </div>

        <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <form:textarea path="content" class="form-control" id="content" rows="5" />
        </div>

        <div class="d-flex justify-content-between">
            <input type="submit" value="수정하기" class="btn btn-primary"/>
            <input type="button" value="취소하기" class="btn btn-secondary" onclick="history.back()"/>
        </div>
    </form:form>

    <%@ include file="/inc/bottom.jsp" %>
</div>
</body>
</html>
