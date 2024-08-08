<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>SocialMedia Login</title>

  <!-- CSS -->
  <link rel="stylesheet" href="css/login.css">

  <!-- Bootstrap CSS -->
  <!-- <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
-->

  <!-- Page Specific Bootstrap Core CSS-->
  <link rel="stylesheet" href="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/css/dist/mdb5/standard/core.min.css">

</head>
<body>
<section class="h-100 gradient-form" style="background-color: #eee;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-xl-10">
        <div class="card rounded-3 text-black">
          <div class="row g-0">
            <div class="col-lg-6">
              <div class="card-body p-md-5 mx-md-4">

                <div class="text-center">
                  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
                       style="width: 185px;" alt="logo">
                  <!-- <h4 class="mt-1 mb-5 pb-1">We are The Lotus Team</h4> -->
                </div>

                <form>
                  <p align="center">Please login to your account</p>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="form2Example11" class="form-control"
                           placeholder="Phone number or email address" name="credential1" required/>
                    <label class="form-label" for="form2Example11">Username</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="password" id="typePassword" class="form-control" name="password" minlength="8" maxlength="20" required/>
                    <label class="form-label" for="typePassword">Password</label>
                  </div>

                  <div class="text-center pt-1 mb-5 pb-1">
                    <input data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block fa-lg gradient-linear mb-3" type="submit" formmethod="post" formaction="login" value="Login">
                    <a class="text-muted" href="#">Forgot password?</a>
                  </div>

                  <div class="d-flex align-items-center justify-content-center pb-4">
                    <p class="mb-0 me-2">Don't have an account?</p>
                    <a type="button" href="register.jsp" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-danger">Create new</a>
                  </div>
                </form>

              </div>
            </div>
            <div class="col-lg-6 d-flex align-items-center gradient-diagonal">
              <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                <h4 class="mb-4">Let's Connect With The World</h4>
                <p class="small mb-0">SocialMedia is where you connect with the world. You can follow people
                  like their posts, Comment on it more. Login to your account and get going. If you don't have
                  an account with SocialMedia you can register for one free now. Click on Register Now Button.
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!--
<script type="text/javascript" src="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/js/dist/mdb5/standard/core.min.js"></script>
-->

<!--
<script src="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/js/dist/main.min.js"></script>
-->

</body>
</html>