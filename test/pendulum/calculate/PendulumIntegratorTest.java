package pendulum.calculate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class PendulumIntegratorTest {

    @Mock
    DoubleTuple mockInitTheta, mockThetaDotDot;
    @Mock
    PendulumDifferentiator mockDifferential;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(mockDifferential.getNextDifferenceAtPoint(any(DoubleTuple.class), any(DoubleTuple.class))).thenReturn(mockThetaDotDot);
    }

    @Test
    public void nextPointInvokesDifferentiator() {
        PendulumIntegrator integrator = new PendulumIntegrator(mockInitTheta, 0.1, mockDifferential);
        DoubleTuple result = integrator.getNextAngles();
        assertNotNull(result);
    }
}