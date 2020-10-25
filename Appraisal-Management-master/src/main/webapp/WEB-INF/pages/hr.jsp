<!DOCTYPE>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>HR Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style><%@include file="/WEB-INF/css/style.css"%></style>

</head>
  <body>
    
  <div class="header">
  <h1>APPRAISAL MANAGEMENT SYSTEM</h1>
  <p>A system to provide appraisal to employees.</p>
</div>
  
  
  
  <div class="topnav" id="myTopnav">
  <a href="/Appraisal-Management/hr" class="active">Home</a>
  <a href="hr/goals">Goal</a>
  <a href="hr/profile">Profile</a> 
  <a style="float:right;" href="logout">Logout</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <em class="fa fa-bars"></em>
  </a>
</div>
  <br>
  <h3>MANAGER DETAILS</h3>
  
  <br>
  <div style="margin:0px 400px">
   <form method="get" action="/Appraisal-Management/hr/searchManager">
  	<input type="text" name="keyword"/> &nbsp;
  	<input type="submit" value="Search"/>
  	
  </form>
  </div>
  <br><br><br>
<table class="user">
<caption></caption>
<tr>
<th id="">MANAGER ID</th>
<th id="">MANAGER NAME</th>
<th id="">MANAGER PHONE</th>
<th id="">MANAGER EMAIL</th>
<th id="">VIEW</th>

</tr>
<c:forEach var="m" items="${manager}">
<tr>
<c:if test="${m.id >0 }">
<td>${m.id }</td>
<td>${m.name }</td>
<td>${m.phone}</td>
<td>${m.email }</td>
<td><a href="/Appraisal-Management/hr/viewManager/${m.id}">VIEW</a></td>
</c:if>
</tr>
</c:forEach>
</table> 
  
  
  <br><br>
  <script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
<br><br><br>
<div class="footer">
  <h4>Copyright @2020.</h4>
</div>
  </body>
</html>
