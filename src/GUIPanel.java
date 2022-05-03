import javax.swing.*;
import java.awt.*;

public class GUIPanel extends JPanel {

    Configuration configuration;

    public void drawGrid(Graphics2D g){
        configuration = new Configuration();
        for (int i = 0; i < configuration.tiles.length; i++){

            int r = i / configuration.size;
            int c = i % configuration.size;

            int x = configuration.margin + c * configuration.tileSize;
            int y = configuration.margin + r * configuration.tileSize;

            g.setColor(getForeground());
            g.fillRoundRect(x, y, configuration.tileSize, configuration.tileSize, 25, 25);
            g.setColor(Color.BLACK);
            g.drawRoundRect(x, y, configuration.tileSize, configuration.tileSize, 25, 25);
            g.setColor(Color.WHITE);

            drawCenteredString(g, String.valueOf(configuration.tiles[i]), x, y);

            if (configuration.tiles[i] == 0){
                if (!configuration.gameOver){
                    g.setColor(Configuration.Foreground_Color);
                    drawCenteredString(g, "\u2713", x, y);
                }

            }
        }
    }

    public void drawCenteredString(Graphics2D g, String s, int x, int y){
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int desc = fm.getDescent();
        g.drawString(s, x + (configuration.tileSize - fm.stringWidth(s)) / 2,
                y + (asc + (configuration.tileSize - (asc -desc)) / 2));

    }


    public void drawStartMessage(Graphics2D g){
        if (!configuration.gameOver){
            g.setFont(getFont().deriveFont(Font.BOLD, 18));
            g.setColor(Configuration.Foreground_Color);
            String s = "Click to start new game";
            g.drawString(s, (getWidth() - g.getFontMetrics().stringWidth(s)) / 2,
                    getHeight() - configuration.margin);
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
