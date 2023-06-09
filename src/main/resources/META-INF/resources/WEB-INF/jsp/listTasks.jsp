
<%@ include file="commons/header.jspf" %>
    <body>
        <%@ include file="commons/navigation.jspf" %>
        <div class="container">
            <div>
                <h1> Welcome to Tasks page ${name} </h1>
            </div>
            <hr>
            <div>
                Your Tasks are
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target Date</th>
                        <th>is Done</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <thead>
                    <tbody>
                        <c:forEach items="${tasks}" var="task">
                            <tr>
                                <td>${task.description}</td>
                                <td>${task.targetDate}</td>
                                <td>${task.done}</td>
                                <td><a href="update-task?id=${task.id}" class ="btn btn-warning">UPDATE</a></td>
                                <td><a href="delete-task?id=${task.id}" class ="btn btn-danger">DELETE</a></td>

                            </tr>
                        </c:forEach>
                    </tbody>
            </table>
            <a href="add-task" class="btn btn-success">Add Task</a>
        </div>
<%@ include file="commons/footer.jspf" %>