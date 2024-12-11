import java.io.File;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception
    {
        // pass the path to the file as a parameter
        File file = new File("data.txt");
        Scanner sc = new Scanner(file);
        
        // set up structures to hold the data
        int[] arr1 = new int[1000];
        int[] arr2 = new int[1000];

        int index = 0;

        // load all of the data from the file
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // parse numbers from the line of input
            int space = line.indexOf(" ");
            int num1 = Integer.parseInt(line.substring(0, space));
            int num2 = Integer.parseInt(line.substring(space+3));

            // store to our data structures
            arr1[index] = num1;
            arr2[index] = num2;
            index++;
        }
        
        // sorting
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        // visit each parallel pair, subtract, get sum
        int sum = 0;
        for(int i = 0; i < arr1.length; i++) {
            sum += Math.abs(arr2[i] - arr1[i]);
        }
        // System.out.println(sum);

        // PART 2
        HashMap<Integer, Integer> comparisons = new HashMap<Integer, Integer>();

        int numMatches = 0;
        int numComparisons = 0;
        for(int i = 0; i < arr1.length; i++) {
            int leftVal = arr1[i];
             if (!comparisons.containsKey(leftVal)) {
                comparisons.put(leftVal, 0);
            }
            for(int j = 0; j < arr2.length && arr2[j] <= leftVal; j++) {
                // numComparisons++;
                // if (leftVal == arr2[j]) {
                    // numMatches++;
                    // System.out.println("match! left: " + leftVal + " " + arr2[j]);
                // }
                if(leftVal == arr2[j]) {
                    if(comparisons.containsKey(arr2[j])) {
                        comparisons.put(leftVal, comparisons.get(leftVal) + 1);
                    }
                }
                
            } 
        }
        // System.out.println(numMatches + " " + numComparisons);
        int total = 0;
        for (int i : comparisons.keySet()) {
            System.out.println("key: " + i + " value: " + comparisons.get(i));
            total += comparisons.get(i) * i;
        }
        System.out.print(total);
    }
}
