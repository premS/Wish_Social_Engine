
<jsp:include page="template-top.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="databeans.WishResultBean" %>
<%
    	WishResultBean wishResult = (WishResultBean) session.getAttribute("wishResult");
   	%>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart1);
      google.setOnLoadCallback(drawChart2);
      google.setOnLoadCallback(drawChart3);
      function drawChart1() {
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
            title: 'Wish State Stats ('+'${wcat}'+')'
          };
		if(s==0 & f==0 & u==0){
		}else {
			var chart = new google.visualization.ColumnChart(document.getElementById('chart1'));
	        chart.draw(data, options);
		}
      }
      function drawChart2() {
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

          if(c1==0 & c2==0 & c3==0 & c4==0 & c5==0) {
          } else {
        	  var chart = new google.visualization.PieChart(document.getElementById('chart2'));
              chart.draw(data, options);
          }
        }
      function drawChart3() {
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

          if(c1==0 & c2==0 & c3==0 & c4==0 & c5==0) {
          } else {
        	  var chart = new google.visualization.PieChart(document.getElementById('chart3'));
              chart.draw(data, options);
          }
          
        }
    </script>
   <!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
           <h1>Your wish<span>.</span></h1>

            <p>It's your wish. </p>     </div>

      </div>

   </div> <!-- Page Title End-->

   <!-- Content
   ================================================== -->
   <div class="content-outer">

      <div id="page-content" class="row">

         <div id="primary" class="eight columns">

            <article class="post">

               <div class="entry-header cf">

                  <h1>${wishd}.</h1>

                  <p class="post-meta">

                     <time class="date" datetime="2014-01-14T11:24">Jan 14, 2014</time>
                     /
                     <span class="categories">
                     <a href="#">Category</a> /
                     <a href="#">${wcat}</a>
                     </span>

                  </p>

               </div>

               <div class="post-thumb">
                  <img src=${url} alt="post-image" title="post-image">
               </div>

             

            </article> <!-- post end -->

            <!-- Comments
            ================================================== -->
            <div id="comments">

               <h3>${csize} Comments</h3>

               <!-- commentlist -->
               <ol class="commentlist">
                   <c:forEach var="row" items="${cb}">
                  <li class="depth-1">
                     <div class="avatar">
                        <img width="50" height="50" class="avatar" src="images/user-01.png" alt="">
                     </div>
                     <div class="comment-info">
                        <cite>${row.userName}</cite>
 <div class="comment-meta">
                           <time class="comment-time" datetime="2014-01-14T23:05">${row.date}</time>
                           <span class="sep">/</span><a class="reply" href="#">Reply</a>
                        </div>
                     </div>
<div class="comment-text">
                        <p>${row.comment}</p>
                     </div>

                  </li>
</c:forEach>
                 
               </ol> <!-- Commentlist End -->


               <!-- respond -->
               <div class="respond">

                  <h3>Leave a Comment</h3>

                  <!-- form -->
                  <form method="post" align="center" action="discuss.do">
  					  
  						      <input name="status" type="text" id="status"  />
  						<input type="hidden" name="img_id" value=${img_id}>   
							   <button type="submit" >Submit</button>
                     

                    
                    

  					  </form> <!-- Form End -->

               </div> <!-- Respond End -->

            </div>  <!-- Comments End -->

         </div>

         <div id="secondary" class="four columns end">

            <aside id="sidebar">

               <div class="widget widget_search">
                  <h5>Like the Wish?Fund it!</h5>
          <!-- PayPal Logo --><table border="0" cellpadding="10" cellspacing="0" align="center"><tr><td align="center"></td></tr><tr><td align="center"><a href="https://www.paypal.com/webapps/mpp/paypal-popup" title="How PayPal Works" onclick="javascript:window.open('https://www.paypal.com/webapps/mpp/paypal-popup','WIPaypal','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, width=1060, height=700'); return false;"><img src="https://www.paypalobjects.com/webstatic/mktg/logo/AM_mc_vs_dc_ae.jpg" border="0" alt="PayPal Acceptance Mark"></a></td></tr></table><!-- PayPal Logo -->
                  </form>
               </div>

          	<div class="widget widget_search" id="chart1"></div>
          	<div class="widget widget_search" id="chart2"></div>
          	<div class="widget widget_search" id="chart3"></div>

            </aside>

         </div> <!-- Comments End -->

      </div>

   </div> <!-- Content End-->

   <!-- Tweets Section
   ================================================== -->
   <jsp:include page="template-bottom.jsp" />