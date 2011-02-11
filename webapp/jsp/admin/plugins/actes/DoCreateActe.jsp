<%@ page errorPage="../../ErrorPage.jsp" %>

<jsp:useBean id="actes" scope="session" class="fr.paris.lutece.plugins.actes.web.ActesJspBean" />

<% 
    actes.init( request, actes.RIGHT_MANAGE_ACTES ); 
    response.sendRedirect( actes.doCreateActe( request ) );
%>
