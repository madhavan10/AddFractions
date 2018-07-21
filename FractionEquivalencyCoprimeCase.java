import static java.lang.System.*;

public class FractionEquivalencyCoprimeCase extends FractionAddCoprimeCase {
    
    protected int num1TimesDenom2;
    protected int num2TimesDenom1;
    protected int commonDenominator;

    public FractionEquivalencyCoprimeCase(int num1, int denom1, int num2, int denom2) {
        super(num1, denom1, num2, denom2);
        num1TimesDenom2 = numerator1 * denominator2;
        num2TImesDenon1 = numerator2 * denominator1;
        commonDenominator = denominator1 * denominator2;
    }
    
    //Prompt the user to convert the operand fractions into equivalent ones with a common denominator
    public Problem execute() {
        Scanner readUser = new Scanner(in);
        out.println("We need to find fractions equivalent to " + fraction1() + " and " + fraction2()
                + "which have common denominator " + denominator1 + " * " + denominator2);
        out.println("Start by converting " + fraction1() + " into an equivalent fraction with denominator "
                + denominator1 + " * " + denominator2);
        out.println("Enter the numerator of the equivalent fraction: ");
        int userNum1 = readUser.nextInt();
        out.println("Enter the (common) denominator of the equivalent fraction: ");
        int userDenom = readUser.nextInt();
        

    }

    private String fractionize(int a, int b) {
        return a + "/" + b;
    }
