<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


   <!-- Page Title
   ================================================== -->
   <jsp:include page="template-top.jsp" />
   <script src="http://yui.yahooapis.com/3.14.1/build/yui/yui-min.js"></script>
   
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Search Wish Topics<span>.</span></h1>
            <p>Get Helped & Help others attain their Wish. </p>
         </div>

      </div>

   </div> <!-- Page Title End-->

   <!-- Content
   ================================================== -->
   <div class="content-outer">

    
<div id="page-content" class="row page" style="margin-left:35%">

             
<form method="post" action="search_wish.do" >
  <fieldset>

                     <div class="cf">
			      <label for="cName">Search for a Wish:<span class="required">*</span></label> 
			      <div id="demo" class="yui3-skin-sam"><input type="text" id="url" name="url" class="inputtext"/></div>
				<script>
YUI().use('autocomplete', 'autocomplete-filters', 'autocomplete-highlighters', function (Y) {
  var states = [
<%=request.getAttribute("wish_name")%>
  ];

  Y.one('#url').plug(Y.Plugin.AutoComplete, {
    resultFilters    : 'phraseMatch',
    resultHighlighter: 'phraseMatch',
    source           : states
  });
});
</script>
					<input type="submit" name="button" value=" Search  " class="button"/>
		</div>
		</fieldset>
	</form>

                           
</div></div>
        

          <!-- Footer End-->

  <jsp:include page="template-bottom.jsp" />