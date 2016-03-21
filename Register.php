<?php
    $con=mysqli_connect("localhost","my_user","my_password","my_db");
    
    $name = $_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "INSERT INTO User (email,username, password) VALUES (?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "siss", $email, $username, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_close($statement);
    
    mysqli_close($con);
?>
