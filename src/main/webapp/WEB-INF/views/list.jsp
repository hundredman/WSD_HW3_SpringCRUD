<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>게시판</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <%@ include file="/inc/top.jsp" %>

    <h1>게시판</h1>
    <form action="list" method="get" class="mb-4">
        <div class="row">
            <div class="col-md-4">
                <select name="searchBy" class="form-select">
                    <option value="category" ${searchBy == 'category' ? 'selected' : ''}>카테고리</option>
                    <option value="title" ${searchBy == 'title' ? 'selected' : ''}>제목</option>
                    <option value="writer" ${searchBy == 'writer' ? 'selected' : ''}>글쓴이</option>
                    <option value="content" ${searchBy == 'content' ? 'selected' : ''}>내용</option>
                </select>
            </div>
            <div class="col-md-4">
                <input type="text" name="search" value="${search}" class="form-control" placeholder="검색어 입력"/>
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-primary">검색</button>
                <button type="submit" class="btn btn-secondary" onclick="
                    document.querySelector('input[name=\'search\']').value = '';
                    document.querySelector('select[name=\'searchBy\']').value = 'title';">
                    초기화
                </button>
            </div>
        </div>
    </form>

    <table class="table table-striped table-hover table-bordered">
        <thead class="table-dark">
        <tr>
            <th>번호</th>
            <th>카테고리</th>
            <th>제목</th>
            <th>작성자</th>
            <th>내용</th>
            <th>등록일</th>
            <th>수정</th>
            <th>삭제</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList}" var="u">
            <tr>
                <td onclick="location.href='view/${u.id}'">${u.id}</td>
                <td onclick="location.href='view/${u.id}'">${u.category}</td>
                <td onclick="location.href='view/${u.id}'">${u.title}</td>
                <td onclick="location.href='view/${u.id}'">${u.writer}</td>
                <td onclick="location.href='view/${u.id}'">${u.content}</td>
                <td onclick="location.href='view/${u.id}'">${u.formattedRegdate}</td>
                <td><a href="edit/${u.id}" class="btn btn-warning btn-sm">글수정</a></td>
                <td><a href="javascript:delete_ok('${u.id}')" class="btn btn-danger btn-sm">글삭제</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <button type="button" onclick="location.href='add'" class="btn btn-success">새 글쓰기</button>

    <%@include file="/inc/bottom.jsp" %>

    <script>
        function delete_ok(id) {
            if (confirm("정말 삭제하시겠습니까?")) {
                location.href = 'deleteok/' + id;
            }
        }
    </script>
</div>
</body>
</html>
