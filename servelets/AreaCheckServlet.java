package servelets;

import Utils.Checker;
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

@WebServlet(name = "AreaCheckServlet", urlPatterns = {"/AreaCheck"})
public class AreaCheckServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AreaCheckServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            logger.info("AreaCheck doPOST");
            Checker checker = new Checker(request.getParameter("x_value"),
                    request.getParameter("y_value"),request.getParameter("r_value"));
            String validationResult = checker.validate();
            if(validationResult.equals("OK")) {
                StriksBean striksBean = (StriksBean) request.getSession().getAttribute("striksBean");
                if (striksBean == null) {
                    striksBean = new StriksBean();
                    request.getSession().setAttribute("striksBean", striksBean);
                }
                String checkResult = checker.check();
                striksBean.addPoint(new Point(checker.getX(), checker.getY(), checker.getR(), checkResult));
                logger.info("POST request to result.jsp");
                response.sendRedirect("result.jsp");
            } else {
                logger.info("POST request to err.jsp");
                response.sendRedirect("error.jsp?message=" + validationResult);
            }

        } catch (Exception e) {
            logger.info("execption" + e.getMessage());
            response.sendRedirect("error.jsp?message=" + e.getMessage());
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("AreaCheck GET -> POST");
        doPost(request, response);
    }
}