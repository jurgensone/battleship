package lv.ctco.battleship.controller;

import lv.ctco.battleship.model.CellContent;
import lv.ctco.battleship.model.Field;
import lv.ctco.battleship.model.Player;
import lv.ctco.battleship.model.PlayerManager;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
@WebServlet(name = "PlacementServlet", urlPatterns = "/placement")
public class PlacementServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(PlacementServlet.class.getName());
    @Inject
    private PlayerManager playerManager;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] addresses = request.getParameterValues("cell");
        logger.log(Level.FINER, () -> "Placement request received " + Arrays.toString(addresses));

        Player player = playerManager.getPlayer();
        Field field = player.getMyField();

        boolean error = true;
        if (addresses == null || addresses.length < 20) {
            request.setAttribute("errorNotEnough", true);
        } else if (addresses.length > 20) {
            request.setAttribute("errorTooMany", true);
        } else {
            error = false;
        }

        field.getContent().clear();
        if (addresses != null) {
            for (String addr : addresses) {
                field.set(addr, CellContent.SHIP);
            }
        }

        if (error) {
            request.getRequestDispatcher("/placement.jsp").include(request, response);
        } else {
            player.setPlacementComplete(true);
            response.sendRedirect(request.getContextPath() + "/wait-opponent-ships");
        }

    }

}
