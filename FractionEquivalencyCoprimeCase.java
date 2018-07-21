import java.util.Scanner;
import static java.lang.System.out;

public class FractionEquivalencyCoprimeCase extends FractionAddCoprimeCase {
    
    private ReduceToLowestTerms fraction1, fraction2;
    protected int num1TimesDenom2;
    protected int num2TimesDenom1;
    protected int commonDenominator;

    public FractionEquivalencyCoprimeCase(int num1, int denom1, int num2, int denom2) { 
        super(num1, denom1, num2, denom2);
        fraction1 = new ReduceToLowestTerms(super.numerator1, super.denominator1);
        fraction2 = new ReduceToLowestTerms(super.numerator2, super.denominator2);
        numerator1 = fraction1.getReducedNumerator();
        denominator1 = fraction1.getReducedDenominator();
        numerator2 = fraction2.getReducedNumerator();
        denominator2 = fraction2.getReducedDenominator();
        num1TimesDenom2 = numerator1 * denominator2;
        num2TimesDenom1 = numerator2 * denominator1;
        commonDenominator = denominator1 * denominator2;
    }
    
    //Prompt the user to convert the operand fractions into equivalent ones with a common denominator
    public Problem execute() {
        Scanner readUser = new Scanner(System.in);
        
        //fraction1 is not in lowest terms
        if(!fraction1.isInLowestTerms()) {
           out.println(fraction1.originalFraction() + " is not in lowest terms!");
           Problem reduceProblem = fraction1;
           while(!(reduceProblem instanceof CorrectState)) {
                reduceProblem = reduceProblem.execute();
           }
        }

        //fraction2 is not in lowest terms
        if(!fraction2.isInLowestTerms()) {
           out.println(fraction2.originalFraction() + " is not in lowest terms!");
           Problem reduceProblem = fraction2;
           while(!(reduceProblem instanceof CorrectState)) {
                reduceProblem = reduceProblem.execute();
           }
        }
        
        out.println("Now we have the problem: " + fraction1() + "  +  " + fraction2() + "  =  ?");
        out.println("We need to find fractions equivalent to " + fraction1() + " and " + fraction2()
                + " which have common denominator " + denominator1 + " * " + denominator2);
        
        out.println("Start by converting " + fraction1() + " into an equivalent fraction with denominator " + denominator1 + " * " + denominator2);
        out.println("Enter the numerator of the equivalent fraction: ");
        if(readUser.nextInt() != num1TimesDenom2) {
            out.println("That is incorrect. By what number should the numerator of " + fraction1()
                    + " be multipled to get an equivalent fraction with denominator " + denominator1 + " * " + denominator2 + " ?");
            
            if(readUser.nextInt() != denominator2) {
                out.println("That is incorrect. What is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?");
                
                while(readUser.nextInt() != num1TimesDenom2) {
                    out.println("That is incorrect. Try again.");
                    out.println("What is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?");
                }
            }
            else {
                out.println("Correct. Now what is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?");
         
                while(readUser.nextInt() != num1TimesDenom2) {
                    out.println("That is incorrect. Try again.");
                    out.println("What is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?");
                }
            }
        }
        out.println("Correct. Enter the (common) denominator of the equivalent fraction: ");
        while(readUser.nextInt() != commonDenominator) {
            out.println("That is incorrect. The common denominator is " + denominator1 + " * " + denominator2 + ". Enter the product!: ");
        }
        out.println("Correct. You have converted " + fraction1() + " into the equivalent fraction " + fractionize(num1TimesDenom2, commonDenominator));
        
        out.println("Now convert " + fraction2() + " into an equivalent fraction with denominator " + denominator1 + " * " + denominator2);
        out.println("Enter the numerator of the equivalent fraction: ");
        if(readUser.nextInt() != num2TimesDenom1) {
            out.println("That is incorrect. By what number should the numerator of " + fraction2()
                    + " be multipled to get an equivalent fraction with denominator " + denominator1 + " * " + denominator2 + " ?");
            
            if(readUser.nextInt() != denominator1) {
                out.println("That is incorrect. What is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?");
                
                while(readUser.nextInt() != num2TimesDenom1) {
                    out.println("That is incorrect. Try again.");
                    out.println("What is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?");
                }
            }
            else {
                out.println("Correct. Now what is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?");
         
                while(readUser.nextInt() != num2TimesDenom1) {
                    out.println("That is incorrect. Try again.");
                    out.println("What is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?");
                }
            }
        }
        out.println("Correct. Enter the (common) denominator of the equivalent fraction: ");
        while(readUser.nextInt() != commonDenominator) {
            out.println("That is incorrect. The common denominator is " + denominator1 + " * " + denominator2 + ". Enter the product!: ");
        }
        out.println("Correct. You have converted " + fraction2() + " into the equivalent fraction " + fractionize(num2TimesDenom1, commonDenominator));

        return new FractionAddCommonDenominator(num1TimesDenom2, num2TimesDenom1, commonDenominator);
    
    } //end execute

    private String fractionize(int a, int b) {
        return a + "/" + b;
    }

} //end class
