package servelets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

@WebServlet("/")
public class ControllerServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ControllerServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String path = request.getRequestURI();
        logger.info("POST request to path: {}", path);

        if(path != null && path.equals("/web_2.0-v1/api/AreaCheck")) {
            getServletContext().getRequestDispatcher("/AreaCheck").forward(request, response);
            return;
        }
        response.sendError(HttpServletResponse.SC_FORBIDDEN, "Метод не разрешён");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getRequestURI();
        String contextPath = request.getContextPath();
        String relativePath = path.substring(contextPath.length());

        logger.info("GET request to: {}", path);

        switch (relativePath) {
            case "/error.jsp":
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                break;
            case "/result.jsp":
                getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
                break;
            case "":
            case "/":
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                break;
            default:
                if (relativePath.endsWith(".css") || relativePath.endsWith(".js")) {
                    serveStaticFileDirectly(request, response, relativePath);
                } else {
                    logger.warn("Path not found: {}", path);
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
                break;
        }
    }

    private void serveStaticFileDirectly(HttpServletRequest request, HttpServletResponse response, String filePath)
            throws IOException {

        String realPath = getServletContext().getRealPath(filePath);
        File file = new File(realPath);

        if (!file.exists() || !file.isFile()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        if (filePath.endsWith(".css")) {
            response.setContentType("text/css");
        } else if (filePath.endsWith(".js")) {
            response.setContentType("application/javascript");
        }

        try (InputStream in = new FileInputStream(file);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}