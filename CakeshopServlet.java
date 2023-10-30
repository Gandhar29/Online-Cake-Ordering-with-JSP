import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/CakeshopServlet")
public class CakeshopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String item = request.getParameter("flavour");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        
         //Process the order (e.g., store in a database)
        
        try {
        	Class.forName("com.mysql.jdbc.Driver");
           
            Connection conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/canteen","root","root");

           
            String sql = "INSERT INTO menu"  + "(flavour , Quantity) VALUES (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);

            
            statement.setString(1, "flavour");
            statement.setInt(2, quantity);
            
            
            statement.executeUpdate();

           
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
          
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        response.sendRedirect("orderConfirmation.jsp");
    }

}
