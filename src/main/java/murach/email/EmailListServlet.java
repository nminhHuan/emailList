package murach.email;
import murach.business.User;
import murach.data.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/emailList")
public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException{
        String url="/index.html";

        String action=request.getParameter("action");
        if(action==null){
            action="join";
        }
        if (action.equals("join")){
            url="/index.html";
        }
        else if(action.equals("add")){
            String firstName=request.getParameter("firstName");
            String lastName=request.getParameter("lastName");
            String email=request.getParameter("email");

            User user = new User(firstName,lastName,email);

            UserDB.insert(user);

            request.setAttribute("user",user);
            url="/thanks.jsp";
        }
        getServletContext().
                getRequestDispatcher(url).
                forward(request,response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException{
        doPost(request,response);
    }
}