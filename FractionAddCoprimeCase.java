import java.util.Scanner;

public class FractionAddCoprimeCase implements Problem {
    
    protected int numerator1, denominator1;
    protected int numerator2, denominator2;
    protected ReduceToLowestTerms answer;
    private ReduceToLowestTerms fraction1, fraction2;

    public FractionAddCoprimeCase(int num1, int denom1, int num2, int denom2) {
        numerator1 = num1;
        denominator1 = denom1;
        numerator2 = num2;
        denominator2 = denom2;
        fraction1 = new ReduceToLowestTerms(numerator1, denominator1);
        fraction2 = new ReduceToLowestTerms(numerator2, denominator2);

        int answerNumerator = numerator1 * denominator2 + numerator2 * denominator1;
        int answerDenominator = denominator1 * denominator2;
        answer = new ReduceToLowestTerms(answerNumerator, answerDenominator);
    }

    public FractionAddCoprimeCase() {
        
        //generates integers between 1 and 10
        numerator1 = (int) (Math.random() * 10 + 1);
        numerator2 = (int) (Math.random() * 10 + 1);
        
        int[] coprimes = MathTools.generateCoprimes();

        denominator1 = coprimes[0];
        denominator2 = coprimes[1];
        fraction1 = new ReduceToLowestTerms(numerator1, denominator1);
        fraction2 = new ReduceToLowestTerms(numerator2, denominator2);
        int answerNumerator = numerator1 * denominator2 + numerator2 * denominator1;
        int answerDenominator = denominator1 * denominator2;
        answer = new ReduceToLowestTerms(answerNumerator, answerDenominator);
    }

    public Problem execute() {
        Scanner readUser = new Scanner(System.in);
        System.out.println("Find the resulting fraction: " + fraction1() + "  +  " + fraction2());
        System.out.print("First enter the denominator of the resulting fraction: ");
        int userDenom = readUser.nextInt();
        System.out.print("Now enter the numerator of the resulting fraction: ");
        int userNum = readUser.nextInt();
        ReduceToLowestTerms userAnswer = new ReduceToLowestTerms(userNum, userDenom);
        
        //user answers correctly and in lowest terms
        if((answer.toString()).equals(userAnswer.originalFraction())) {
            System.out.println("Correct. " + fractionize(numerator1, denominator1) + "  +  " + fractionize(numerator2, denominator2) + 
                    "  =  " + answer.toString());
            return new CorrectState();
        }
        //user answers correctly but not necessarily in lowest terms
        else if((answer.toString()).equals(userAnswer.toString())) {
            System.out.println("Correct. " + fractionize(numerator1, denominator1) + "  +  " + fractionize(numerator2, denominator2) + 
                    "  =  " + userAnswer.originalFraction());
            System.out.println("Your answer is correct. Now reduce it to lowest terms.");
            return userAnswer;
        }
        //user answers incorrectly
        else {
            System.out.println("Your answer is incorrect...");
            //both fractions in lowest terms - send to fraction equivalency module
            if(fraction1.isInLowestTerms() && fraction2.isInLowestTerms()) {
                return new FractionEquivalencyCoprimeCase(fraction1.getReducedNumerator(), fraction1.getReducedDenominator(), 
                        fraction2.getReducedNumerator(), fraction2.getReducedDenominator());
            }

            //fraction1 is not in lowest terms
            if(!fraction1.isInLowestTerms()) {
               System.out.println(fraction1.originalFraction() + " is not in lowest terms!");
               Problem reduceProblem = fraction1;
               while(!(reduceProblem instanceof CorrectState)) {
                    reduceProblem = reduceProblem.execute();
               }
            }

            //fraction2 is not in lowest terms
            if(!fraction2.isInLowestTerms()) {
               System.out.println(fraction2.originalFraction() + " is not in lowest terms!");
               Problem reduceProblem = fraction2;
               while(!(reduceProblem instanceof CorrectState)) {
                    reduceProblem = reduceProblem.execute();
               }
            }
            return new FractionAddCoprimeCase(fraction1.getReducedNumerator(), fraction1.getReducedDenominator(),
                    fraction2.getReducedNumerator(), fraction2.getReducedDenominator());

        }
    }
    
    public String fraction1() { return numerator1 + "/" + denominator1; }
    public String fraction2() { return numerator2 + "/" + denominator2; }

    protected static String fractionize(int a, int b) {
        return a + "/" + b;
    }

} //end class
