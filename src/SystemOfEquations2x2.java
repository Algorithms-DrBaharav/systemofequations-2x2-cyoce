
/**
 * Solves a linear system of equations
 * 
 * @author YourNameHere
 */
public class SystemOfEquations2x2 {

    
    /**
     * Holds all coefficients and results
     */
    private double[][] bigA;
    
    /**
     * Constructor for a 2x2 system of equations
     * 
     * The coefficients and results of the equation
     * @param a (0,0) - coefficient
     * @param b (0,1)
     * @param c (1,0)
     * @param d (1,1)
     * @param e (0,2)  - result
     * @param f (1,2)  - result
     */
    public SystemOfEquations2x2(double a, double b, double c, double d, double e, double f){

        bigA = new double[2][3];
        bigA[0][0] = a;
        bigA[0][1] = b;
        bigA[0][2] = e;
        bigA[1][0] = c;
        bigA[1][1] = d;
        bigA[1][2] = f;
        
    }
    
    /**
     * @return the two variables solution. If none, return null.
     */
    public double[] Solve2x2(){
        
        double[][] bigB = new double[2][3];
        double scale = bigA[1][0] / bigA[0][0];
        for(int i = 0; i < 3; i++){
            bigB[0][i] = bigA[0][i] * scale;
        }
        bigB[1] = bigA[1].clone();
        double[] subtracted = bigA[1].clone();
        for(int i = 0; i < 3; i++){
            subtracted[i] -= bigB[0][i];
        }
        double[] solution = new double[2];
        solution[1] = subtracted[2] / subtracted[1];
        solution[0] = (bigA[0][2] - bigA[0][1] * solution[1]) / bigA[0][0];
        System.out.print(solution[0]);
        System.out.print(" ");
        System.out.println(solution[1]);
        if(Double.isNaN(solution[0]) || Double.isNaN(solution[1])) return null;
        return solution;
    }
    
}
