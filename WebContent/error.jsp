<jsp:include page="template-top.jsp" />

<!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Sorry, Error :(<span>.</span></h1>

            <p>Oops...Please try again.</p>
         </div>

      </div>

   </div> <!-- Page Title End-->

   <!-- Content
   ================================================== -->
   <div class="content-outer">

      <div id="page-content" class="row">

         <div id="primary" class="eight columns">

<jsp:include page="error-list.jsp" />

<p align="center">
    <a href="index.jsp" class='b'>Back to Home Page</a>
</p>

</div>
</div>
</div>

<jsp:include page="template-bottom.jsp" />
