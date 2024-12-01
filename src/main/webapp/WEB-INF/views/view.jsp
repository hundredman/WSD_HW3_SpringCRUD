<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>상세보기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container mt-5">
    <%@ include file="/inc/top.jsp" %>

    <h1 class="mb-4">게시글 상세보기</h1>

    <table class="table table-bordered">
        <tr>
            <th scope="row">카테고리</th>
            <td>${boardVO.category}</td>
        </tr>
        <tr>
            <th scope="row">제목</th>
            <td>${boardVO.title}</td>
        </tr>
        <tr>
            <th scope="row">글쓴이</th>
            <td>${boardVO.writer}</td>
        </tr>
        <tr>
            <th scope="row">내용</th>
            <td>${boardVO.content}</td>
        </tr>
        <tr>
            <th scope="row">등록일</th>
            <td>${boardVO.formattedRegdate}</td>
        </tr>
    </table>

    <div class="mt-4">
        <button class="btn btn-secondary" onclick="location.href='../list'">목록보기</button>
    </div>

    <%@ include file="/inc/bottom.jsp" %>
</div>
</body>
</html>
