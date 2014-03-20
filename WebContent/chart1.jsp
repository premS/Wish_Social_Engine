<jsp:include page="template-top.jsp" />
	<%@ page import="databeans.WishResultBean" %>
  	<%
    	WishResultBean wishResult = (WishResultBean) session.getAttribute("wishResult");
   	%>
 <!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Wish list<span>.</span></h1>

            <p>Discuss with others for similar wishes. </p>
         </div>

      </div>

   </div> <!-- Page Title End-->

<div class="content-outer">
	<div id="page-content" class="row page">
		<div id="primary" class="eight columns">
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChartA);
      google.setOnLoadCallback(drawChartB);
      google.setOnLoadCallback(drawChartC);
      function drawChartA() {
      	var s = ${wishResult.getS()};
      	var f = ${wishResult.getF()};
      	var u = ${wishResult.getU()};
      	var sp = s/(s+f+u)*100;
      	var fp = f/(s+f+u)*100;
      	var up = u/(s+f+u)*100;
        var data = google.visualization.arrayToDataTable([
          	['Sate', 'Percentage(%)', { role: 'style' }],
        	['Succeeded', sp, 'green'],            // RGB value
			['Failed', fp, 'blue'],            // English color name
			['Undone', up, 'yellow']
        ]);

        var options = {
          title: 'Success/Failed/Undone Statistics'
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('chart1'));
        chart.draw(data, options);
      }
      function drawChartB() {
      	var c1 = ${wishResult.getT1()};
      	var c2 = ${wishResult.getT2()};
      	var c3 = ${wishResult.getT3()};
      	var c4 = ${wishResult.getT4()};
      	var c5 = ${wishResult.getT5()};
      	var data = google.visualization.arrayToDataTable([
          ['Success Reason', 'Quantity'],
          ['<%=wishResult.getTS1()%>',c1],
          ['<%=wishResult.getTS2()%>',c2],
          ['<%=wishResult.getTS3()%>',c3],
          ['<%=wishResult.getTS4()%>',c4],
          ['<%=wishResult.getTS5()%>',c5]
        ]);

        var options = {
          title: 'Success Reasons Statistics'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart2'));
        chart.draw(data, options);
      }
      function drawChartC() {
      	var c1 = ${wishResult.getT6()};
      	var c2 = ${wishResult.getT7()};
      	var c3 = ${wishResult.getT8()};
      	var c4 = ${wishResult.getT9()};
      	var c5 = ${wishResult.getT10()};
      	var data = google.visualization.arrayToDataTable([
          ['Success Reason', 'Quantity'],
          ['<%=wishResult.getTS6()%>',c1],
          ['<%=wishResult.getTS7()%>',c2],
          ['<%=wishResult.getTS8()%>',c3],
          ['<%=wishResult.getTS9()%>',c4],
          ['<%=wishResult.getTS10()%>',c5]
        ]);

        var options = {
          title: 'Failure Reasons Statistics'
        };

        var chart = new google.visualization.PieChart(document.getElementById('chart3'));
        chart.draw(data, options);
      }
      
    </script>
    
    <center>
  
     <div id="chart1" style="width: 700px; height: 500px;" align='center'></div>
     <div id="chart2" style="width: 600px; height: 500px;" align='center'></div>
     <div id="chart3" style="width: 600px; height: 500px;" align='center'></div></center>
    </div>
    </div>
    </div>
 <jsp:include page="template-bottom.jsp" />