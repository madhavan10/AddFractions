import java.util.Scanner;

public class FractionAddCoprimeCase implements Problem {
    
    protected final int numerator1, denominator1;
    protected final int numerator2, denominator2;
    
    protected ReduceToLowestTerms answer;

    public FractionAddCoprimeCase(int num1, int denom1, int num2, int denom2) {
        numerator1 = num1;
        denominator1 = denom1;
        numerator2 = num2;
        denominator2 = denom2;
        int answerNumerator = numerator1 * denominator2 + numerator2 * denominator1;
        int answerDenominator = denominator1 * denominator2;
        answer = new ReduceToLowestTerms(answerNumerator, answerDenominator);

    }

    public FractionAddCoprimeCase() {
        
        //generates integers between 1 and 10
        numerator1 = (int) (Math.random() * 10 + 1);
        numerator2 = (int) (Math.random() * 10 + 1);
        
        int[] coprimes = MathTools.generateCoprimes();

        if(coprimes.length == 2) {
            denominator1 = coprimes[0];
            denomninator2 = coprimes[1];
            int answerNumerator = numerator1 * denominator2 + numerator2 * denominator1;
            int answerDenominator = denominator1 * denominator2;
            answer = new ReduceToLowestTerms(answerNumerator, answerDenominator);
        }
        
        else throw new CoprimePairException();
    }

    public Problem execute() {
        Scanner readUser = new Scanner(System.in);
        System.out.println("Find the resulting fraction: " + fraction1() + " + " + fraction2());
        System.out.println("First enter the numerator of the resulting fraction: ");
        int userNum = readUser.nextInt();
        System.out.println("Now enter the denominator of the resulting fraction: ");
        int userDenom = readUser.nextInt();
        ReduceToLowestTerms userAnswer = new ReduceToLowestTerms(userNum, userDenom);
        
        //user answers correctly and in lowest terms
        if(answer.equals(userAnswer.originalFraction()) {
            System.out.println("You have correctly solved the problem.");
            return new CorrectState();
        }
        //user answers correctly but not necessarily in lowest terms
        else if(answer.equals(userAnswer)) {
            System.out.println("You answer is correct. Now reduce it to lowest terms.");
            return userAnswer;
        }
        //user answers incorrectly
        else return new FractionEquivalencyCoprimeCase(numerator1, denominator1, numerator2, denominator2);
       
    }
    
    public String fraction1() { return numerator1 + "/" denominator1 };
    public String fraction2() { return numerator2 + "/" denominator2 };

}
