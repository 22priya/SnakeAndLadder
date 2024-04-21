package LLD.SnakeLadder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private List<Cell> cells;
    private List<Jump> jumps;
    public Board(List<Jump> jumps) throws Exception {
        int invalidJumps=jumps.stream().filter(x->!x.valid()).collect(Collectors.toList()).size();
        if(invalidJumps>0)
            throw new Exception("Some invalid snake or ladder is provided");
        this.jumps = jumps;
        this.cells=new ArrayList<>();
        this.initalise();
    }

    private void initalise(){
        for(int i=1;i<=100;i++)
        {
            cells.add(new Cell(i));
        }
    }

    public List<Cell> getCells() {
        return cells;
    }

    public List<Jump> getJumps() {
        return jumps;
    }
}
