package pendulum.calculate;

/**
 * Converts angles to X-Y coords, given the lengths of pendulum rods.
 */
public class AnglesToXY {

    private final double l1, l2;

    /**
     * @param l1 length of the 1st pendulum rod
     * @param l2 length of the 2nd rod
     */
    public AnglesToXY(double l1, double l2) {
        this.l1 = l1;
        this.l2 = l2;
    }

    /**
     * Conver a tuple of pendulum angles to XY coordinates of the 2nd pendulum bob.
     * @param theta tuple of pendulum angles.
     * @return tuple containing the coordinates of the 2nd bob.
     */
    public DoubleTuple convert(DoubleTuple theta) {
        double x1 = this.l1 * Math.sin(theta.getFirst());
        double y1 = -this.l1 * Math.cos(theta.getFirst());
        double x2 = x1 + this.l2 * Math.sin(theta.getSecond());
        double y2 = y1 - this.l2 * Math.cos(theta.getSecond());

        return new DoubleTuple(x2, y2);
    }
}
