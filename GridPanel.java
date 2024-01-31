import java.awt.Graphics;
import javax.swing.JPanel;

public class GridPanel extends JPanel {
    private int rows;
    private int cols;
    private int cellWidth;
    private int cellHeight;

    public GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }
    public int getCellHeight() {
        return cellHeight;
    }
    public int getCellWidth() {
        return cellWidth;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width=getWidth()-((getWidth()*6)/100);
        int height=getHeight()-((getHeight()*6)/100);
        cellWidth = width / cols;
        cellHeight = height / rows;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * cellWidth + (getWidth()*3)/100;
                int y = row * cellHeight + (getHeight()*3)/100;
                g.drawRect(x, y, cellWidth, cellHeight);
            }
        }
    }
}