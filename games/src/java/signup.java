import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/** * Servlet implementation class LoginServlet */ 

@WebServlet(name="signup",urlPatterns={"/signup"})
public class signup extends HttpServlet 
{ public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException { 
    try{
        System.out.println("jsp called");
              
            User user=new User();
              
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String s= user.createuser(username, password);
            if(s.equalsIgnoreCase("User Created"))
            {
                  response.sendRedirect("profile.html");
            }
            else{
                System.out.print("error"); 
                response.sendRedirect("signup.html");
            }
    }
    catch(Exception e)
    {
        
    }
}
}
