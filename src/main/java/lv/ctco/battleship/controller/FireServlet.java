package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.Game;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by inna.yurgensone on 10/11/2017.
 */
@WebServlet(name = "FireServlet", urlPatterns = "/fire")
public class FireServlet extends HttpServlet {
    @Inject
    private PlayerManager playerManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String addr = request.getParameter("addr");
        Game game = playerManager.getGame();
        game.fire(addr);
        response.sendRedirect(request.getContextPath() + "/fire");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = playerManager.getGame();
        Player currentPlayer = game.getCurrentPlayer();
        Player sessionPlayer = playerManager.getPlayer();

        if (game.getPlayerWinner() != null) {
            response.sendRedirect(request.getContextPath() + "/eog");
        } else if (currentPlayer == sessionPlayer) {
            request.getRequestDispatcher("/WEB-INF/fire.jsp")
                    .include(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/wait_opponent-fire.jsp")
                    .include(request, response);
        }
    }


}
