<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Guest_and_srcs/Styles/bootstrap.min.css">
</head>
<body>

<c:forEach var="moviedetails" items="${Moviewatch}">
<div class="container mt-5">
    <!-- Movie Title -->
    <h1 class="text-center mb-4">
        ${moviedetails.moviename}
    </h1>

    <div class="row">
        <!-- Movie Poster and Video Section -->
        <div class="col-lg-6">
             <video class="w-100 rounded" controls>
                <source src="your-movie-file.mp4" type="video/mp4">
                Your browser does not support the video tag.
            </video>
        </div>

        <!-- Movie Description -->
        <div class="col-lg-6">
            <h4>Description</h4>
            <p>
                ${moviedetails.movielongdes}
            </p>
        </div>
    </div>
	</c:forEach>
    <!-- Comment Section -->
    <div class="mt-5">
        <h3>Comments</h3>
        <div class="mb-4">
            <!-- Existing comments -->
            <div class="card mb-2">
                <div class="card-body">
                    <strong>Daniel Le Roy:</strong>
                    <p>This movie was amazing! The plot was very engaging.</p>
                    <small class="text-muted">Posted on: 2024-09-20</small>
                </div>
            </div>
            <div class="card mb-2">
                <div class="card-body">
                    <strong>Karen Williams:</strong>
                    <p>Movie's CGI was questionable, and the jokes felt dank.</p>
                    <small class="text-muted">Posted on: 2024-09-21</small>
                </div>
            </div>
            <div class="card mb-2">
                <div class="card-body">
                    <strong>Shalman Kaan:</strong>
                    <p>I wanted to act in this movie bro.</p>
                    <small class="text-muted">Posted on: 2024-09-20</small>
                </div>
            </div>
            <div class="card mb-2">
                <div class="card-body">
                    <strong>Kalvin James:</strong>
                    <p>The jokes were very funny, and the violence was fun, my 9 year old son loved it! Would recommend.</p>
                    <small class="text-muted">Posted on: 2024-09-20</small>
                </div>
            </div>
        </div>

        <!-- Comment Writing and Submitting Section -->
        <div class="card">
            <div class="card-header">
                Write a Comment
            </div>
            <div class="card-body">
                <form action="MoviewatchServelet" method="post">
                    <div class="mb-3">
                        <input type="text" class="form-control" id="username" placeholder="Enter your name" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="commentText" class="form-label">Comment</label>
                        <textarea class="form-control" id="commentText" rows="3" placeholder="Write your comment here" required></textarea>
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Submit Comment</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>


</body>
</html>