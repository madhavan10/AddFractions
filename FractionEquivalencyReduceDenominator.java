import static java.lang.System.out;
import java.util.Scanner;

public class FractionEquivalencyReduceDenominator extends FractionAddReduceDenominator {
    
    protected int reducedNum2; //numerator2 after division by factor

    public FractionEquivalencyReduceDenominator(int num1, int denom1, int num2, int factor) {
        numerator1 = num1;
        denominator1 = denom1;
        this.factor = factor;
        numerator2 = num2;
        denominator2 = denominator1 * factor;

        reducedNum2 = numerator2 / factor;
    }

    @Override
    public Problem execute() {
        Scanner readUser = new Scanner(System.in);

        out.println("We have the problem " + fraction1() + "  +  " + fraction2() + "  =  " + "?");
        out.println("Start by reducing " + fraction2() + " to an equivalent fraction with the same denominator as "
                   + fraction1() + ".");
        out.print("Enter the numerator of " + fraction2() + " after performing the reduction: ");
        
        if(readUser.nextInt() != reducedNum2) {
            out.println("That is incorrect.");
            out.print("By what number should we divide " + fraction2() 
                    + " above and below to get an equivalent fraction with denominator " + denominator1 + " ?: ");
            while(readUser.nextInt() != factor) {
                out.println("Incorrect. Try again.");
                out.print("By what number should we divide " + fraction2() 
                        + " above and below to get an equivalent fraction with denominator " + denominator1 + " ?: ");
            }
            out.print("Correct. Now divide " + numerator2 + " by " + factor + ". What do you get?: ");
            if(readUser.nextInt() != reducedNum2) {
                out.println("Incorrect. Try again.");
                out.println("Divide " + numerator2 + " by " + factor + ". What do you get?: ");
            }
        }
        return new FractionAddCommonDenominator(numerator1, reducedNum2, denominator1);

    }//end execute

}//end class
