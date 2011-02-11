<%@ page errorPage="../../ErrorPage.jsp" %>
<jsp:include page="../../AdminHeader.jsp" />

<jsp:useBean id="actes" scope="session" class="fr.paris.lutece.plugins.actes.web.ActesJspBean" />

<% actes.init( request , actes.RIGHT_MANAGE_ACTES ); %>
<%= actes.getCreateActe( request )%>

<%@include file="../../AdminFooter.jsp" %>
