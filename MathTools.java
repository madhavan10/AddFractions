import java.util.Random;
import java.util.ArrayList;

public class MathTools {
	
	
    public static int gcd(int p, int q) {
        
        int lower = Math.min(Math.abs(p), Math.abs(q));
        int gcd = 1;
        for(int i = 2; i <= lower; i++) {
            if(p % i == 0 && q % i == 0) {
                gcd = i;
            }
        }

        return gcd;

    }
    
    //Draw 2 primes with replacement from {2, 3, 5}
    //Draw one prime from {2, 3, 5, 7}
    public static int specialSmallPrimeRand() {
        Random gen = new Random();
        
        int[] smallPrimeArray = {2, 3, 5, 7};
        
        int product = 1;
        product *= smallPrimeArray[gen.nextInt(4)];
        product *= smallPrimeArray[gen.nextInt(3)];
        product *= smallPrimeArray[gen.nextInt(3)];

		return product;
    }

	//generate first coprime by drawing with replacement from first {2, 3, 5, 7} and then {2, 3, 5}
	//generate second coprime by drawing twice with replacement from {2, 3, 5, 7, 11} - {draw1, draw2} but discard if >= 50
	//NOTE: generating second coprime has no worst case time complexity as done here
	public static int[] generateCoprimes() {
		
		Random gen = new Random();

		int[] smallPrimes = {2, 3, 5, 7, 11};
		int[] coprimes = new int[2];
		ArrayList<Integer> alreadyDrawn = new ArrayList<Integer>();

		//generating first coprime
		int draw = smallPrimes[gen.nextInt(4)];
		alreadyDrawn.add(draw);
		coprimes[0] = draw;
		draw = smallPrimes[gen.nextInt(3)];
		if(!alreadyDrawn.contains(draw))
			alreadyDrawn.add(draw);
		coprimes[0] *= draw;

		//generating second coprime
		int draw1 = smallPrimes[gen.nextInt(4)];
		while(alreadyDrawn.contains(draw1)) {
			draw1 = smallPrimes[gen.nextInt(4)];
		}
        //keep the final number under 50
		do {
		    coprimes[1] = draw1;
            int draw2 = smallPrimes[gen.nextInt(5)];
            while(alreadyDrawn.contains(draw2)) {
                draw2 = smallPrimes[gen.nextInt(5)];
            }
            coprimes[1] *= draw2;
        } while(coprimes[1] >= 50);

		return coprimes;
	}

}

		
			
