package pendulum.calculate;

/**
 * Integrates differentials of pendulum angles and provides a new position of the pendulum - a new pair of angles.
 */
public class PendulumIntegrator {

    private final double deltaT;
    private DoubleTuple theta, thetaDot;
    private final PendulumDifferentiator differentiator;
    private DoubleTuple thetaDotDot;

    /**
     * Takes initial values
     *
     * @param initTheta      initial value of pendulum angles
     * @param deltaT         time increment
     * @param differentiator @link PendulumDifferentiator instance to provide differentials of the pendulum angles.
     */
    public PendulumIntegrator(DoubleTuple initTheta, double deltaT, PendulumDifferentiator differentiator) {
        this.theta = initTheta;
        this.thetaDot = new DoubleTuple(0d, 0d);
        this.thetaDotDot = new DoubleTuple(0d, 0d);
        this.differentiator = differentiator;
        this.deltaT = deltaT;
    }

    /**
     * Calculate the next tuple of pendulum angles by integrating 1st and 2nd angle
     * derivations provided by the differentiator
     *
     * @return tuple of the derivation of both pendulum angles
     */
    public DoubleTuple getNextAngles() {

        DoubleTuple prevThetaDotDot = thetaDotDot;
        DoubleTuple prevThetaDot = thetaDot;

        thetaDotDot = differentiator.getNextDifferenceAtPoint(theta, thetaDot);
        thetaDot = new DoubleTuple(thetaDot.getFirst() + deltaT * (thetaDotDot.getFirst() + prevThetaDotDot.getFirst()) / 2,
                thetaDot.getSecond() + deltaT * (thetaDotDot.getSecond() + prevThetaDotDot.getSecond()) / 2); // integrate thetaDotDot over t
        theta = new DoubleTuple(theta.getFirst() + deltaT * (thetaDot.getFirst() + prevThetaDot.getFirst()) / 2,
                theta.getSecond() + deltaT * (thetaDot.getSecond() + prevThetaDot.getSecond()) / 2);   // integrate thetaDot over t

        return theta;
    }

}

