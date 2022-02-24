package pendulum.calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnglesToXYTest {

    @Test
    void convertAnglesUpAndRight() {
        AnglesToXY converter = new AnglesToXY(1d, 1d);
        DoubleTuple xy = converter.convert(new DoubleTuple(Math.PI/2, 0));
        assertEquals(1d, xy.getFirst(), 0d);
        assertEquals(-1d, xy.getSecond(), 0d);
    }

    @Test
    void convertAngles_pendulumOnNegativeAxis() {
        AnglesToXY converter = new AnglesToXY(1d, 1d);
        DoubleTuple xy = converter.convert(new DoubleTuple(-Math.PI / 2, -Math.PI / 2));
        assertEquals(-2d, xy.getFirst(), 0d);
        assertEquals(0d, xy.getSecond(), 0.001d);
    }


    @Test
    void convertAngles_pendulumDown() {
        AnglesToXY converter = new AnglesToXY(1d, 1d);
        DoubleTuple xy = converter.convert(new DoubleTuple(0d, 0d));
        assertEquals(0d, xy.getFirst(), 0d);
        assertEquals(-2d, xy.getSecond(), 0d);
    }

}