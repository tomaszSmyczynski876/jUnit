import org.junit.Test;

import static org.junit.Assert.*;

public class SolverTest {

    @Test
    public void solve() {
        Solver solver = new Solver(1, -7, 12);
        double[] result = solver.solve();
        assertEquals(2, result.length);
        assertEquals(3, result[0], 0.0001);
        assertEquals(4, result[1], 0.0001);
    }

}