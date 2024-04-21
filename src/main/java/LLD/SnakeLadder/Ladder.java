package LLD.SnakeLadder;

public class Ladder extends Jump {
    public Ladder(Integer startCell, Integer endCell) {
        super(startCell, endCell);
    }

    @Override
    public Boolean valid() {
        return getEndCell().getCellNumber()-getStartCell().getCellNumber()>0;
    }
}
