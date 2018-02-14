/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import java.util.List;

/**
 *
 * @author Артем
 */
public interface Obj {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);
    GameObject getName();
    String getView();
    void generateNextStep(Map map, List<Obj> mapObjects);
}
