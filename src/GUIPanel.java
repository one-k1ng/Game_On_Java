import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JPanel {
    public void drawGrid(Graphics2D g){
        for (int i = 0; i < Configuration.tiles.length; i++) {
            int r = i / Configuration.size;
            int c = i % Configuration.size;

            int x = Configuration.margin + c * Configuration.tileSize;
            int y = Configuration.margin + r * Configuration.tileSize;

            if (Configuration.tiles[i] == 0){
                if (!Configuration.gameOver) {
                    g.setColor(Configuration.Foreground_Color);
                    drawCenteredString(g, "\u2713", x, y);
                }
            }
            else {
                g.setColor(getForeground());
                g.fillRoundRect(x, y, Configuration.tileSize, Configuration.tileSize, 25, 25);
                g.setColor(Color.BLACK);
                g.drawRoundRect(x, y, Configuration.tileSize, Configuration.tileSize, 25, 25);
                g.setColor(Color.WHITE);

                drawCenteredString(g, String.valueOf(Configuration.tiles[i]), x, y);
            }
        }
    }

    public void drawCenteredString(Graphics2D g, String s, int x, int y){
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s, x + (Configuration.tileSize - fm.stringWidth(s)) / 2,
                y + (asc + (Configuration.tileSize - (asc -desc)) / 2));

    }


    public void drawStartMessage(Graphics2D g){
        if (!Configuration.gameOver){
            g.setFont(getFont().deriveFont(Font.BOLD, 18));
            g.setColor(Configuration.Foreground_Color);
            String s = "Click to start new game";
            g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2,
                    getHeight() - Configuration.margin);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2D);
        drawStartMessage(g2D);
    }
}
