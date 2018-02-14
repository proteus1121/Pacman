package packman;

import java.util.List;
import java.util.Optional;

public enum BlockInfo
{
  EMPTY,
  POINT,
  WALL;

  public boolean isEmpty(BlockInfo block){
    return block == EMPTY;
  }
  public boolean isPoint(BlockInfo block){
    return block == POINT;
  }
  public boolean isWall(BlockInfo block){
    return block == WALL;
  }
  public boolean isBusy(Block block, List<Obj> mapObjects){
    Optional<Obj> objOnBlock = mapObjects.stream().filter(obj -> obj.getX() == block.getX() && obj.getY() == block.getY()).findFirst();
    return isWall(block.getStatus()) || objOnBlock.isPresent();
  }
}
