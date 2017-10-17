package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by inna.yurgensone on 10/17/2017.
 */
@WebFilter(filterName = "RegistrationFilter", urlPatterns = "/*")
public class RegistrationFilter implements Filter {

    @Inject
    private PlayerManager playerManager;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        Player player = playerManager.getPlayer();
        Game game = playerManager.getGame();
        String path = request.getServletPath();

        if(player != null || path.equals("/index.jsp") || path.equals("/registration") ){
            if (game != null && game.isCancelled()){
                request.getRequestDispatcher("/WEB-INF/cancelled.jsp")
                        .include(request, response);
                request.getSession().invalidate();
            } else {
                chain.doFilter(req, resp);
            }
        } else {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
