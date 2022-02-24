package pendulum.ui;

import pendulum.calculate.DoubleTuple;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class PendulumGraph extends JPanel {

    private final BufferedImage bufferedImage = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);

    public PendulumGraph() {
        super();
        setBackground(Color.BLACK);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    public void addPointToGraph(DoubleTuple point) {

        int x = 400 + (int) (Math.round(point.getFirst() * 100));
        int y = 400 - (int) (Math.round(point.getSecond() * 100));

        bufferedImage.getGraphics().setColor(Color.WHITE);
        bufferedImage.getGraphics().drawLine(x, y, x, y);
    }

}
