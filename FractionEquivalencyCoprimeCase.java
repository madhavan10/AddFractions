import java.util.Scanner;
import static java.lang.System.out;

public class FractionEquivalencyCoprimeCase extends FractionAddCoprimeCase {
    
    protected int num1TimesDenom2;
    protected int num2TimesDenom1;
    protected int commonDenominator;

    public FractionEquivalencyCoprimeCase(int num1, int denom1, int num2, int denom2) { 
        super(num1, denom1, num2, denom2);
        num1TimesDenom2 = numerator1 * denominator2;
        num2TimesDenom1 = numerator2 * denominator1;
        commonDenominator = denominator1 * denominator2;
    }
    
    //Prompt the user to convert the operand fractions into equivalent ones with a common denominator
    public Problem execute() {
        Scanner readUser = new Scanner(System.in);
        
        out.println("We have the problem: " + fraction1() + "  +  " + fraction2() + "  =  ?");
        out.println("We need to find fractions equivalent to " + fraction1() + " and " + fraction2()
                + " which have common denominator " + denominator1 + " * " + denominator2);
        
        out.println("Start by converting " + fraction1() + " into an equivalent fraction with denominator " + denominator1 + " * " + denominator2);
        out.print("Enter the numerator of the equivalent fraction: ");
        if(readUser.nextInt() != num1TimesDenom2) {
            out.print("That is incorrect. By what number should the numerator of " + fraction1()
                    + " be multipled to get an equivalent fraction with denominator " + denominator1 + " * " + denominator2 + " ?: ");
            
            if(readUser.nextInt() != denominator2) {
                out.print("That is incorrect. What is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?: ");
                
                while(readUser.nextInt() != num1TimesDenom2) {
                    out.println("That is incorrect. Try again.");
                    out.print("What is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?: ");
                }
            }
            else {
                out.print("Correct. Now what is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?: ");
         
                while(readUser.nextInt() != num1TimesDenom2) {
                    out.println("That is incorrect. Try again.");
                    out.print("What is the numerator obtained when you multiply " + fraction1() + " above and below by " + denominator2 + " ?: ");
                }
            }
        }
        out.print("Correct. Enter the (common) denominator of the equivalent fraction: ");
        while(readUser.nextInt() != commonDenominator) {
            out.print("That is incorrect. The common denominator is " + denominator1 + " * " + denominator2 + ". Enter the product!: ");
        }
        out.println("Correct. You have converted " + fraction1() + " into the equivalent fraction " + fractionize(num1TimesDenom2, commonDenominator));
        
        out.println("Now convert " + fraction2() + " into an equivalent fraction with denominator " + denominator1 + " * " + denominator2);
        out.print("Enter the numerator of the equivalent fraction: ");
        if(readUser.nextInt() != num2TimesDenom1) {
            out.print("That is incorrect. By what number should the numerator of " + fraction2()
                    + " be multipled to get an equivalent fraction with denominator " + denominator1 + " * " + denominator2 + " ?: ");
            
            if(readUser.nextInt() != denominator1) {
                out.print("That is incorrect. What is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?: ");
                
                while(readUser.nextInt() != num2TimesDenom1) {
                    out.println("That is incorrect. Try again.");
                    out.print("What is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?: ");
                }
            }
            else {
                out.print("Correct. Now what is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?: ");
         
                while(readUser.nextInt() != num2TimesDenom1) {
                    out.println("That is incorrect. Try again.");
                    out.print("What is the numerator obtained when you multiply " + fraction2() + " above and below by " + denominator1 + " ?: ");
                }
            }
        }
        out.print("Correct. Enter the (common) denominator of the equivalent fraction: ");
        while(readUser.nextInt() != commonDenominator) {
            out.print("That is incorrect. The common denominator is " + denominator1 + " * " + denominator2 + ". Enter the product!: ");
        }
        out.println("Correct. You have converted " + fraction2() + " into the equivalent fraction " + fractionize(num2TimesDenom1, commonDenominator));

        return new FractionAddCommonDenominator(num1TimesDenom2, num2TimesDenom1, commonDenominator);
    
    } //end execute

} //end class
