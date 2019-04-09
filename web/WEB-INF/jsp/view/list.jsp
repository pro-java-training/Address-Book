<%--@elvariable id="contacts" type="java.util.Set<com.codve.Contact>"--%>
<!doctype html>
<html lang="en">
<head>
    <title>Address Book</title>
</head>
<body>
    <h2>Address Book Contacts</h2>
    <c:choose>
        <c:when test="${fn:length(contacts) == 0}">
            <b>There are no contacts int the address book.</b>
        </c:when>
        <c:otherwise>
            <c:forEach items="${contacts}" var="contact">
                <b>
                    <c:out value="${contact.firstName} ${contact.lastName}" />
                </b>
                <br/>
                <c:out value="${contact.address}"/><br/>
                <c:out value="${contact.phoneNumber}" /><br/>
                <c:if test="${contact.birthday != null}">
                    Birthday: ${contact.birthday}<br/>
                </c:if>
                <br/><br/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>