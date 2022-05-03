import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JFrame {
    public GUIWindow() {
        Game_Control newGame = new Game_Control();
        newGame.newGame();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Of Fifteen");
        setResizable(true);
        add(new GUIPanel(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setSize(650, 650);
        setVisible(true);
        setPreferredSize(new Dimension(Configuration.dimension, Configuration.dimension + Configuration.margin));
        setBackground(Color.WHITE);
        setForeground(Configuration.Foreground_Color);
        setFont(new Font("SansSerif", Font.BOLD, 60));
    }
}
