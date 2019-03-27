<html>
<body>
<?php
	session_start();
	echo session_id();
	$name = $_SESSION['fname'];
	$lname = $_SESSION['lname'];
	echo $name . $lname;
	echo "<a href = 'logout.php'</a>"
?>