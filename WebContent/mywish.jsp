<jsp:include page="template-top.jsp" />
<script src="http://yui.yahooapis.com/3.14.1/build/yui/yui-min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<%@ page import="databeans.MyWishBean" %>
	<%@ page import="java.util.ArrayList;" %>
  	<%
  	ArrayList<MyWishBean> myWishes = (ArrayList<MyWishBean>) request.getAttribute("myWishes");
   	%>

 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
 
 
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
    	
    	var sucess = ${successWishNum};
    	var failed = ${failedWishNum};
    	var undone = ${undoneWishNum};
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['Succeeded',     sucess],
          ['Failed',      failed],
          ['Undone',  undone],
      
        ]);

        var options = {
          title: 'My Wishes Amount',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
   
  


<!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>My Wish<span>.</span></h1>

            <p>Check how is your wish going. </p>
         </div>

      </div>

   </div> <!-- Page Title End-->
<div class="content-outer">
	<div id="page-content" class="row page">
		<div id="primary" class="eight columns">
<div align='center'>

	
<div id="donutchart" style="width: 900px; height: 500px;"></div>
	
	

	 
	 <table class="table" style="align:middle;width:1000px">
	 	<tr>
        	
			<td><b>Wish Description</b></td>
			<td><b>State</b></td>
			<td><b>Start Date</b></td>
			<td><b>End Date</b></td>
			<td><b>Category</b></td>
			<td></td> 	
			<td></td>	
		</tr>
	 <c:forEach var="row" items="${myWishes}">
		<tr>
        	
			<td>${row.getWishdesc()}</td>
			<td>${row.getState()}</td>
			<td>${row.getStartdate()}</td>
			<td>${row.getEndDate()}</td>
			<td>${row.getCategory()}</td>
			<td><a href="fulfillWish.do?id=${row.mwid}"><button class="tablebutton">Achieved</button></a></td> 	
			<td><a href="dropWish.do?id=${row.mwid}"><button class="tablebutton">Later</button></a></td>	
		</tr>
	</c:forEach>
	</table>
</div>
</div>
</div>
</div>
<jsp:include page="template-bottom.jsp" />