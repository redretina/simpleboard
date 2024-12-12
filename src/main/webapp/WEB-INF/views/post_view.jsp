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
<link href="${pageContext.request.contextPath }/css/post_view.css"
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
				<c:if test="${post.state == 2 }">
					<a>This Post is Deleted.</a>
				</c:if>
				<c:if test="${post.state == 1 }">
					<!-- Post content-->
					<article>
						<c:if
							test="${loginMember.id == post.writer || loginMember.state == 9}">
							<div class="btn_area">
								<ul>
									<li><button type="button" id="postModifyBtn"
											class="btn btn-success" onclick="modifyPost(${post.num})">modify</button></li>
									<li><button type="button" id="postRemoveBtn"
											class="btn btn-secondary" onclick="deletePost(${post.num})">delete</button></li>
								</ul>
							</div>
						</c:if>
						<!-- Post header-->
						<header class="mb-4">
							<!-- Post title-->
							<h1 class="fw-bolder mb-1">${post.title }</h1>
							<!-- Post meta content-->
							<div class="text-muted fst-italic mb-2">${fn:substring(post.regdate, 0, 10) }
								by ${post.username }</div>
							<!-- Post categories-->
							<a class="badge bg-secondary text-decoration-none link-light"
								href="javascript:moveCategory(${post.categoryNum })">${post.categoryName }</a>
						</header>
						<!-- Post content-->
						<section class="mb-5">
							<p class="fs-5 mb-4">${post.content }</p>
						</section>
					</article>
					<!-- Comments section-->
					<c:if test="${post.state == 1 }">
						<section class="mb-5">
							<div class="card bg-light">
								<div class="card-body">
									<!-- Comment form-->
									<form class="mb-4" id="replyForm"
										action="${pageContext.request.contextPath }/reply_write_action">
										<textarea id="replyContent" name="content"
											class="form-control" rows="3" style="resize: none"
											<c:if test="${loginMember == null }">
											placeholder="Login to leave the comment"
											disabled=true
											</c:if>></textarea>
										<div class="message_area">
											<span id="replyMessage"> </span>
										</div>
										<div class="btn_area">
											<ul>
												<li><button type="button" id="replySubmitBtn"
														class="btn btn-success"
														<c:if test="${loginMember==null }">
															disabled=true
														</c:if>>submit</button></li>
											</ul>
										</div>
										<input type="hidden" name="postNum" value="${post.num }">
										<input type="hidden" name="writer" value="${loginMember.id }">
									</form>
									<!-- Comment View -->
									<c:forEach var="reply" items="${replyList }">
										<c:if test="${reply.state == 1 }">
											<div class="mb-4">
												<div class="ms-3">
													<div class="fw-bold">${reply.username }</div>
													<div id="replyContentArea${reply.num }">
														<div id="replyContent${reply.num }">
															<p id="realReplyContent${reply.num }">${reply.content }</p>
															<div class="text-muted fst-italic">
																${fn:substring(post.regdate, 0, 10) }
																<c:if test="${reply.writer == loginMember.id || loginMember.state == 9}">
																	<a href="javascript:modifyReply(${reply.num})">modify</a>
																	<a href="javascript:deleteReply(${reply.num})">delete</a>
																</c:if>
															</div>
														</div>
													</div>
												</div>
											</div>
										</c:if>
										<c:if test="${reply.state == 2 }">
											<div class="mb-4">
												<div class="ms-3">
													<div class="text-muted fst-italic">Deleted Comment.</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
							<form class="mb-4" id="replyModifyForm"
								action="${pageContext.request.contextPath }/reply_modify_action"
								style="display: none">
								<textarea id="replyModifyContent" name="content"
									class="form-control" rows="3" style="resize: none"></textarea>
								<div class="message_area">
									<span id="replyModifyMessage"> </span>
								</div>
								<div class="btn_area">
									<ul>
										<li><button type="button" id="replyModifySubmitBtn"
												class="btn btn-success">submit</button></li>
										<li><button type="button" id="replyModifyCancelBtn"
												class="btn btn-secondary">cancel</button></li>
									</ul>
								</div>
								<input id="replyModifyNum" type="hidden" name="num">
							</form>
						</section>
					</c:if>
				</c:if>
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
<script src="${pageContext.request.contextPath }/js/post_view.js"></script>
<script src="${pageContext.request.contextPath }/js/widget.js"></script>
</html>
