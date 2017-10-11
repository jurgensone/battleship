package lv.ctco.battleship.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
public class Field implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, CellContent> content = new HashMap<>();

    public Map<String, CellContent> getContent() {
        return content;
    }

    public CellContent get(String addr) {
        return content.getOrDefault(addr, CellContent.EMPTY);
    }

    public void set(String addr, CellContent cc) {
        content.put(addr, cc);
    }
}
