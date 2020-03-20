import org.junit.Test;

public class SolverNoResultTest {
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        Solver solver = new Solver(0
                , -7, 12);
        double[] result = solver.solve();
    }
}
