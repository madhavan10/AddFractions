public class Main {
	public static void main(String[] args) throws CoprimePairException {
		Problem nextProblem = new FractionAddCoprimeCase();
            while(!(nextProblem instanceof CorrectState)) {
                nextProblem = nextProblem.execute();
            }
            System.out.println("You have correctly solved the problem.");
	}
}
