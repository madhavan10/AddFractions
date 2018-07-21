import java.util.Scanner;
import static java.lang.System.out;

public class FractionAddCommonDenominator implements Problem {

    protected int numerator1, numerator2, denominator;
    protected int numerator;

    public FractionAddCommonDenominator(int num1, int num2, int denom) {
        numerator1 = num1;
        numerator2 = num2;
        denominator = denom;
        numerator = numerator1 + numerator2;
    }

    public Problem execute() {
        Scanner readUser = new Scanner(System.in);
        out.println("Find the resulting fraction: " + fractionize(numerator1, denominator) + "  +  " + fractionize(numerator2, denominator));
        out.println("First enter the numerator: ");
        if(readUser.nextInt() != numerator) {
            out.println("That is incorrect. The above fraction is equivalent to: (" + numerator1 + " + " + numerator2 + ")/" + denominator);
            out.println("Now what is the numerator?: ");
            while(readUser.nextInt() != numerator) {
                out.println("That is incorrect. Try again. What is the numerator?: ");
            }
        }
        out.println("Correct. Enter the denominator: ");
        while(readUser.nextInt() != denominator) {
            out.println("Wrong. Enter the denominator: ");
        }

        out.println("Correct. " + fractionize(numerator1, denominator) + "  +  " + fractionize(numerator2, denominator) + "  =  " + fractionize(numerator, denominator));
        
        ReduceToLowestTerms reduceAnswer = new ReduceToLowestTerms(numerator, denominator);
        if(reduceAnswer.equals(reduceAnswer.originalFraction())) {
            return new CorrectState();
        }
        else {
            return reduceAnswer;
        }
    }

    private String fractionize(int a, int b) {
        return a + "/" + b;
    }
}
