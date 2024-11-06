<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List" %>
<%@ page import="com.spring.assignment.model.Policy" %>
<html>
	<body>
		<%
		List<Policy> policies = (List<Policy>) request.getAttribute("policies");
		%>
	    <h1>All Policies</h1>
	    <table border="1">
	        <thead>
	            <tr>
	                <th>Policy ID</th>
	                <th>Amount</th>
					<th>Active</th>
	            </tr>
	        </thead>
	        <tbody>
	            <%
				for(Policy p:policies){
				%>
				  <tr>
					
	                <td ><%=p.getId() %></td>
	                <td ><%=p.getAmount() %></td>
					<td ><%=p.isIs_active() %></td>
				  </tr>
				  
				  <%	
				  }%>
	        </tbody>
	    </table>
		
		<a href="/dashboard">BACK</a>
	</body>
</html>