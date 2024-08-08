<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Register - SocialMedia</title>

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

            <div class="col-lg-6 d-flex align-items-center gradient-diagonal">
              <div class="text-white px-3 py-4 p-md-5 mx-md-4">
                <h4 class="mb-4">Let's Connect With The World</h4>
                <p class="small mb-0">SocialMedia is where you connect with the world. You can follow people
                  like their posts, Comment on it more. Login to your account and get going. If you don't have
                  an account with SocialMedia you can register for one free now. Click on Register Now Button.
                </p>
              </div>
            </div>

            <div class="col-lg-6 d-flex">
              <div class="card-body p-md-5 mx-md-4">
                <div class="text-center">
                  <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/lotus.webp"
                       style="width: 185px;" alt="logo">
                  <!-- <h4 class="mt-1 mb-5 pb-1">We are The Lotus Team</h4> -->
                </div>

                <form>
                  <p class="Text-center">Please Enter Credentials for New Account</p>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="fname" class="form-control"
                           name="fname" maxlength="20" pattern="^[a-zA-Z]+$" required/>
                    <label class="form-label" for="fname">First Name</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="lname" class="form-control"
                           name="lname" maxlength="20" pattern="^[a-zA-Z]+$" required/>
                    <label class="form-label" for="lname">Last Name</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="text" id="uname" class="form-control"
                            name="uname" pattern="^\S{1,20}$" required/>
                    <label class="form-label" for="uname">Username</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="email" id="mail" class="form-control"
                           placeholder="example@example.com" name="mail" required/>
                    <label class="form-label" for="mail">Email</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="tel" id="phone" class="form-control"
                           placeholder="1234567890" minlength="10" maxlength="10" pattern="[0-9]{10}" name="phone"/>
                    <label class="form-label" for="phone">Phone</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="password" id="typePassword" class="form-control" name="password" minlength="8" maxlength="20" required/>
                    <label class="form-label" for="typePassword">Password</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <input type="password" id="typeRe-Password" class="form-control" name="re-password" minlength="8" maxlength="20"  required/>
                    <label class="form-label" for="typeRe-Password">Re Enter Password</label>
                  </div>

                  <div data-mdb-input-init class="form-outline mb-4">
                    <label class="form-label" for="profile_photo">Profile Photo</label>
                    <input type="file" class="form-control" id="profile_photo" name="profile_photo" />
                  </div>

                  <div class="text-center pt-1 mb-5 pb-1">
                    <input data-mdb-button-init data-mdb-ripple-init class="btn btn-primary btn-block fa-lg gradient-linear mb-3" type="submit" formenctype="multipart/form-data" formmethod="post" formaction="register" value="Register">
                    <!-- <a class="text-muted" href="login">Login</a> -->
                  </div>

                  <div class="d-flex align-items-center justify-content-center pb-4">
                    <p class="mb-0 me-2">Already have an account?</p>
                    <a type="button" href="login.jsp" data-mdb-button-init data-mdb-ripple-init class="btn btn-outline-danger">Login</a>
                  </div>
                </form>

              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<script src="js/InputField.js"></script>

<!--
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
-->

<!--
<script type="text/javascript" src="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/js/dist/mdb5/standard/core.min.js"></script>
-->

<!--
<script src="https://mdbcdn.b-cdn.net/wp-content/themes/mdbootstrap4/docs-app/js/dist/main.min.js"></script>
-->

</body>
</html>