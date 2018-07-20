import java.util.Random;
import java.util.ArrayList;

public class MathTools {
	
	

	//generate first coprime by drawing with replacement from first {2, 3, 5, 7, 11} and then {2, 3, 5}
	//generate second coprime by drawing twice with replacement from {2, 3, 5, 7, 11} - {draw1, draw2}
	//NOTE: generating second coprime has no worst case time complexity as done here
	public static int[] generateCoprimes() {
		
		Random gen = new Random();

		int[] smallPrimes = {2, 3, 5, 7, 11};
		int[] coprimes = new int[2];
		ArrayList<Integer> alreadyDrawn = new ArrayList();

		//generating first coprime
		int draw = smallPrimes[gen.nextInt(5)];
		alreadyDrawn.add(draw);
		coprimes[0] = draw;
		draw = smallPrimes[gen.nextInt(3)];
		if(!alreadyDrawn.contains(draw))
			alreadyDrawn.add(draw);
		coprimes[0] *= draw;

		//generating second coprime
		draw = smallPrimes[gen.nextInt(5)];
		while(alreadyDrawn.contains(draw)) {
			draw = smallPrimes[gen.nextInt(5)];
		}
		coprimes[1] = draw;
		
		draw = smallPrimes[gen.nextInt(3)];
		while(alreadyDrawn.contains(draw)) {
			draw = smallPrimes[gen.nextInt(3)];
		}
		coprimes[1] *= draw;

		return coprimes;
	}

}

		
			
