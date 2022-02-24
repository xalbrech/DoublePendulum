package pendulum.calculate;

/**
 * Provides pendulum configuration parameters to the calculation.
 */
public class PendulumConfiguration {

    public static final double DEFAULT_L1 = 1d;
    public static final double DEFAULT_L2 = 1d;
    public static final double DEFAULT_M1 = 1d;
    public static final double DEFAULT_M2 = 1d;
    public static final double DEFAULT_G = 9.81;

    private final double l1,
                         l2,
                         m1,
                         m2,
                         g;

    public PendulumConfiguration() {
        this.l1 = DEFAULT_L1;
        this.l2 = DEFAULT_L2;
        this.m1 = DEFAULT_M1;
        this.m2 = DEFAULT_M2;
        this.g = DEFAULT_G;
    }

    public PendulumConfiguration(double l1, double l2, double m1, double m2, double g) {
        this.l1 = l1;
        this.l2 = l2;
        this.m1 = m1;
        this.m2 = m2;
        this.g = g;
    }


    public double getL1() {
        return l1;
    }

    public double getL2() {
        return l2;
    }

    public double getM1() {
        return m1;
    }

    public double getM2() {
        return m2;
    }

    public double getG() {
        return g;
    }
}
