  <jsp:include page="template-top.jsp" />
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="databeans.work_history" %>
   <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Wish', 'Success Percentage'],
          <c:forEach var="row" items="${wish}">
          ['${row.category}',${row.count}],
          </c:forEach>
        ]);

        var options = {
          title: ''
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
	 <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Success', 'Later'],
          <c:forEach var="row" items="${his}">
          ['${row.year}',${row.success},${row.failure}],
          </c:forEach>
         ]);

        var options = {
          title: '',
          hAxis: {title: 'Year', titleTextStyle: {color: 'red'}}
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    
   <!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Wish-0-Meter<span>.</span></h1>

            <p>Get to know your Success Percentage.Improve on your previous record!.</p>
         </div>

      </div>

   </div> <!-- Page Title End-->

   <!-- Content
   ================================================== -->
   <div class="content-outer">

      <div id="page-content" class="row portfolio">

         <section class="entry cf">

            <div id="secondary"  class="four columns entry-details">

                  <h1>Wish Success Rate.</h1>

                 
 <div id="piechart" style="width: 900px; height: 500px;"></div>
                 <h1>Wish List History.</h1>
				  <div id="chart_div" style="width: 900px; height: 500px;"></div>
            </div> <!-- secondary End-->
 <!-- primary end-->

         </section> <!-- end section -->


      </div>

   </div> <!-- content End-->

   <!-- Tweets Section
   ================================================== -->
<!-- Tweet Section End-->

  <jsp:include page="template-bottom.jsp" />