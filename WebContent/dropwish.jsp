<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
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
            <h1>Later<span>.</span></h1>
            <p>Maybe next year... </p>
         </div>

      </div>

   </div> <!-- Page Title End-->

   <!-- Content
================================================== -->

<SCRIPT>

function KeepCount() {

var NewCount = 0;	

if (document.form.tag0.checked)
{NewCount = NewCount + 1
}

if (document.form.tag1.checked)
{NewCount = NewCount + 1}

if (document.form.tag2.checked)
{NewCount = NewCount + 1}

if (document.form.tag3.checked)
{NewCount = NewCount + 1}
if (document.form.tag0.checked)
{NewCount = NewCount + 1}

if (document.form.tag1.checked)
{NewCount = NewCount + 1}

if (document.form.tag2.checked)
{NewCount = NewCount + 1}

if (document.form.tag3.checked)
{NewCount = NewCount + 1}
if (document.form.tag0.checked)
{NewCount = NewCount + 1}

if (document.form.tag4.checked)
{NewCount = NewCount + 1}

if (document.form.tag5.checked)
{NewCount = NewCount + 1}

if (document.form.tag6.checked)
{NewCount = NewCount + 1}
if (document.form.tag7.checked)
{NewCount = NewCount + 1}

if (document.form.tag8.checked)
{NewCount = NewCount + 1}

if (document.form.tag9.checked)
{NewCount = NewCount + 1}


if (NewCount == 4)
{
alert('Pick Just Three Please');
document.joe; return false;
}
} 
</SCRIPT>

<script>
var selected = new Array();

$(document).ready(function() {

  $("input:checkbox[name=tag]:checked").each(function() {
       selected.push($(this).val());
       form.tag1 = $(this).val();
  });

});

</script>
<script language="javascript">
/**
 * checkbox������������
 * www.jbxue.com
*/
function test()
{
var value=""; //document.getElementsByName("value1").value;
for(i=0;i<4;i++)
{
if(document.getElementsByName("Status")[i].checked==true)
{
  if(value==""){
  value=value+document.getElementsByName("Status")[i].value;
  }
  else{
  value=value+","+document.getElementsByName("Status")[i].value;
}
}
}
 
document.all.value1.value = value;
}
</script>
  	<form name ="form" action="updateFailedWish.do?id=${wish.getMwid()}" method="POST" >
		<!-- <input type="hidden" name="redirect" value="${redirect}"/> -->
		<table style="font-size:medium;margin-left:35%; margin-top:1%;width:400px; align:left">
					
		
			<tr>
				<td colspan="4"><b>Wish Description: </b>${wish.getWishdesc()}  </td>
				
				
			</tr>
			
			<tr>
				<td colspan="4"><b>Finish Date</b> </td>
			</tr>
			<tr>
				<td colspan="4"><input type="text" name="finishdate" value="${form.finishdate}" class="inputtext"/></td>
			</tr>
			<tr>
				<td colspan="4"><b>Result description</b></td>
			</tr>
			<tr>
				<td colspan="4"><input type="text" name="resultdesc"value="${form.resultdesc}" class="inputtext" style="width:500px"/></td>
			</tr>
			<tr><td colspan="4"><b>Choose the top 3 factors contributes to your result</b></td> </tr>
			<%int i = 0; %>
			<c:forEach var="row" items="${tagName}">			
			<tr>				
				<td><input type="checkbox"  name ="Status" value="" onClick="test()"/>${row}</td>				
			</tr>
			<%i++; %>
			</c:forEach>
			
		<tr><td colspan="4" style="align:center"><a href="updateFailedWish.do?id=${wish.getMwid()}"><button class="tablebutton">Later</button></a></td></tr>
		</table>
		
		
	</form>
   
<!-- Footer End-->

  <jsp:include page="template-bottom.jsp" />