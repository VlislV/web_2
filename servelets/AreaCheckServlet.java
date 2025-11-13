package servelets;

import beans.Point;
import beans.StriksBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "AreaCheckServlet", urlPatterns = {"/AreaCheck"})
public class AreaCheckServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AreaCheckServlet.class);

    Integer[] validX = {-3, -2, -1, 0, 1, 2, 3, 4, 5};

    private String validate(Integer x, Double y, Double r){
        if(!Arrays.asList(validX).contains(x)){
            return "Invalid X value";
        }
        if(y <= -5 || y >= 3){
            return "Y must be between -5 and 3";
        }
        if(r <= 2 || r >= 5){
            return "R must be between 2 and 5";
        }
        return "OK";
    }

    private String check(Integer x, Double y, Double r){
        if (y >= 0 && x <= 0 && 2 * y <= x + r)
            return "HIT in triangle";
        if (y <= 0 && x <= 0 && x > -r/2 && y > -r)
            return "HIT in rectangle";
        if (x >= 0 && y <= 0 && x * x + y * y <= (double) r / 2 * r / 2)
            return "HIT in circle";
        return "MISS";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            logger.info("AreaCheck doPOST");
            Integer x = Integer.parseInt(request.getParameter("x_value"));
            Double y = Double.parseDouble(request.getParameter("y_value"));
            Double r = Double.parseDouble(request.getParameter("r_value"));
            String validationResult = validate(x, y, r);
            if(validationResult.equals("OK")) {
                StriksBean striksBean = (StriksBean) request.getSession().getAttribute("striksBean");
                if (striksBean == null) {
                    striksBean = new StriksBean();
                    request.getSession().setAttribute("striksBean", striksBean);
                }
                String checkResult = check(x, y, r);
                striksBean.addPoint(new Point(x, y, r, checkResult));
                response.sendRedirect("result.jsp");
            } else {
                response.sendRedirect("error.jsp?message=" + validationResult);
            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp?message=" + e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("AreaCheck GET -> POST");
        doPost(request, response);
    }
}