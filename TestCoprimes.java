public class TestCoprimes {
    public static void main(String[] args) {
        for(int i = 1; i <=50; ++i) {
            
            int[] coprimes = MathTools.generateCoprimes();
            System.out.print(coprimes[0]);
            System.out.println("   " + coprimes[1]);
        }
    }
}

