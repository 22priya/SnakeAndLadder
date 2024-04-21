package LLD.SnakeLadder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class SnakeLadderApplication {

	public static void main(String[] args) throws Exception {
		List<Jump> snakes=new ArrayList<>();
		snakes.add(new Snake(30,5));
		snakes.add(new Snake(82,15));
		snakes.add(new Snake(67,20));
		List<Jump> ladders=List.of(new Ladder(11,45),new Ladder(20,80),new Ladder(35,78),new Ladder(25,65));
		snakes.addAll(ladders);
		Board board=new Board(snakes);
		LinkedList<Player> players= new LinkedList();
		players.add(new Player("priya",Color.RED));
		players.add(new Player("riya",Color.GREEN));
		players.add(new Player("Saurabh",Color.YELLOW));
		SnakeAndLadderGame game=new SnakeAndLadderGame(board,4,players);
		while(!game.isGameFinished)
		{
			Player currPlayer=game.getPlayers().pollFirst();
			Integer steps=game.throwDice();
			game.playerPlaysTurn(currPlayer,steps);
			game.getPlayers().add(currPlayer);
		}
	}

}
