package pendulum.ui;

import pendulum.calculate.*;

import javax.swing.*;
import java.util.TimerTask;

/**
 * Main class of the program + main UI code.
 * <p>
 * The program plots a trace of the tip of a double pendulum.
 * It is a Java re-implementation of the python code taken from:
 * https://scipython.com/blog/the-double-pendulum/
 * , done simply as an exercise.
 * <p>
 * Parameters of the pendulum:
 * rod lengths = 1m
 * bob masses = 1kg
 * initial angles: 3/7 * PI, 3/4 * PI
 */
public class PendulumUI {

    protected PendulumGraph pendulumGraph = new PendulumGraph();
    private JFrame uiFrame;

    private void start() {
        uiFrame = new JFrame("Double pendulum");
        pendulumGraph.setSize(800, 800);
        uiFrame.setSize(800, 800);
        uiFrame.add(pendulumGraph);
        uiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        uiFrame.setVisible(true);
    }

    public static void main(String[] args) {

        PendulumConfiguration configuration = new PendulumConfiguration();
        PendulumDifferentiator differentiator = new PendulumDifferentiator(configuration);
        PendulumIntegrator integrator = new PendulumIntegrator(new DoubleTuple(3 * Math.PI / 7, 3 * Math.PI / 4),
                0.001,
                differentiator);

        AnglesToXY angleConverter = new AnglesToXY(configuration.getL1(), configuration.getL2());

        PendulumUI theUI = new PendulumUI();
        theUI.start();

        java.util.Timer timer = new java.util.Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                theUI.pendulumGraph.addPointToGraph(angleConverter.convert(integrator.getNextAngles()));
                theUI.uiFrame.repaint();
            }
        };
        timer.schedule(task, 1, 1);
    }

}
