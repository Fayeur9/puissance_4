import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

public class App extends JFrame {
    private static int rows=6;
    private static int cols=7;
    private static int nbr_tour=0;
    private static App app;

    private static Pion plateau_jeu[][]=new Pion[rows][cols];

    private static Player player1=null;
    private static Player player2=null;

    public void registerPuissance4(String num_player){
        JPanel panel = new JPanel ();
        JTextField namePlayer= new JTextField(20);
        JButton button = new JButton("Valider");

        panel.setLayout(new GridLayout(6, 2, 10, 10));
        panel.add(new JLabel("Player "+num_player));
        panel.add(namePlayer);
        panel.add(button);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(416,300));
        setVisible(true);
        add(panel);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                if(player1==null){
                    player1=new Player(namePlayer.getText(),Color.RED);
                    remove(panel);
                    app.registerPuissance4("2");
                }else{
                    player2=new Player(namePlayer.getText(),Color.YELLOW);
                    dispose();
                    app.startGame();
                }
            }
        });
    }

    public static void main(String[] args) {
        app=new App();
        app.test();
        // app.registerPuissance4("1");
    }
    private void test() {
        player1=new Player("1", Color.RED);
        player2=new Player("2", Color.YELLOW);
        for(int k=0;k<rows;k++){
            plateau_jeu[k][3]=new Pion(k,3, player1);
        }
        startGame();
    }
    private void startGame() {
        JFrame frame = new JFrame("Grille");
        GridPanel grille = new GridPanel(rows, cols);
        frame.add(grille);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(416,300));
        frame.setVisible(true);
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                int colonne=(e.getX()/(grille.getCellWidth()));
                System.out.println("colonne: "+colonne);
                boolean col_full=false;
                for(int k=rows-1;k>-1;k--){
                    if(plateau_jeu[k][colonne]==null){
                        System.out.println("espace vide à la ligne: "+k);
                        plateau_jeu[k][colonne]=new Pion(colonne, k, (nbr_tour%2==0)?player1:player2);
                        col_full=false;
                        nbr_tour++;
                        break;
                    }else{
                        col_full=true;
                    }
                }
                if(col_full){
                    System.out.println("colonne pleine");
                }
                for (int o = 0; o < rows ; o++) {
                    for (int p = 0; p < cols; p++) {
                        String pion=(plateau_jeu[o][p]==null)?" ":plateau_jeu[o][p].toString();
                        System.out.print("|"+pion);
                    }
                    System.out.println("|");
                }
            }
        });
    }
}
