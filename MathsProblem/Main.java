
import java.util.ArrayList;




public class Main {
    
    // Count Digits
    static int countDigit(int num){

        int count =0;

        while(num>0){
            count++;
            num = num/10;
        }

        return count;
    }

    // Reverse Number 
    static int reverseNumber(int num){

        int reversedNum = 0;

        while(num>0){
            int rem = num%10;
            reversedNum = reversedNum*10 + rem;
            num = num/10;
        }
        
        return reversedNum;
    }

    // Print All Divisors
    static void printDivisors(int num){
        
        int pointer = num;
        while(pointer>0){
            if(num%pointer ==0){
                System.out.println(pointer);
            }
            
            pointer--;
        }
    }

    // HCF of Numbers 
    static int hcfOfNumbers(int num1, int num2){

        int n =num1;
        if(num1 < num2){
            n = num1;
        }else{
            n = num2;
        }

        for(int i=n; i>=1; i--){
            if(num1 % i ==0 && num2 % i ==0){
                return i;
            }
        }

        return -1;
    }

    // Palindrome Number
    static boolean checkPalindrome(int num){

        int reversedNum = 0;
        int temp = num;

        while(num>0){
            int rem = num%10;
            reversedNum = reversedNum*10 + rem;
            num = num/10;
        }
        
        return reversedNum==temp;
    }

    // Check prime number
    static boolean checkPrimeNumber(int num ){
        // Base case 1
        if(num<=1){
            return false;
        }

        // base case 2 
        if(num ==2){
            return true;
        }

        for(int i = (int) Math.sqrt(num); i>=2; i--){
            if(num % i == 0){
                return false;
            }
        }

        return true;

    }

    // Check if a number is armstrong number of not
    static boolean checkArmstrongNumber(int num){
       
        // Check the size of number first
        int count = 0;
        int temp = num;
        while(temp>0){
            count++;
            temp = temp/10;
        }

        int size = count;
        int sum = 0;
        int originalNum = num;
        while (num>0){
            int rem = num %10;
            sum += (int) Math.pow(rem, size);
            num = num/10;
        }

        if(originalNum == sum ){
            return true;
        }

        return false;
    }

    // Prime numbers in a given range
    static ArrayList<Integer> primeNumbersInRange(int min, int max){
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i = min; i <= max; i++){
            if(checkPrimeNumber(i)){
                list.add(i);
            }
        }
        return list;
    }

    // Check if a number is perfect number (A perfect number is defined as a number that is the sum of its proper divisors ( all its positive divisors excluding itself).)
    static boolean checkPerfactNumber(int num){
        int originalNum = num;
        int sumOfFac = 0;

        int i =1;
        while(i<num){
            if(num%i ==0){
                sumOfFac += i;
            }
            i++;
        }

        return sumOfFac == originalNum;
    }

    // Find Sum of AP Series
    static int sumOfFirstNNaturalNumber(int num){
        int i =1;
        int sum =0;
        while(i<=num){
            sum += i;
            i++;
        }
        return sum;
    }

    static int sumOfAPSeries(int firstTerm, int numberOfTerms, int commonDiff){
        int lastTerms = firstTerm+ (numberOfTerms-1)*commonDiff;
        int sum = numberOfTerms * (firstTerm+ lastTerms)/2;
        return sum;
    }

    // Program to find sum of GP Series
    static float  sumOFGPSeries(double firstTerm, int numberOfTerms, double commonRatio){
        float sum =0;

        for(int i = numberOfTerms; i>0; i--){
            sum += firstTerm * (double) Math.pow(commonRatio, i-1);
        }
        return sum;
    }
    
    // Leap Year or not
    static boolean checkLeapYear(int year){
        if(year % 400 ==0){
            return true;
        }else if ((year % 4 ==0) && (year % 100 !=0)){
            return true;
        }

        return false;
    }

    // Maximum and Minimum Digit in a Number
    static int [] maximumAndMinimumDigitOfNumber(int num){
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(num>0){
            int rem = num % 10;
            max = Math.max(max, rem);
            min = Math.min(min, rem);

            num = num /10;
        }

        return new int[] {min, max};
    }

    // Print Fibonacci upto Nth Term
    static void printFibnacciSeries(int a, int b, int n){
        // Base case 
        if (n==0){
            return;
        }

        int c = a+b;
        System.out.println(c);
        printFibnacciSeries(b, c, n-1);
    
    }

    // Factorial of a number
    static int factorialOfNumber(int num){
        // Base case 1
        if(num==0){
            return 1;
        }

        // Base case 2
        if(num < 0){
            return -1;
        }

        int factn = num* factorialOfNumber(num-1);
        return factn;

    }

    // Print all prime factors of the given number
    static ArrayList<Integer> printPrimeFactorsOfNumber(int num){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =2; i<= Math.sqrt(num); i++){
            if(num % i ==0){
                if(checkPrimeNumber(i)){
                    list.add(i);
                    if(i!= num/i){
                        if(checkPrimeNumber(num/i)){
                            list.add(num/i);
                        }
                    }
                }
            }
        }

        return list;
    }

    // Check if a number is a strong number or not
    static boolean checkStrongNumb(int num){

        int sum = 0;
        int originalNum = num;
        while(num >0){
            int rem = num%10;
            sum += factorialOfNumber(rem);
            num = num /10;
        }

        return originalNum == sum;
    }

    // Check if a Number is Automorphic
    static boolean checkAutomorphicNumb(int numb){
        int square = numb * numb;

        while(numb>0){
            if(numb%10 != square%10){
                return false;
            }

            numb = numb /10;
            square = square /10;
        }
        return true;
    }

    // GCD of two numbers
    static int gcdOfTwoNumber(int num1 , int num2){
        int num = num1<num2 ? num1: num2;
        while(num>0){
            if(num1%num ==0 && num2%num==0){

                return num;
            }
            num= num/10;
        }
        return -1;
    }






    public static void main(String[] args) {
        // printDivisors(20);
        // int result = countDigit(425452);
        // System.out.println(result);
        // System.out.println(hcfOfNumbers(8, 12));
        // System.out.println(checkPalindrome(67456));
        // System.out.println(checkPrimeNumber(1));
        // System.out.println(checkArmstrongNumber(1634));
        // System.out.println(primeNumbersInRange(2, 10));
        // System.out.println(checkPerfactNumber(27));
        // System.out.println(sumOfFirstNNaturalNumber(6));
        // System.err.println(sumOfAPSeries(2, 4, 2));
        // System.out.println(sumOFGPSeries(1, 3, 0.5));
        // System.out.println(checkLeapYear(2024));
        // System.out.println(Arrays.toString(maximumAndMinimumDigitOfNumber(4596844)));
        // printFibnacciSeries(0, 1, 5);
        // System.out.println(factorialOfNumber(4));
        // System.out.println(printPrimeFactorsOfNumber(35));
        // System.out.println(checkStrongNumb(145));
        // System.out.println(checkAutomorphicNumb(23));
    }
}
