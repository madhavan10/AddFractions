import static java.lang.System.out;
import java.util.Scanner;

public class FractionEquivalencyInflateDenominator extends FractionAddInflateDenominator {
    
    protected int inflatedNum1;

    public FractionEquivalencyInflateDenominator(int num1, int denom1, int num2, int factor) {
        numerator1 = num1;
        denominator1 = denom1;
        numerator2 = num2;
        this.factor = factor;
        denominator2 = denominator1 * factor;

        inflatedNum1 = num1 * factor;
    }

    @Override
    public Problem execute() {
        Scanner readUser = new Scanner(System.in);

        out.println("We have the problem " + fraction1() + "  +  " + fraction2() + "  =  " + "?");
        out.println("Start by converting " + fraction1() + " to an equivalent fraction with the same denominator as "
                   + fraction2() + ".");
        out.print("Enter the numerator of " + fraction1() + " after doing the conversion: ");
        
        if(readUser.nextInt() != inflatedNum1) {
            out.println("That is incorrect.");
            out.print("By what number should we multiply " + fraction1() 
                    + " above and below to get an equivalent fraction with denominator " + denominator2 + " ?: ");
            while(readUser.nextInt() != factor) {
                out.println("Incorrect. Try again.");
                out.print("By what number should we multiply " + fraction1() 
                        + " above and below to get an equivalent fraction with denominator " + denominator2 + " ?: ");
            }
            out.print("Correct. Now multiply " + numerator1 + " by " + factor + ". What do you get?: ");
            if(readUser.nextInt() != inflatedNum1) {
                out.println("Incorrect. Try again.");
                out.println("Multiply " + numerator1 + " by " + factor + ". What do you get?: ");
            }
        }
        return new FractionAddCommonDenominator(inflatedNum1, numerator2, denominator2);

    }//end execute

}//end class
