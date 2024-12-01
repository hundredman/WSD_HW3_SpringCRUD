<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>새 글쓰기</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <%@ include file="/inc/top.jsp" %>

    <h1 class="mb-4">새 글쓰기</h1>
    <form action="addok" method="post">
        <div class="mb-3">
            <label for="category" class="form-label">카테고리</label>
            <input type="text" class="form-control" id="category" name="category" required>
        </div>
        <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" name="title" required>
        </div>
        <div class="mb-3">
            <label for="writer" class="form-label">글쓴이</label>
            <input type="text" class="form-control" id="writer" name="writer" required>
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" id="content" name="content" rows="5" required></textarea>
        </div>

        <div class="d-flex justify-content-between">
            <button type="button" onclick="location.href='list'" class="btn btn-secondary">목록보기</button>
            <button type="submit" class="btn btn-primary">등록하기</button>
        </div>
    </form>

    <%@ include file="/inc/bottom.jsp" %>
</div>
</body>
</html>
