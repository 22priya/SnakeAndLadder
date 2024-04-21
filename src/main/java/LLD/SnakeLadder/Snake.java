package LLD.SnakeLadder;

public class Snake extends Jump{

    public Snake(Integer startCell, Integer endCell) {
        super(startCell, endCell);
    }

    @Override
    public Boolean valid() {
        return getStartCell().getCellNumber()-getEndCell().getCellNumber()>0;
    }
}
