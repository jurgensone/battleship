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
@WebServlet(name = "EndOfGameServlet", urlPatterns = "/eog")
public class EndOfGameServlet extends HttpServlet {
    @Inject
    private PlayerManager playerManager;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Game game = playerManager.getGame();
        Player currentPlayer = playerManager.getPlayer();

        if(game.getPlayerWinner() == currentPlayer){
            request.getRequestDispatcher("/WEB-INF/winner.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("/WEB-INF/looser.jsp").include(request, response);
        }
    }
}
