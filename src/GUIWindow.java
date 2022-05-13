import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GUIWindow extends JFrame {
    public static Game_Control game;

    public GUIWindow() {
        game = new Game_Control();
        game.newGame();
        this.addMouseListener(new MouseBox());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Game Of Fifteen");
        setResizable(true);
        add(new GUIPanel(), BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setSize(1000, 700);
        setVisible(true);
        setPreferredSize(new Dimension(Configuration.dimension, Configuration.dimension + Configuration.margin));
        setBackground(Color.WHITE);
        setForeground(Configuration.Foreground_Color);
        setFont(new Font("SansSerif", Font.BOLD, 60));

    }
}