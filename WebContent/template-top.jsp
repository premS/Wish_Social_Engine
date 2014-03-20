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

</head>

<body>

   <!-- Header
   ================================================== -->
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
	              <li><a href="portfolio.do">Wish-0-Meter</a></li>
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

   </header> <!-- Header End -->