import java.util.Scanner;

public class ReduceToLowestTerms implements Problem {

    private final int numerator;
    private final int denominator;

    private int reducedNumerator, reducedDenominator;
	
    public ReduceToLowestTerms() {
		numerator = reducedNumerator = MathTools.specialSmallPrimeRand();
		denominator = reducedDenominator = MathTools.specialSmallPrimeRand();
		reduceToLowestTerms();
	}

    public ReduceToLowestTerms(int numerator, int denominator) {
        this.numerator = reducedNumerator = numerator;
        this.denominator = reducedDenominator = denominator;
        this.reduceToLowestTerms();
    }

    public Problem execute() {
		//if generated fraction is already in lowest terms restart with a new one	
		if(numerator == reducedNumerator && denominator == reducedDenominator) {
			return new ReduceToLowestTerms();
		}

		Scanner readInput = new Scanner(System.in);
        System.out.println("What is the fraction " + this.originalFraction() + " after reducing it to lowest terms?");
        System.out.print("First enter the numerator:");
        int userNum = readInput.nextInt();
        System.out.print("Now enter the denominator:");
        int userDenom = readInput.nextInt();

        ReduceToLowestTerms userAnswer = new ReduceToLowestTerms(userNum, userDenom);
        
        //user answers correctly
        if(this.toString().equals(userAnswer.originalFraction())) {
            System.out.println("You just reduced " + this.originalFraction() + " to " + this.toString() + ".");
            return new CorrectState();
        }

        //user's fraction is correct but not in lowest terms
		//also checks that user didn't just re-enter the given fraction without reduction
        else if(this.toString().equals(userAnswer.toString())
			&& !(this.originalFraction().equals(userAnswer.originalFraction()))) {

            System.out.println("You just reduced " + this.originalFraction() + " to " + userNum + "/" + userDenom + ".");
            System.out.println("You're on the right track but you still have to reduce to lowest terms!");
            return userAnswer;
        }

        //user answer is incorrect
        else {
            String yesNo = null;
            do {
                System.out.print("Incorrect. Do you need a hint? Enter y for yes OR n for no: ");
                yesNo = readInput.next();
                if(yesNo.equalsIgnoreCase("y") || yesNo.equalsIgnoreCase("yes")) {
                    return new FindAFactor(this.numerator, this.denominator);
                }

                else if(yesNo.equalsIgnoreCase("n") || yesNo.equalsIgnoreCase("no")) {
                    return this;
                }
                
                else {
                    System.out.println("You must enter either y or n !");
                }
            } while(yesNo != null);
            return null;
        }
    } //end execute()

    private void reduceToLowestTerms() {
        reducedNumerator = numerator / MathTools.gcd(numerator, denominator);
        reducedDenominator = denominator / MathTools.gcd(numerator, denominator);

        if(reducedNumerator < 0 && reducedDenominator < 0) {
            reducedNumerator *= -1;
            reducedDenominator *= -1;
        }

        else if(reducedNumerator >= 0 && reducedDenominator < 0) {
            reducedNumerator *= -1;
            reducedDenominator *= -1;
        }
    }

    public String toString() {
        String result = reducedNumerator + "/" + reducedDenominator;
        return result;
    }

    public String originalFraction() {
        return numerator + "/" + denominator;
    }
    
    public int getReducedNumerator() { return reducedNumerator; }
    public int getReducedDenominator() { return reducedDenominator; }
    
    public boolean isInLowestTerms() {
        return (this.toString()).equals(this.originalFraction());
    }

} //end class
    

