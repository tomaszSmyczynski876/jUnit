import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SolverExceptionTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionRule(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("kwadratowe");
        Solver solver = new Solver(0, -7, 12);
        double[] result = solver.solve();
    }
}
