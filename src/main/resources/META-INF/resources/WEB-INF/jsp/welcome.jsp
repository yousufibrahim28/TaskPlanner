<%@ include file="commons/header.jspf" %>
<body>
    <%@ include file="commons/navigation.jspf" %>
        <div class="container">
            <div>
                <h1>Welcome to my page</h1>
            </div>
            <hr>
            <div>
                Your name ${name}
            </div>
            <br>
            <a href="list-tasks">Manage Tasks</a>
        </div>
<%@ include file="commons/footer.jspf" %>