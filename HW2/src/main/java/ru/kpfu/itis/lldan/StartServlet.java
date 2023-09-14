package ru.kpfu.itis.lldan;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.stream.Collectors;

@WebServlet(name = "startServlet", urlPatterns = "/")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        writeHeadersParamsBody(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        writeHeadersParamsBody(req, resp);
    }

    private void writeHeadersParamsBody(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        Enumeration<String> enm = req.getHeaderNames();
        while (enm.hasMoreElements()) {
            writer.println(enm.nextElement() + ": " + req.getHeader(enm.nextElement()));
        }
        writer.println("Params: " + req.getQueryString());
        String requestBody = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        writer.println("Body: " + requestBody);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        writeHeadersParamsBody(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        writeHeadersParamsBody(req, resp);
    }
}