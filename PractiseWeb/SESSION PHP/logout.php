<?php
if(isset($_SESSION['fname'],$_SESSION['lname'])){
	unset($_SESSION['fname'],$_SESSION['lname']);
	session_destroy();
}
?>