import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
 * 
 */
public class Solution {
	
	/*
	 * dump permutation
	 */
	static void dumpPerm(int[] absPerm) {
		System.out.print("<<< absPerm: ");
		for (int v : absPerm) {
			if (v != 0) 
				System.out.print(v + " ");
		}
		System.out.println();
	}
	

	/*
	 * Complete the absolutePermutation function below.
	 *                n!
	 * C(n, k) = -----------
	 *           k! (n - k)!
	 */
    static int[] absolutePermutation(int n, int k) {

//    	// ???? ????
//    	System.out.println("<<< n: " + n + " k: " + k);
    	
    	// **** ****
        if((k != 0) && (n % (2 * k) != 0)) {
        	
//        	// ???? ????
//        	System.out.println("<<< (n % (2 * k): " + n % (2 * k));
        	
        	// ***** ****
            return new int[] {-1};
        }
    	
        // **** ****
        int[] absPerm = new int[n];
        
        // **** traverse values ****
        for(int i = 0; i < n; i++) {
        	
            if((k != 0) && ((i / k) % 2 == 0))
                absPerm[i] = (i + 1) + k;
            else
                absPerm[i] = (i + 1) - k;
            
//            // ???? ????
//            dumpPerm(absPerm);
        }
        
        // **** ****
        return absPerm;
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * test scafolding
     */
    public static void main(String[] args) throws IOException {
    	
    	// **** ****
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        // **** ****
        bufferedWriter.close();

        // **** ****
        scanner.close();
    }
}
