<?php
if(isset($_POST['submit']))
{
	session_start();
	echo session_id();
	$_SESSION = $_POST['fname'];
	$_SESSION = $_POST['lname'];
	header('location : profile.php');
}
?>