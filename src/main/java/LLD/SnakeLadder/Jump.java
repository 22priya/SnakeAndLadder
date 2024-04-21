package LLD.SnakeLadder;

public abstract class Jump {
    private Cell startCell;
    private Cell endCell;

    public Jump(Integer startCell, Integer endCell) {
        this.startCell = new Cell(startCell);
        this.endCell = new Cell(endCell);
    }

    public Cell getStartCell() {
        return startCell;
    }

    public Cell getEndCell() {
        return endCell;
    }

    public abstract Boolean valid();
}
