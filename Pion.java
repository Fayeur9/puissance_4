import java.awt.Color;

public class Pion {
    private int col;
    private int row;
    private Player player;
    private Color color;

    public Pion(int col, int row, Player player) {
        this.col=col;
        this.row=row;
        this.color=player.getColor_player();
        this.player=player;
    }
    @Override
    public String toString() {
        if(color.getGreen()==0){
            return "J";
        }else{
            return "R";
        }
    }
    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
