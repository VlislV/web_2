package servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/api/*")
public class ControllerServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ControllerServlet.class);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getPathInfo();
        if(path != null){
            if (path.equals("/AreaCheck")) {
                getServletContext().getRequestDispatcher("/AreaCheck").forward(request, response);
                return;
            }
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Метод не разрешён");
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Неверный запрос");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

