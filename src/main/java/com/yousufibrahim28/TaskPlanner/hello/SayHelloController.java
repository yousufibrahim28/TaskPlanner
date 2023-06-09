package com.yousufibrahim28.TaskPlanner.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    /*
    * URL = "say-hello" => "Hello! what are you learning today?"
    *
    * */

    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return  "Hello! what are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody
    public String sayHelloHtml() {

        StringBuffer html = new StringBuffer();
        html.append("<html>");
        html.append("<head>");
        html.append("<title> My First HTML Page</title>");
        html.append("</head>");
        html.append("<body>");
        html.append("My First HTML Page");
        html.append("</body>");
        html.append("</html>");

        return  html.toString();
    }

    /*
    * URL = "say-hello-jsp" =>
    *
    * All jsp files should be resided in
    * /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
    * src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
    *
    *
    * */

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return  "sayHello";
    }

}
