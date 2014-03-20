<!DOCTYPE html>
<!--[if lt IE 8 ]><html class="no-js ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="no-js ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 8)|!(IE)]><!--><html class="no-js" lang="en"> <!--<![endif]-->
<head>

   <!--- Basic Page Needs
   ================================================== -->
   <meta charset="utf-8">
	<title>Sparrow - A Crowd sourced Wish Fulfilment Centre</title>
	<meta name="description" content="">
	<meta name="author" content="">

   <!-- Mobile Specific Metas
   ================================================== -->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

	<!-- CSS
    ================================================== -->
   <link rel="stylesheet" href="css/default.css">
   <link rel="stylesheet" href="css/social-buttons.css">
	<link rel="stylesheet" href="css/layout.css">
   <link rel="stylesheet" href="css/media-queries.css">

   <!-- Script
   ================================================== -->
	<script src="js/modernizr.js"></script>

   <!-- Favicons
	================================================== -->
	<link rel="shortcut icon" href="favicon.ico" > 
  
  <script type='text/javascript' src='js/jquery-1.9.1.js'></script>
  <script type='text/javascript'>//<![CDATA[ 

$(function () {
/*     var premTravel=${premTravel};
    var premRelation=${premRelation};
    var premMisc=${premMisc};
    var quincyTravel=${quincyTravel};
    var quincyRelation=${quincyRelation};
    var quincyMisc=${quincyMisc};
    var garyTravel=${garyTravel};
    var garyRelation=${garyRelation};
    var garyMisc=${garyMisc};
    var travelCount=${travelCount};
    var relationCount=${relationCount};
    var miscCount=${miscCount};
	 */
        $('#container').highcharts({
            chart: {
            },
            title: {
                text: 'Wish Group Interactions'
            },
            xAxis: {
                categories: ['Travel', 'Relationship', 'Misc']
            },
            tooltip: {
                formatter: function() {
                    var s;
                    if (this.point.name) { // the pie chart
                        s = ''+
                            this.point.name +': '+ this.y +' Comments';
                    } else {
                        s = ''+
                            this.x  +': '+ this.y;
                    }
                    return s;
                }
            },
            labels: {
                items: [{
                    html: 'Total Comments',
                    style: {
                        left: '40px',
                        top: '8px',
                        color: 'black'
                    }
                }]
            },
           

            
            series: [ {
                type: 'column',
                name: 'Quincy',
                data: [${quincyTravel}, ${quincyRelation}, ${quincyMisc}]
            
            }, {
                type: 'column',
                name: 'Gary',
                data: [${garyTravel}, ${garyRelation}, ${garyMisc}]
            }, 
            {
                type: 'column',
                name: 'Prem',
                data: [${premTravel},${premRelation}, ${premMisc}]
          
            },
            
            {
                type: 'pie',
                name: 'Total consumption',  
                
                data: [{
                    name: 'Travel;',
                    y: ${travelCount} ,
                    color: Highcharts.getOptions().colors[6] // Jane's color
                }, {
                    name: 'Relationship',
                    y: ${relationCount},
                    color: Highcharts.getOptions().colors[7] // John's color
                }, {
                    name: 'Misc',
                    y: ${miscCount},
                    color: Highcharts.getOptions().colors[8] // Joe's color
                }],
                center: [100, 80],
                size: 100,
                showInLegend: false,
                dataLabels: {
                    enabled: false
                }
            }]
        });
    });
    

//]]>  

</script>


</head>
<body>
  <header>

      <div class="row">

         <div class="twelve columns">

            <div class="logo">
               <a href="index.jsp"><img alt="" src="images/logo.png"></a>
			   
            </div>

            <nav id="nav-wrap">

               <a class="mobile-btn" href="#nav-wrap" title="Show navigation">Show navigation</a>
	            <a class="mobile-btn" href="#" title="Hide navigation">Hide navigation</a>

               <ul id="nav" class="nav">

	               <li class="current"><a href="index.jsp">Home</a></li>
	               <li><span><a href="#">Hot Wishes</a></span>
                     <ul>
                        <li><a href="trending.do">Trending</a></li>
                        <li><a href="search.do">Search</a></li>
                     </ul>
                  </li>
                  <li><span>
                  <% if (request.getSession().getAttribute("accessToken") == null) { %>
					<a href="authentication.do">Make a Wish</a>
					<% } else { %>
						<a href="wish.jsp">Make a Wish</a>
					<%} %>
                  
                  
                  </span>
                     <ul>
                        <li><% if (request.getSession().getAttribute("accessToken") == null) { %>
					<a href="authentication.do">Wish</a>
					<% } else { %>
						<a href="wish.jsp">Wish</a>
					<%} %></li>
                     </ul>
                  </li>
	              <li><a href="portfolio.jsp">Wish-0-Meter</a></li>
                  <li><a href="connect.do">Connect</a></li>
                  <li><a href="about.jsp">Contact Us</a></li>
                  <% if (request.getSession().getAttribute("accessToken") == null) { %>
					<li><a href="authentication.do">Login with Twitter</a></li>
					<% } else { %>
					<li><a href="mywish.do">My Wishes</a></li>
					<%} %>
               </ul> <!-- end #nav -->

            </nav> <!-- end #nav-wrap -->

         </div>

      </div>

   </header>
    <div id="page-title">
      <div class="row">

         <div class="ten columns centered text-center">
           <h1> Wish you had a friend.</h1><p>
Like someone with a similar Wish! Connect with them.Birds of same feather flock together!</p>
         </div>

      </div></div>
  <script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<p>
<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

  <center><iframe src="http://localhost/googledrag/groups.php" scrolling="no" width="1200" height="650" frameBorder="0"/></iframe></center>
  
<footer>

      <div class="row">

         <div class="twelve columns">

            <ul class="footer-nav">
					<li><a href="index.jsp">Home.</a></li>
              	<li><a href="trending.do">Hot Wishes.</a></li>
              	<li><% if (request.getSession().getAttribute("accessToken") == null) { %>
					<a href="authentication.do">Make a Wish.</a>
					<% } else { %>
						<a href="wish.jsp">Make a Wish.</a>
					<%} %></li>
              	<li><a href="portfolio.jsp">Wish-0-Meter.</a></li>
              	<li><a href="connect.jsp">Connect.</a></li>
               <li><a href="about.jsp">Contact Us.</a></li>
			   </ul>

            <ul class="footer-social">
               <li><a href="#"><i class="fa fa-facebook"></i></a></li>
               <li><a href="#"><i class="fa fa-twitter"></i></a></li>
               <li><a href="#"><i class="fa fa-google-plus"></i></a></li>
               <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
               <li><a href="#"><i class="fa fa-skype"></i></a></li>
               <li><a href="#"><i class="fa fa-rss"></i></a></li>
            </ul>

            <ul class="copyright">
               <li>Copyright &copy; 2014 Sparrow</li>
               <li>Design by <a title="Styleshout" href="http://www.styleshout.com/">Styleshout</a></li>
            </ul>

         </div>

         <div id="go-top" style="display: block;"><a title="Back to Top" href="#">Go To Top</a></div>

      </div>

   </footer> <!-- Footer End-->

   <!-- Java Script
   ================================================== -->

   <script type="text/javascript" src="js/jquery-migrate-1.2.1.min.js"></script>

   <script src="js/jquery.flexslider.js"></script>
   <script src="js/doubletaptogo.js"></script>
   <script src="js/init.js"></script>

</body>

</html>