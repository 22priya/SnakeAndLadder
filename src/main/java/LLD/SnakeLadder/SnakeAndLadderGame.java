package LLD.SnakeLadder;

import java.util.*;
import java.util.stream.Collectors;

public class SnakeAndLadderGame {
    private Board board;
    private Integer dices;
    private LinkedList<Player> players;
    Boolean isGameFinished;

    public SnakeAndLadderGame(Board board, Integer dices, LinkedList<Player> players) {
        this.board = board;
        this.dices = dices;
        this.players = players;
        this.isGameFinished=false;
    }

    public Integer throwDice(){
        Random random=new Random();
        Integer total=0;
        int times=0;
        while(times<dices)
        {
            times++;
            total+=random.nextInt(1,7);
        }
        return total;
    }

    public void playerPlaysTurn(Player player ,Integer steps)
    {
        System.out.println("Player "+player.getName()+ " has got "+steps+" on throwing");
        Cell currCell=player.getCurrentPosition();
        Integer cellNumber;
        if(currCell!=null)
            cellNumber=currCell.getCellNumber();
        else {
            cellNumber = 0;
        }
        Optional<Cell> nextCell=board.getCells()
                .stream()
                .filter(x->x.getCellNumber().equals(Math.min(100,cellNumber+steps)))
                .findFirst();
        Optional<Jump> jump=board.getJumps()
                .stream()
                .filter(x->x.getStartCell().getCellNumber().equals(nextCell.get().getCellNumber()))
                .findFirst();
        if(jump.isPresent())
        {
            if(jump.get().getClass().equals(Snake.class))
                System.out.println("Oh no!! "+player.getName()+" got bit by snake");
            else
                System.out.println("Yippy !! "+player.getName()+" got a ladder to climb");
            player.setCurrentPosition(jump.get().getEndCell());
        }
        else
        {
            player.setCurrentPosition(nextCell.get());
        }
        System.out.println(player.getName()+" reached at "+player.getCurrentPosition().getCellNumber());
        if(isGameFinished(player))
            declareWinner(player);
    }

    private void declareWinner(Player player) {
        System.out.println("Player "+player.getName()+"--"+player.getColor()+" has won the game !!");
    }

    public Boolean isGameFinished(Player player) {
        if(player.getCurrentPosition().getCellNumber().equals(100))
        {
            isGameFinished=true;
            return true;
        }
        else
            return false;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }
}
