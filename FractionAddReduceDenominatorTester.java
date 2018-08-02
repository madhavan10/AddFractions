public class FractionAddReduceDenominatorTester {
	public static void main(String[] args) {
		Problem nextProblem = new FractionAddReduceDenominator();
            while(!(nextProblem instanceof CorrectState)) {
                nextProblem = nextProblem.execute();
            }
            System.out.println("You have correctly solved the problem.");
	}
}
