import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JPanel{
    Configuration configuration;

    public GUIWindow() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Game Of Fifteen");
        frame.setResizable(true);
        frame.add(new GUIPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        setPreferredSize(new Dimension(configuration.dimension, configuration.dimension + configuration.margin));
        setBackground(Color.WHITE);
        setForeground(Configuration.Foreground_Color);
        setFont(new Font("SansSerif", Font.BOLD, 60));
        }
    }
