<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form commandName="login" method="POST" action="login.html">
    <form:input path="username" />
    <form:password path="password" />
    <input type="submit" value="Anmelden!"/>
</form:form>