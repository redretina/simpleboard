<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SimpleBoard</title>
<link href="${pageContext.request.contextPath }/css/styles.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath }/css/main.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<!-- nav bar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand"
				href="${pageContext.request.contextPath }/main">SimpleBoard</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-2 mb-lg-0">
					<c:if test="${loginMember == null }">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath }/login">Login</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath }/join">Join</a></li>
					</c:if>
					<c:if test="${loginMember != null }">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath }/post_write">Write</a></li>
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="${pageContext.request.contextPath }/logout">Logout</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="${pageContext.request.contextPath }/mypage">MyPage</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<header class="py-5 bg-light border-bottom mb-4" id="banner">
		<div class="container">
			<div class="text-center my-5">
				<h1 class="fw-bolder" style="color: white">SimpleBoard</h1>
				<p class="lead mb-0" style="color: white">Simple CRUD Board
					Example</p>
			</div>
		</div>
	</header>
	<!-- Page content-->
	<div class="container">
		<div class="row">
			<!-- Blog entries-->
			<div class="col-lg-8">
				<!-- Nested row for non-featured blog posts-->
				<div class="row">
					<c:if test="${searchKeyword != null && searchKeyword != ''}">
						<p>keyword : ${searchKeyword }</p>
					</c:if>
					<c:if test="${categoryNum != null && categoryNum != ''}">
						<p>category : ${categoryName }</p>
					</c:if>
					<!-- Blog post-->
					<c:forEach var="post" items="${postList }">
						<div class="card mb-4">
							<div class="card-body">
								<h2 class="card-title h4">${post.title }</h2>
								<p class="card-text">
									<c:if test="${fn:length(post.content) gt 300 }">
									${fn:substring(post.content, 0, 300) }...
								</c:if>
									<c:if test="${fn:length(post.content) le 300 }">
									${post.content }
								</c:if>
								</p>
								<a class="btn btn-primary"
									href="${pageContext.request.contextPath }/post_view/${post.num}">Read
									more →</a>
							</div>
							<div class="card-footer text-muted">
								${fn:substring(post.regdate, 0, 10) } by ${post.username }</div>
						</div>
					</c:forEach>
					<c:if test="${postList.size() == 0 }">
						<div class="card mb-4">
							<div class="card-body" style="text-align: center">

								<h2 class="my-4" style="text-align: center;">No Post Found.</h2>
								<c:if test="${loginMember != null }">
									<a class="btn btn-primary" style="align: center"
										href="${pageContext.request.contextPath }/post_write">Write
										Post</a>
								</c:if>
							</div>
						</div>
					</c:if>
				</div>
				<!-- Pagination-->
				<c:if test="${postList.size() != 0 }">
					<nav aria-label="Pagination">
						<hr class="my-0" />
						<ul class="pagination justify-content-center my-4">
							<li
								class="page-item <c:if test="${pager.startPage==1 }">disabled</c:if>">
								<a class="page-link" href="#" tabindex="-1">prev</a>
							</li>
							<c:forEach var="i" begin="${pager.startPage }"
								end="${pager.endPage }">
								<li
									class="page-item <c:if test="${i == pager.pageNum }">disabled</c:if>">
									<a class="page-link" href="javascript:movePage(${i })">${i }</a>
								</li>
							</c:forEach>
							<li
								class="page-item <c:if test="${pager.totalPage==pager.endPage }">disabled</c:if>">
								<a class="page-link" href="#!">next</a>
							</li>
						</ul>
					</nav>
				</c:if>
			</div>
			<!-- Side widgets-->
			<div class="col-lg-4">
				<!-- 검색 위젯 -->
				<form name="search_form" id="search_form" method="post"
					action="${pageContext.request.contextPath }/main">
					<div class="card my-4">
						<h5 class="card-header">Search</h5>
						<div class="card-body">
							<div class="input-group">
								<input type="text" name="searchInput" id="searchInput"
									class="form-control" placeholder="Enter the search term">
								<input type="hidden" name="searchKeyword" id="searchKeyword"
									value="${searchKeyword }"> <span
									class="input-group-append">
									<button class="btn btn-secondary" onclick="moveSearch();"
										type="button">search</button>
								</span>
							</div>
						</div>
					</div>
				</form>
				<!-- 카테고리 위젯 -->
				<div class="card my-4">
					<h5 class="card-header">Categories</h5>
					<div class="card-body">
						<div class="row">
							<div id="categoryListArea">
								<ul class="list-unstyled">
									<c:forEach var="category" items="${categoryList }">
										<li><a href="javascript:moveCategory(${category.num })">${category.name }</a></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<form name="category_form" id="category_form" method="post"
					action="${pageContext.request.contextPath }/main">
					<input type="hidden" name="categoryNum" id="categoryNum"
						value="${categoryNum }">
				</form>
			</div>
		</div>
	</div>
	<form name="post_form" id="post_form" method="post">
		<input type="hidden" name="pageNum" id="pageNum" value="${pageNum }">
		<input type="hidden" name="categoryNum" value="${categoryNum }">
		<input type="hidden" name="searchKeyword" value="${searchKeyword }">
	</form>
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy;
				SimpleBoard 2024</p>
		</div>
	</footer>
</body>
<script src="${pageContext.request.contextPath }/js/main.js"></script>
<script src="${pageContext.request.contextPath }/js/widget.js"></script>
</html>