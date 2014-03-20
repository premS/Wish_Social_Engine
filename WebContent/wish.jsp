<jsp:include page="template-top.jsp" />

<!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
           <h1>Make a wish<span>.</span></h1>

            <p>Genie will help you!. </p>         </div>

      </div>

   </div> <!-- Page Title End-->
<div class="content-outer">
	<div id="page-content" class="row page">





	 <form  method="get" action="http://localhost:8080/de.vogella.jersey.first/rest/hello">
  					   <fieldset>

                     <div class="cf" style="margin-left:35%">
							<label for="cName">What's your Wish?<span class="required"></span></label>
  						      <input name="tag" type="text" id="cName" size="35" value="" />
  						      <label for="cName">Wish Category <span class="required"></span></label>
  						      <select name="cat" class="lily"><option>Travel</option><option>Relationship</option><option>Career</option><option>Food</option><option>Fitness</option><option>Misc</option></select>
							   <button type="submit" class="submit">Submit</button>
                     </div>

                    
                    

  					   </fieldset>
  				      </form>
</div></div>

<jsp:include page="template-bottom.jsp" />