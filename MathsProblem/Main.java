
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

    // LCM of two numbers
    static int lcmOfTwoNumber(int num1, int num2){
        return (num1*num2) / gcdOfTwoNumber(num1, num2);
    }

    // Check if a number is Harshad number
    static boolean checkHarshadNumber(int num){
        int sum =0;
        int originalNum = num;
        while(num>0){
            sum += num%10;
            num = num /10;
        }
        
        return originalNum%sum==0;
    }

    // Check if the number is abundant number or not
    static boolean checkAbundantNumber(int num){
        int sum =0;
        for(int i=1; i<= Math.sqrt(num); i++){
            if(num %i==0){
                if(i == num/i){
                    System.out.println(i);
                    sum += i;
                }else{
                    sum +=i;
                    sum +=num/i;
                    System.out.println(i);
                    System.out.println(num/i);
                }
            }
        }

        // Subtract the number itself from the sum of divisors
        sum -= num;

        return sum>num; // if sum of divisors greater than actual number it means it's abundant number else not abundant number.
    }

    // Permutations in which N people can occupy R seats
    // To find permutations of n people in r seats we have to find the value of n!/(n-r)!.The value of 5!/(5-3)! is 60.
    static int permutationsOfNpeopleInRSeats(int N, int r){
        
        return factorialOfNumber(N)/factorialOfNumber(N-r);
    }

    // Program to Add two fractions
    static int additionOfTwoFractions(int Numerator1, int Denominator1 , int Numerator2, int Denominator2){
        

        
        return -1;

    }

    // Replace all 0s with 1s in a given integer
    static int replaceZeroWithOne(int num){
        int reversed = 0;
        while(num >0){
            int digit = num %10;

            // Replace 0 with 1 digit
            if(digit ==0){
                digit =1;
            }

            reversed = reversed*10 + digit;

            // divide number by 10
            num = num/10;
        }

        // Now reverse thee reversed number to get final output
        int finalNum=0;
        while(reversed>0){
            finalNum = finalNum*10 + reversed%10;
            reversed = reversed/10;
        }

        return finalNum;
    }

    // Program to Find Roots of a quadratic equation
    static void findRootsOfQuadraticEq(int a, int b, int c){
        // calculate descriminant d
        int d = b*b - 4*a*c;

        // get sqrt of d 
        double sqrt_val_d = Math.sqrt(Math.abs(d));

        // check roots by d 
        if(d>0){
            System.out.println("Roots are real and both different");
            double root1 = (-b + sqrt_val_d)/2.0*a;
            double root2 = (-b - sqrt_val_d)/2.0*a;
            System.out.println("Root 1: "+root1);
            System.out.println("Root 2: "+root2);
        }else if (d==0){
            System.out.println("Roots are real but equal");
            double root = (-b)/2.0*a;
            System.out.println("Root 1: "+root);
            System.out.println("Root 2: "+root);
        }else{
            System.out.println("Roots are imaginary");
        }

    }

    // Express given number as Sum of Two Prime Numbers


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
        // System.out.println(lcmOfTwoNumber(3, 6));
        // System.out.println(checkHarshadNumber(378));
        // System.out.println(checkAbundantNumber(21));
        // System.out.println(permutationsOfNpeopleInRSeats(5, 3)); 
        // System.out.println(replaceZeroWithOne(102003));
        // findRootsOfQuadraticEq(1, -3, -10);
    }
}
