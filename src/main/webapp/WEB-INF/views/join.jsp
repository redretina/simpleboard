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
<link href="${pageContext.request.contextPath }/css/join.css"
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
				<form name="join_form" id="join_form" method="post" action="${pageContext.request.contextPath }/join_action">
					<div class="card my-4">
						<h3 class="card-header">Join</h3>
						<div class="card-body">
							<div class="input-group">
								<ul class="join_list">
									<li>ID <input type="text" name="id" id="id"
										class="form-control" placeholder="6~18 characters of abc or 123"></li>
									<li>Password <input type="password" name="password"
										id="password" class="form-control"
										placeholder="8~20 characters of abc, 123, or !^*"></li>
									<li>Username <input type="text" name="username"
										id="username" class="form-control" placeholder=""></li>
									<li>Name <input type="text" name="name" id="name"
										class="form-control" placeholder=""></li>
									<li>Phone <select name="phone1" id="phone1"
										class="form-control phone">
											<option value="010" selected="selected">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
											<option value="017">017</option>
											<option value="018">018</option>
											<option value="019">019</option>
									</select> - <input type="text" name="phone2" id="phone2" maxlength="4"
										class="form-control phone"> - <input type="text"
										name="phone3" id="phone3" maxlength="4"
										class="form-control phone">
									</li>
									<li>Email <input type="text" name="email" id="email"
										class="form-control"></li>
								</ul>
							</div>
							<div id="messageDiv">
								<span id="message"> </span>
							</div>
							<div class="btn-group">
								<button type="button" id="joinSubmit"
									class="form-control btn btn-primary">Submit</button>
								<button type="button" id="joinCancel"
									onclick="location.href='${pageContext.request.contextPath}/main'"
									class="form-control btn btn-secondary">Cancel</button>
							</div>
						</div>
					</div>
					<input type="hidden" name="phone" id="phone">
					<input type="hidden" name="status" value="1">
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
<script src="${pageContext.request.contextPath }/js/join.js"></script>
<script src="${pageContext.request.contextPath }/js/widget.js"></script>
</html>
