import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main1 {

    // Find the smallest number in an array
    static int smallestNumInArray(int arr[]){
        int min = Integer.MAX_VALUE;
        int i =0;
        while(i<arr.length){
            if(arr[i]<min){
                min = arr[i];
            }
            i++;
        }
        return min;
    }

    // Find the largest number in an array
    static int largestElementInArray(int arr[]){
        int largest = Integer.MIN_VALUE;
        int i =0; 
        while(i<arr.length){
            if(arr[i]>largest){
                largest = arr[i];
            }
            i++;
        }

        return largest;
    }

    // Second Smallest and Second Largest element in an array
    static int secondLargestElementInArray(int arr[]){
        // Base case
        if(arr.length<2){
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        for(int i =0; i< arr.length; i++){
            if(arr[i]>largest){
                //update seclargest to largest then update largest with new high largest
                secLargest = largest;
                largest = arr[i];
            }else if (arr[i]> secLargest && arr[i]!= largest){
                secLargest = arr[i];
            }
        }
        return secLargest;
    }

    static int secondSmallestElementInArray(int arr[]){
        // Base case
        if(arr.length<2){
            return -1;
        }

        int smallest = Integer.MAX_VALUE;
        int secSmallest = Integer.MAX_VALUE;
        for(int i =0; i< arr.length; i++){
            if(arr[i]<smallest){
                //update seclargest to largest then update largest with new high largest
                secSmallest = smallest;
                smallest = arr[i];
            }else if (arr[i]> secSmallest && arr[i]!= smallest){
                secSmallest = arr[i];
            }
        }
        return secSmallest;
    }

    // Reverse a given array
    static int [] reverseArray(int arr[]){
        int n = arr.length;
        for(int i=0; i<arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;

        }
        return arr;
    }

    // Count frequency of each element in an array
    static void countFrequencyOfElementInArray(int arr[]){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Print the frequencies 
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
           
            System.out.println(en.getKey() + " : " + en.getValue());
        }
    
    }

    // Rearrange array in increasing-decreasing order
    static int[] rearrangeIncresingDecresingOrder(int arr[]){
        // First sort it 
        Arrays.sort(arr);

        // Now first part is sort. So we need to sort remaining part that is second sort.
        int n = arr.length;
        int mid = n/2;
        for(int i= mid; i< (mid + (n-mid)/2); i++){
            int temp = arr[i];
            arr[i] = arr[n-(i-mid)-1];
            arr[n-(i-mid)-1] = temp;
        }
        return arr;
    }

    // Average of all elements in an array
    static double averageOfAllElements(int arr[]){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }

        return (double) sum/arr.length;
    }






    public static void main(String[] args) {
        // int arr[] = {4, 2, 8, 6, 15, 5, 9, 20} ;
        // System.out.println(smallestNumInArray(arr));
        // System.out.println(largestElementInArray(arr));
        // System.out.println(Arrays.toString(reverseArray(arr)));
        // countFrequencyOfElementInArray(arr);
        // System.out.println(Arrays.toString(rearrangeIncresingDecresingOrder(arr)));
        int arr[] = {1,2,1,1,5,1};
        System.out.println(averageOfAllElements(arr));
      
    }
    
}
