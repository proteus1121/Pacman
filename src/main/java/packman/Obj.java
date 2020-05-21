/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;


import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
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

    default List<Pair<Integer, Integer>> lookForFreeSpace(Map map, List<Obj> mapObjects) {
        List<Obj> mapObjectsWithoutCurrentObj = mapObjects.stream().filter(obj -> !obj.equals(this)).collect(Collectors.toList());
        return Arrays.stream(Direction.values()).filter(way ->
        {
            Block nextBlock = map.getBlocks()[getY() + way.getPoint().getValue()][getX() + way.getPoint().getKey()];
            return !nextBlock.getStatus().isBusy(nextBlock, mapObjectsWithoutCurrentObj);
        }).map(Direction::getPoint).collect(Collectors.toList());
    }
}
