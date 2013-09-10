<%@ tag body-content="empty" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ attribute name="resource" required="true" type="java.lang.String" %>
<%@ attribute name="remote" required="false" type="java.lang.Boolean"  %>

<c:choose>
    <c:when test="${remote}">
        <link rel="stylesheet" href="${resource}" type="text/css" media="all" />
    </c:when>
    <c:otherwise>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/style/${resource}" type="text/css" media="all" />
    </c:otherwise>
</c:choose>