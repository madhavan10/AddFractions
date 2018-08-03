import static java.lang.System.out;
import java.util.Scanner;

public class FractionAddInflateDenominator extends FractionAddCoprimeCase {
    
    protected int factor;

    public FractionAddInflateDenominator() {
        //numerator1 is a random int between 1 and 9
        numerator1 = (int) (Math.random() * 9 + 1);
        //denominator1 is a random int between 2 and 10
        denominator1 = (int) (Math.random() * 9 + 2);
        //factor is between 2 and 8
        factor = (int) (Math.random() * 7 + 2);
        //numerator2 is a random int between 1 and 9 and not divisible by factor
        do {
            numerator2 = (int) (Math.random() * 9 + 1);
        } while(numerator2 % factor == 0);
        denominator2 = denominator1 * factor;
        
        int answerNumerator = numerator1 * denominator2 + numerator2 * denominator1;
        int answerDenominator = denominator1 * denominator2;
        answer = new ReduceToLowestTerms(answerNumerator, answerDenominator);
    }
    
    @Override
    public Problem execute() {
        Scanner readUser = new Scanner(System.in);
        out.println("Find the resulting fraction: " + fraction1() + "  +  " + fraction2());
        out.print("First enter the denominator of the resulting fraction: ");
        int userDenom = readUser.nextInt();
        out.print("Now enter the numerator of the resulting fraction: ");
        int userNum = readUser.nextInt();
        ReduceToLowestTerms userAnswer = new ReduceToLowestTerms(userNum, userDenom);

        //user answers correctly and in lowest terms
        if((answer.toString()).equals(userAnswer.originalFraction())) {
            out.println("Correct. " + fractionize(numerator1, denominator1) + "  +  " + fractionize(numerator2, denominator2) + 
                    "  =  " + answer.toString());
            return new CorrectState();
        }
        //user answers correctly but not necessarily in lowest terms
        else if((answer.toString()).equals(userAnswer.toString())) {
            out.println("Correct. " + fractionize(numerator1, denominator1) + "  +  " + fractionize(numerator2, denominator2) + 
                    "  =  " + userAnswer.originalFraction());
            out.println("Your answer is correct. Now reduce it to lowest terms.");
            return userAnswer;
        }
        //user answer is incorrect
        else {
            String yesNo = null;
            do {
                out.print("Incorrect. Do you need a hint? Enter y for yes OR n for no: ");
                yesNo = readUser.next();
                if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")) {
                    //user needs hint - send to fraction equivalency reduce case
                    return new FractionEquivalencyInflateDenominator(numerator1, denominator1, numerator2, factor);
                }
                else if(yesNo.equalsIgnoreCase("n") || yesNo.equalsIgnoreCase("no")) {
                    //user doesn't want hint
                    return this;
                }
                else {
                    out.println("You must enter either y or n !");
                }
            } while(yesNo != null);
            return null;
        }
    
    }//end execute

}//end class
