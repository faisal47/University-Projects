<%-- 
    Document   : userRegister
    Created on : Mar 23, 2016, 6:06:10 PM
    Author     : Nur Uddin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <script src="<%=request.getContextPath()%>/resources/js/input-validation.js" ></script>
        <title>Delivery Information</title>
    </head>

    <body>
        <form class="form-horizontal" name="profile" onsubmit="return validateProfileForm()" action="<%=request.getContextPath()%>/delivery/info" method="post" role="form">
            <fieldset>
                
                <!-- Form Name -->
                <legend>Delivery Information</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Full Name: </label>  
                    <div class="col-md-4">
                        <input name="name" type="text" placeholder="enter the name" class="form-control input-md">
                        <input name="id" type="hidden" value="<%=request.getParameter("id")%>">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Phone No :</label>  
                    <div class="col-md-4">
                        <input name="phone_no" type="text" placeholder="enter your phone no." class="form-control input-md">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">District :</label>  
                    <div class="col-md-4">
                        <input name="district" type="text" placeholder="District name" class="form-control input-md">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Upazilla :</label>  
                    <div class="col-md-4">
                        <input name="upazilla" type="text" placeholder="Upazilla name" class="form-control input-md">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Road No. / Vill. :</label>  
                    <div class="col-md-4">
                        <input name="road_no/vill." type="text" placeholder="enter Road No. or Village name" class="form-control input-md">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">House NO. :</label>  
                    <div class="col-md-4">
                        <input name="house_no" type="text" placeholder="enter house no." class="form-control input-md">

                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton">Info</label>
                    <div class="col-md-5">
                        <button type="submit" name="singlebutton" class="btn btn-primary">submit</button>
                    </div>
                </div>

            </fieldset>
        </form>

    </body>
</html>

