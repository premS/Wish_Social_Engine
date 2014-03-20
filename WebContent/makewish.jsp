<jsp:include page="template-top.jsp" />

<!-- Page Title
   ================================================== -->
   <div id="page-title">

      <div class="row">

         <div class="ten columns centered text-center">
            <h1>Make a wish<span>.</span></h1>

            <p>Make a wish here. </p>
         </div>

      </div>

   </div> <!-- Page Title End-->
<div class="content-outer">
	<div id="page-content" class="row page">
		<div id="primary" class="eight columns">
<div align='center'>
    <form method="post" action="makewish_start1.do" align='center'>
    <table align='center'>
		<tr>
			<td> What's your wish? </td>
			<td><input type="text" name="wishName" value="${form.wishName}"/></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<input type="submit" name="button" value="Make a Wish"/>
			</td>
		</tr>
	</table>
	</form>
</div>
</div>
</div>
</div>
<jsp:include page="template-bottom.jsp" />