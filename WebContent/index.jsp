<jsp:include page="template-top.jsp" />

   <!-- Intro Section
   ================================================== -->
   <section id="intro">

      <!-- Flexslider Start-->
	   <div id="intro-slider" class="flexslider">

		   <ul class="slides">

			   <!-- Slide -->
			   <li>
			   
			   <% if (request.getSession().getAttribute("accessToken") == null) { %>
			   	<table>
			   	<tr>
			   	<td style="width: 70%;">
			   		<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Make a Wish<span>.</span></h1>
							   <p>Unfulfilled Wishes?!..Make a wish here!</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/home-slider-image-01.png" alt="" />
                     </div></center>
					   </div>
				   </div>
			   	</td>
			   	<td style="text-align:center">
			   	
			   	<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Login with Twitter<span>.</span></h1>
						   </div>
                     <center><div class="slider-image">
                        <a href="authentication.do"><button class="btn btn-xlarge btn-twitter"><i class="fa fa-twitter"></i> | Login with Twitter</button></a>
                     <br/> <br/> <br/> <br/> <br/> <br/> <br/></div></center>
					   </div>
				   </div>
			   	</td>
			   	</tr>
			   	</table>
			   	
			   	<% } else { %>
						<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Make a Wish<span>.</span></h1>
							   <p>Unfulfilled Wishes?!..Make a wish here!</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/home-slider-image-01.png" alt="" />
                     </div></center>
					   </div>
				   </div>
					<%} %>
			   	
			   </li>

            <!-- Slide -->
<li>
<% if (request.getSession().getAttribute("accessToken") == null) { %>
<table>
			   	<tr>
			   	<td style="width: 70%;">
			   		<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Hottest Wish List<span>.</span></h1>
							   <p>See the hottest wish lists.</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/iwish.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
			   	</td>
			   	<td style="text-align:center">
			   	
			   	<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Login with Twitter<span>.</span></h1>
						   </div>
                     <center><div class="slider-image">
                        <a href="authentication.do"><button class="btn btn-xlarge btn-twitter"><i class="fa fa-twitter"></i> | Login with Twitter</button></a>
                     <br/> <br/> <br/> <br/> <br/> <br/> <br/></div></center>
					   </div>
				   </div>
			   	</td>
			   	</tr>
			   	</table>
			   	
			   	<% } else { %>
						<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Hottest Wish List<span>.</span></h1>
							   <p>See the hottest wish lists.</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/iwish.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
					<%} %>
			   	
				   
			   </li>			  
			  <li>
			  
			  <% if (request.getSession().getAttribute("accessToken") == null) { %>
			  <table>
			   	<tr>
			   	<td style="width: 70%;">
			   		 <div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Discuss your Wish<span>.</span></h1>
							   <p>See others with similar wishes and get Crowd sourced tips.</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/I-wish-copy1.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
			   	</td>
			   	<td style="text-align:center">
			   	
			   	<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Login with Twitter<span>.</span></h1>
						   </div>
                     <center><div class="slider-image">
                        <a href="authentication.do"><button class="btn btn-xlarge btn-twitter"><i class="fa fa-twitter"></i> | Login with Twitter</button></a>
                     <br/> <br/> <br/> <br/> <br/> <br/> <br/></div></center>
					   </div>
				   </div>
			   	</td>
			   	</tr>
			   	</table>
			   	<% } else { %>
						<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Discuss your Wish<span>.</span></h1>
							   <p>See others with similar wishes and get Crowd sourced tips.</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/I-wish-copy1.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
					<%} %>
			   	
			   	
				  
			   </li>
			   <li>
			   
			   <% if (request.getSession().getAttribute("accessToken") == null) { %>
			   <table>
			   	<tr>
			   	<td style="width: 70%;">
			   		<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Wish you had a friend<span>.</span></h1>
							   <p>Connect with friends! Birds of same feather flock together!</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/bg.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
			   	</td>
			   	<td style="text-align:center">
			   	
			   	<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Login with Twitter<span>.</span></h1>
						   </div>
                     <center><div class="slider-image">
                        <a href="authentication.do"><button class="btn btn-xlarge btn-twitter"><i class="fa fa-twitter"></i> | Login with Twitter</button></a>
                     <br/> <br/> <br/> <br/> <br/> <br/> <br/></div></center>
					   </div>
				   </div>
			   	</td>
			   	</tr>
			   	</table>
			   	
			   	<% } else { %>
						<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Wish you had a friend<span>.</span></h1>
							   <p>Connect with friends! Birds of same feather flock together!</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/bg.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
					<%} %>
			   	
				   
			   </li>
<li>

<% if (request.getSession().getAttribute("accessToken") == null) { %>
<table>
			   	<tr>
			   	<td style="width: 70%;">
			   		 <div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Wish-0-Meter<span>.</span></h1>
							   <p>Fulfilled Vs Unfulfilled</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/oh.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
			   	</td>
			   	<td style="text-align:center">
			   	
			   	<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Login with Twitter<span>.</span></h1>
						   </div>
                     <center><div class="slider-image">
                        <a href="authentication.do"><button class="btn btn-xlarge btn-twitter"><i class="fa fa-twitter"></i> | Login with Twitter</button></a>
                     <br/> <br/> <br/> <br/> <br/> <br/> <br/></div></center>
					   </div>
				   </div>
			   	</td>
			   	</tr>
			   	</table>
			   	<% } else { %>
						<div class="row">
					   <div class="twelve columns">
						   <div class="slider-text">
							   <h1>Wish-0-Meter<span>.</span></h1>
							   <p>Fulfilled Vs Unfulfilled</p>
						   </div>
                     <center><div class="slider-image">
                        <img src="images/sliders/oh.jpg" alt="" />
                     </div></center>
					   </div>
				   </div>
					<%} %>
			   	
			   	
				  
			   </li>
		   </ul>

	   </div> <!-- Flexslider End-->

   </section> <!-- Intro Section End-->

   <!-- Info Section
   ================================================== -->
    <!-- Info Section End-->

   <!-- Works Section
   ================================================== -->
    <!-- Works Section End-->

   <!-- Journal Section
   ================================================== -->
  
   <!-- Tweets Section
   ================================================== -->
    <!-- Tweet Section End-->
   <jsp:include page="template-bottom.jsp" />