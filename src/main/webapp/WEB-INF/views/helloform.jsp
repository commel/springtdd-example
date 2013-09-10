<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <form:form commandName="hello" method="POST" action="helloform.html">
            <form:input path="name" />
            <input type="submit" value="Sag Hallo!"/>
        </form:form>
