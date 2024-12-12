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
<link href="${pageContext.request.contextPath }/css/post_modify.css"
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
	<!-- Page content-->
	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-8">
				<form name="modify_form" id="modify_form" method="post"
					action="${pageContext.request.contextPath}/post_modify_action">
					<div class="mt-2"></div>
					<h5>Category</h5>
					<select name="categoryNum" class="form-control">
						<c:forEach var="category" items="${categoryList }">
							<option value="${category.num }"
								<c:if test="${post.categoryNum } == ${category.num }">selected="selected"</c:if>>
								${category.name }</option>
						</c:forEach>
					</select>
					<hr>
					<h5>Title</h5>
					<input type="text" name="title" id="title" class="form-control" value="${post.title }">
					<hr>
					<%-- <div class="form-control" contenteditable="true" id="realContent">${post.content }</div> --%>
					<textarea name="content" id="content" class="form-control" wrap="hard">${post.content }</textarea>
					<div id="btnArea">
						<button class="btn btn-success" type="button" id="submitBtn">Submit</button>
						<button class="btn btn-secondary" type="button" onclick="location.href = '${pageContext.request.contextPath }/main'" id="cancelBtn">Cancel</button>
					</div>
					<input type="hidden" name="num" id="num" value="${post.num }">
				</form>
			</div>
			<!-- Side widgets-->
			<div class="col-lg-4">
				<!-- Search Widget -->
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
				<!-- Category Widget -->
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
	<!-- Footer-->
	<footer class="py-5 bg-dark">
		<div class="container">
			<p class="m-0 text-center text-white">Copyright &copy;
				SimpleBoard 2024</p>
		</div>
	</footer>
</body>
<script src="${pageContext.request.contextPath }/js/post_modify.js"></script>
<script src="${pageContext.request.contextPath }/js/widget.js"></script>
</html>
