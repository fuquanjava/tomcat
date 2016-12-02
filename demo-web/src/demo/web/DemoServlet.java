package demo.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * fuquanemail@gmail.com 2016/10/27 17:13
 * description:
 */
public class DemoServlet extends HttpServlet {

    private AtomicInteger times = new AtomicInteger(0);

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("DemoServlet service ...");
        int i = 0;
        while (true) {
            i++;
            if (i == 100000) {
                break;
            }
        }
        int n = times.addAndGet(1);
        resp.getWriter().write("hello demo servlet, i=" + i + ", times=" + n);

    }
}
