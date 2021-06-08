import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JFrame {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(150, 150, 100, 100);
    }

}
