package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
@WebServlet(name = "WaitOpponentPlacementServlet", urlPatterns = "/wait-opponent-ships")
public class WaitOpponentPlacementServlet extends HttpServlet {

    @Inject
    private PlayerManager playerManager;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = playerManager.getGame();
        if (game.isStarted()) {
            response.sendRedirect(request.getContextPath() + "/fire");
        } else {
            request.getRequestDispatcher("/WEB-INF/wait-opponent-ships.jsp").include(request, response);
        }
    }
}
