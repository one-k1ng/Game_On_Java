import javax.swing.*;
import java.awt.*;

public class Lauch extends JPanel{
    private Game_Control game_control = new Game_Control();
    public void Main (String[] arg) {
        Configuration configuration;
        configuration = new Configuration(4,550,30);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Game Of Fifteen");
        frame.setResizable(false);
        frame.add(new GUI());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setPreferredSize(new Dimension(configuration.dimension, configuration.dimension + configuration.dimension));
        setBackground(Color.WHITE);
        setForeground(configuration.Foreground_Color);
        setFont(new Font("SansSerif", Font.BOLD, 60));
        }
    }
