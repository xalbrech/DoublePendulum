package pendulum.calculate;

/**
 * 2-tuple of doubles. Used to pass around pendulum angles or X-Y coordinates.
 */
public class DoubleTuple {

    final private double first, second;

    public DoubleTuple(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" +
                first +
                ", " + second +
                ')';
    }
}
