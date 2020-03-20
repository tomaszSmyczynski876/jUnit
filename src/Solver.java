import java.util.ArrayList;

public class Solver {
    private double a;
    private double b;
    private double c;

    public Solver(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double[] solve(){
        ArrayList<Double> results = new ArrayList();

        double delta = delta(a, b, c);

        if(delta > 0){
            results.add((-b - Math.sqrt(delta)) / (2 * a));
            results.add((-b + Math.sqrt(delta)) / (2 * a));
        } else if (delta == 0) {
            results.add(-b / (2 * a));
        }

        return results.stream().mapToDouble(i -> i).toArray();
    }

    private double delta(double a, double b, double c){
        return b*b - 4 * a * c;
    }
}
