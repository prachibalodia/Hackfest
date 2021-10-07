import java.io.*;
import java.util.*;

class Equilibrium {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            EquilibriumPoint obj = new EquilibriumPoint();
            
            //calling equilibriumPoint() function
            System.out.println(obj.equilibriumPoint(arr, n));
        }
    }
}// } Driver Code Ends


class EquilibriumPoint {

    public static int equilibriumPoint(long a[], int n) {

        // Sum of all array elements
        long sum = 0;
        for (int i = 0; i < n; i++) 
           sum += a[i];

        // sum2 is used to store prefix sum
        long sum2 = 0;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            
            // Update suffix sum
            sum = sum - a[i];
            
            // Check if suffix and prefix 
            // sums are same
            if (sum2 == sum) {
                return (i + 1);
            }
            
            // Update prefix sum
            sum2 = sum2 + a[i];
        }
        return -1;
    }
}
