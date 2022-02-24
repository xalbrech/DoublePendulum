package pendulum.calculate;

import static java.lang.Math.*;

/**
 * Calculates the differential of pendulum angles.
 */
public class PendulumDifferentiator {

    private PendulumConfiguration configuration;

    public PendulumDifferentiator(PendulumConfiguration configuration) {
        this.configuration = configuration;
    }

    public DoubleTuple getNextDifferenceAtPoint(DoubleTuple theta, DoubleTuple thetaDot) {

        double m1 = configuration.getM1(), m2 = configuration.getM2(), l1 = configuration.getL1(), l2 = configuration.getL2(),
                g = configuration.getG();

        double theta1 = theta.getFirst();
        double theta2 = theta.getSecond();

        double z1 = thetaDot.getFirst();
        double z2 = thetaDot.getSecond();

        double c = cos(theta1 - theta2);
        double s = sin(theta1 - theta2);


        double z1dot = (m2 * g * sin(theta2) * c - m2 * s * (l1 * pow(z1, 2) * c + l2 * pow(z2, 2)) -
                (m1 + m2) * g * sin(theta1)) / l1 / (m1 + m2 * pow(s, 2));
        double z2dot = ((m1 + m2) * (l1 * pow(z1, 2) * s - g * sin(theta2) + g * sin(theta1) * c) +
                m2 * l2 * pow(z2, 2) * s * c) / l2 / (m1 + m2 * pow(s, 2));
        return new DoubleTuple(z1dot, z2dot);
    }
}
