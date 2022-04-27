import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {


    public void drawCenteredString(Graphics2D g, String s, int x, int y){
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s, x + (tileSize - fm.stringWidth(s)) / 2,
                y + (asc + (tileSize - (asc -desc)) / 2));

    }

    public void drawGrid(Graphics2D g){
        for (int i = 0; i < tiles.length; i++){

            int r = i / size;
            int c = i % size;

            int x = margin + c * tileSize;
            int y = margin + r * tileSize;

            if (tiles[i] == 0){
                if (gameOver){
                    g.setColor(Foreground_Color);
                    drawCenteredString(g, "\u2713", x, y);
                }

                continue;

            }

            g.setColor(getForeground());
            g.fillRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, tileSize, tileSize, 25, 25);
            g.setColor(Color.WHITE);

            drawCenteredString(g, String.valueOf(tiles[i]), x, y);
        }
    }

    public void drawStartMessage(Graphics2D g){
        if (gameOver){
            g.setFont(getFont().deriveFont(Font.BOLD, 18));
            g.setColor(Foreground_Color);
            String s = "Click to start new game";
            g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2,
                    getHeight() - margin);
        }
    }
}
