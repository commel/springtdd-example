<%@ tag body-content="empty" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%@ attribute name="resource" required="true" type="java.lang.String" %>
<%@ attribute name="remote" required="false" type="java.lang.Boolean" %>

<c:choose>
    <c:when test="${remote}">
        <script src="${resource}"></script>    
    </c:when>
    <c:otherwise>
        <script src="${pageContext.request.contextPath}/resources/js/${resource}"></script>    
    </c:otherwise>
</c:choose>