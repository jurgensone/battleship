package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by inna.yurgensone on 10/17/2017.
 */
@WebFilter(filterName = "CancelFilter", urlPatterns = "/*")
public class CancelFilter implements Filter {

    @Inject
    private PlayerManager playerManager;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String cancel = request.getParameter("cancel");

        if("yes".equals(cancel)){
            Game game = playerManager.getGame();
            game.setCancelled(true);
            Player opponent = game.getOppositePlayer();
            game.setPlayerWinner(opponent);
            request.getRequestDispatcher("/WEB-INF/goodbye.jsp")
                    .include(request, resp);
            request.getSession().invalidate();
        } else {
           chain.doFilter(req, resp);
    }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
