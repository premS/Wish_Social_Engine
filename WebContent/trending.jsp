<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="databeans.wish_comment" %>

   <!-- Page Title
   ================================================== -->
   <jsp:include page="template-top.jsp" />
      <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Wish', 'Talked About'],
          <c:forEach var="row" items="${wc}">
          ['${row.wish}',${row.count}],
          </c:forEach>
            ['Others',    ${diff}]
        ]);

        var options = {
          title: 'Most Talked About Wish'
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));
        chart.draw(data, options);
      }
    </script>
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Trending<span>.</span></h1>
            <p>See Hottest Wishes!. </p>
         </div>

      </div>

   </div> <!-- Page Title End-->

   <!-- Content
   ================================================== -->
   <div class="content-outer">

    
<div id="page-content" class="row page">

<style>
 /* Default Facebook CSS */
            .fbbody
            {
                font-family: "lucida grande" ,tahoma,verdana,arial,sans-serif;
                font-size: 11px;
                color: #333333;
            }
            /* Default Anchor Style */
            .fbbody a
            {
                color: #3b5998;
                outline-style: none;
                text-decoration: none;
                font-size: 11px;
                font-weight: bold;
            }
            .fbbody a:hover
            {
                text-decoration: underline;
            }
            /* Facebook Box Styles */
            .fbgreybox
            {
                background-color: #f7f7f7;
                border: 1px solid #cccccc;
                color: #333333;
                padding: 10px;
                font-size: 13px;
                font-weight: bold;
            }
            .fbbluebox
            {
                background-color: #eceff6;
                border: 1px solid #d4dae8;
                color: #333333;
                padding: 10px;
                font-size: 13px;
                font-weight: bold;
            }
            .fbinfobox
            {
                background-color: #fff9d7;
                border: 1px solid #e2c822;
                color: #333333;
                padding: 10px;
                font-size: 13px;
                font-weight: bold;
            }
            .fberrorbox
            {
                background-color: #ffebe8;
                border: 1px solid #dd3c10;
                color: #333333;
                padding: 10px;
                font-size: 13px;
                font-weight: bold;
            }
            /* Content Divider on White Background */
            .fbcontentdivider
            {
                margin-top: 15px;
                margin-bottom: 15px;
                width: 520px;
                height: 1px;
                background-color: #d8dfea;
            }
            /* Facebook Tab Style */
            .fbtab
            {
                padding: 8px;
                background-color: #d8dfea;
                color: #3b5998;
                font-weight: bold;
                float: left;
                margin-right: 4px;
                text-decoration: none;
            }
            .fbtab:hover
            {
                background-color: #3b5998;
                color: #ffffff;
                cursor: hand;
            }
        

</style>
 <h1>Wish Trends.</h1>
  <c:forEach var="row" items="${wc}">
  <form id='${row.pid}' method='post' action='search_wish1.do'><input type=hidden name=img_id value="${row.pid}">
        <a href="#" onclick="document.getElementById('${row.pid}').submit();return false;" class="fbtab">${row.wish}</a></form>
        </c:forEach>


                                         
</div><center>
 

                 
 <div id="piechart" style="width: 900px; height: 500px;"></div>  
</center>
</div>
        

          <!-- Footer End-->

  <jsp:include page="template-bottom.jsp" />