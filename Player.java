import java.awt.Color;
public class Player {
    private static int id_player = 1;
    public String name_player;
    public Color color_player;

    public Player(String name_player, Color color_player) {
        this.name_player = name_player;
        this.color_player = color_player;
    }

    public int getId_player() {
        return id_player;
    }
    public void setId_player(int id_player) {
        Player.id_player = id_player;
    }
    public String getName_player() {
        return name_player;
    }
    public void setName_player(String name_player) {
        this.name_player = name_player;
    }
    public Color getColor_player() {
        return color_player;
    }
    public String getColorName() {
        if(color_player.getGreen()==0){
            return "Yellow";
        }else{
            return "Red";
        }
    }
    public void setColor_player(Color color_player) {
        this.color_player = color_player;
    }
    @Override
    public String toString() {
        return getName_player()+" joue avec les "+getColorName();
    }

}
