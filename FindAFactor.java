import java.util.Scanner;
import java.util.ArrayList;

public class FindAFactor implements Problem {

    private int numerator, denominator;
    private ArrayList<Integer> factorList = new ArrayList<Integer>();

    public FindAFactor(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.createFactorList();
    }

    public Problem execute() {
        Scanner readInput = new Scanner(System.in);

        System.out.println("Enter ONE common factor between " + numerator + " and " + denominator + ":");
        int userFactor = readInput.nextInt();
        if(factorList.contains(userFactor)) {
            System.out.println("Divide both numerator and denominator by " + userFactor + " and enter the result");
            boolean correct = false;
            int userNum, userDenom;

            do {
                System.out.println("Enter the numerator after division by " + userFactor + ":");
                userNum = readInput.nextInt();
                correct = (userNum == numerator/userFactor);
                if(!correct)
                    System.out.println("This division is incorrect. Try again.");
            } while(!correct);
            
            do {
                System.out.println("Enter the denominator after division by " + userFactor + ":");
                userDenom = readInput.nextInt();
                correct = (userDenom == denominator/userFactor);
                if(!correct)
                    System.out.println("This division is incorrect. Try again.");
            } while(!correct);
            
            if(userFactor == MathTools.gcd(numerator, denominator)) {
                return new CorrectState();
            }
            else { 
            	System.out.println("You just reduced " + numerator + "/" + denominator + " to " + userNum + "/" + userDenom + ".");
            	System.out.println("You're on the right track but you still have to reduce to lowest terms!");
				return new ReduceToLowestTerms(userNum, userDenom);
			}
        }

        else {
            System.out.println(userFactor + " is not a common factor of " + numerator + " and " + denominator);
            return this;
        }
    }

    private void createFactorList() {
        for(int i = 2; i <= Math.min(numerator, denominator); i++) {
            if(numerator % i == 0 && denominator % i == 0) {
                factorList.add(i);
            }
        }
    }



}

