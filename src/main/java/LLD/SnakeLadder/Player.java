package LLD.SnakeLadder;

public class Player {
    private String name;
    private Color color;
    private Cell currentPosition;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Cell getCurrentPosition() {
        return currentPosition;
    }
    public void setCurrentPosition(Cell currentPosition) {
        this.currentPosition = currentPosition;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                '}';
    }
}
