<jsp:include page="template-top.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Authentication<span>.</span></h1>

            <p>Authentication with twitter. </p>
         </div>

      </div>

   </div> <!-- Page Title End-->

<div class="content-outer">
	<div id="page-content" class="row page">
		<div id="primary" class="eight columns">

<div align='center'>
    <form method="post" action="credential.do" align='center'>
    <table align='center'>
    	<tr>
    		<a href="<c:url value="${url}"/>"> click here to validate</a>
    	</tr>
	</table>
	</form>
</div>
</div>
</div>
</div>
<jsp:include page="template-bottom.jsp" />