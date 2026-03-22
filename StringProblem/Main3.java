package StringProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main3 {

    // Check if a given string is palindrome or not
    static String checkPalindromeString(String s, int i){

        // base case 
        if(i>= s.length()/2){
            return "Palindrome";
        }

        if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return "Not Palindrome";
        }

        // if both are same increent i and check for (start +1 and end -1) ...... call recursively
        return checkPalindromeString(s, i+1);
    }

    // Count number of vowels, consonants, spaces in String
    static void countVowelsConsonantesSpace(String s){
        int VowelsConut = 0;
        int ConsonantsCount = 0;
        int SpacesCount = 0;
        String str = s.toLowerCase();
       
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);

            // check and update counts
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                VowelsConut ++;
            }else if (ch == ' '){
                SpacesCount ++;
            }else if(ch >='a' && ch <= 'z'){
                ConsonantsCount ++;
            }
        }

        System.out.println("Vowels count: "+ VowelsConut+"\n"+"Consonantes Count: "+ ConsonantsCount+ "\n"+ "Spaces count: "+SpacesCount);
    }

    // Find the ASCII value of a character
    static int findASCIIValue(char c){
        return (int) c;
    }

    // Remove all vowels from the string
    static String removeVowels(String s){
        
        String str = s.toLowerCase();
        StringBuilder result = new StringBuilder();
        for(int i =0; i<str.length(); i++){
            char ch = str.charAt(i);

            // check and update counts
            if(ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                result.append(ch);
            }

        }
        return result.toString();
    }

    // Remove Spaces from a String
    static String removeSpace(String s){

        StringBuilder sb = new StringBuilder();  // Also we can use direct normal string

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // Remove characters from a string except alphabets
    static String removeCharacterExceptAlphabets(String s){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >='a' && ch<='z'){
                result+=ch;
            }
        }
        return result;
    }

    // Reverse a String 1 solution
    // static String reverseString(String s){
    //     StringBuilder sb = new StringBuilder(s);
    //     System.out.println(sb.length());
    //     for(int i=0; i< sb.length()/2; i++){
    //         int front = i;
    //         int end = sb.length() - i-1;
    //         char frontChar = sb.charAt(front);
    //         char backChar = sb.charAt(end);

    //         // swap
    //         sb.setCharAt(front, backChar);
    //         sb.setCharAt(end, frontChar);
    //     }
    //     return sb.toString();
    // }
    
    // 2nd Solution
    static String reverseString(String s){
        int left =0; 
        int right = s.length()-1;
        char [] arr = s.toCharArray();
        while(left<right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left ++;
            right --;
        }
        return new String(arr);
    }

    // Remove brackets from an algebraic expression
    static String removeBrackets(String s){
        String result = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != '(' && ch!=')'){
                result += ch;
            }
        }
        return result;
    }

    // Sum of the numbers in a String (multiple consecutive digits are considered one number)
    static int sumOfNumbersInString(String s){
        int sum =0;
        String temp = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                temp += ch;
            }
            else {

                // To avoid adding empty string check first 
                if(!temp.isEmpty()){
                    System.out.println("Current tmep which will be added "+temp);
                    sum += Integer.parseInt(temp);
                }
                
                temp = "";
            }
        }

        // add last number   also to avoid empty string add issue check first
        if(!temp.isEmpty()){
            System.out.println("Current tmep which will be added "+temp);
            sum += Integer.parseInt(temp);
        }
        
        return sum;
    }

    // Capitalize first and last character of each word
    static String capitalizeFirstAndLastLetter(String s){
        String [] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(String word : words){
            if(word.length() ==1){
                result.append(word.toUpperCase());
            }else{
                String newWord = Character.toUpperCase(word.charAt(0))+ word.substring(1, word.length()-1) + Character.toUpperCase(word.charAt(word.length()-1));
                result.append(newWord);
            }

            result.append(" ");
        }

        return result.toString().trim();

    }

    // Calculate Frequency of characters in a String
    static void countFreqOfAllChar(String s){
        int [] freqArr = new int[26];

        // Get the counts 
        for(int i=0; i<s.length(); i++){
            freqArr[s.charAt(i) -'a'] ++;
        }

        // Now print the character along with their count or frequencies..
        for(int i=0; i<26; i++){
            if(freqArr[i] !=0){
                System.out.println((char) (i+'a') + ": " + freqArr[i]);
            }
        }
    }

    // Through Hashmap count frequencies of each character
    static void countFreq(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        
        // Get the count 
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1); // or map.put(ch, 1)
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        System.out.println(map);
    }

    // Find Non-repeating characters of a String
    static void nonRepeatingCharInString(String s){
        int freqArr[] = new int[26];

        // get the count 
        for(int i=0; i<s.length(); i++){
            freqArr[s.charAt(i) - 'a'] ++;
        }

        // get non repeating ch in String 
        for(int i=0; i<26; i++){
            if(freqArr[i]!= 0 && freqArr[i]<2){
                System.out.println("Non repeating characters are: "+ (char) (i + 'a'));
            }
        }
    }

    // Non repeating ch through map 
    static void nonRepeatingch(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        // print the non repeating character in string
        for(Map.Entry<Character, Integer> en: map.entrySet()){
            if(en.getValue()<2){
                System.out.println(en.getKey()+ " occours : "+ en.getValue()+ " times");
            }
        }
    }

    // Check if two strings are anagram of each other
    static boolean checkIfAnagramsOfEachOther(String s1, String s2){
        int freqArr[] = new int[26];

        // base case 
        if(s1.length() != s2.length()){
            return false;
        }

        // increment count if occurs first times 
        for(int i=0; i<s1.length(); i++){
            freqArr[s1.charAt(i) - 'a'] ++;
        }

        // decrement count if occurs so if incremented before so that must be greter than 0 or if it still 0 it means not found in str1 so there value will become -1....;
        for(int i=0; i<s2.length(); i++){
            freqArr[s2.charAt(i) - 'a'] --;
        }

        // Now check if count is <0 i.e -1 or something that means there is any character which is not found in both string ... so no anagram of each other
        for(int i=0; i< 26; i++){
            if(freqArr[i] !=0){
                return false;
            }
        }

        return true;
    }

    // through map check if anagaram
    static boolean checkIfAnagram(String s1 , String s2){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s1.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }
        for(char ch : s2.toCharArray()){
            if(!map.containsKey(ch) || map.get(ch) ==0){
                return false;
            }else{
                map.put(ch, map.get(ch)-1);
            }
        }

       return true;

    }

    // Maximum occurring character in a string
    static char maximumCharacterInString(String s){
        
        int freqArr[] = new int[26];

        // get the count 
        for(int i=0; i<s.length(); i++){
            freqArr[s.charAt(i) - 'a']++;
        }

        // now check the actual count of each characters
        int maxcount = 0;
        char maxOccuredChar = 'a';
        for(int i=0; i<26; i++){
            if(freqArr[i]> maxcount){
                maxcount = freqArr[i];
                maxOccuredChar = (char) (i+ 'a');
            }
        }
        
        return maxOccuredChar;
    }

    // Remove all duplicates from the input string.
    static String removeAllDuplicates(String s){
        HashMap<Character , Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();

        // Add first element 
        map.put(s.charAt(0), 1);
        str.append(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
                str.append(ch);
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        return str.toString();
    }

    // Print all the duplicates in the input string. 
    static void printAllDuplicateCharInString(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){

            if(!map.containsKey(ch)){
                map.put(ch, 1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }

        // Chcek duplicates and print the data 
        for(Map.Entry<Character, Integer> en: map.entrySet()){
            if(en.getValue()>1){
                System.out.println(en.getKey() + " occurs "+ en.getValue()+ " times");
            }
        }
    }

    // Print all duplicates through simple for loop
    static void printDuplicate(String s){
        int freqArr[] = new int[26];

        for(int i =0; i<s.length(); i++){
            freqArr[s.charAt(i) - 'a'] ++;
        }

        // output
        for(int i=0; i<26; i ++){
            if(freqArr[i] >1){
                System.out.println((char) (i+ 'a') + " occurs "+ freqArr[i] + " times." );
            }
        }
    }

    // Remove characters from first string present in the second string
    static String removeCharacterFromFirstStringPersentInSecond(String s1, String s2){
        // We only check presence, not frequency so HashSet not Hashmap.
        HashSet<Character> setOfStr2 = new HashSet<>();
        
        // add character form str 2 into map 
        for(char ch : s2.toCharArray()){
            setOfStr2.add(ch);
        }

        StringBuilder finalStr = new StringBuilder();

        // Now run for loop and take character in finalStr only .. which is not present in map 
        for(char ch : s1.toCharArray()){
            if(!setOfStr2.contains(ch)){
                finalStr.append(ch);
            }
        }

        return finalStr.toString();
    }

    // Change every letter with the next lexicographic alphabet in the given string
    static String changeEveryLetterWithNextLexicographicAlph(String s){
        StringBuilder newStr  = new StringBuilder();
        
        for(int i=0 ; i<s.length(); i++){
            char ch = s.charAt(i);
            int ascii = (int) ch;

            if(ascii ==90) {  // Z, wrap to A
                newStr.append((char) 65);
            }else if(ascii == 122){ // z , wrap to a
                newStr.append((char) 97);
            }else if((ascii>=65 && ascii < 90) || (ascii>=97 || ascii<122)){  // for all alphanet A to Z and a to z
                newStr.append((char) (ascii + 1));
            }else{
                newStr.append(ch); // leave other character unchanged 
            }
        }

        return newStr.toString();
    }

    // Write a program to find the largest word in a given string.
    static String findLargestWordInString(String s){
        HashMap<String , Integer> map = new HashMap<>();
        StringBuilder tempStr = new StringBuilder();
        
        // Get the individual Strings length stored into map 
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' '){
                tempStr.append(ch);
            }else{
                map.put(tempStr.toString(), tempStr.length());
                tempStr.delete(0, tempStr.length());
            }
        }

        // Add last word
        if(tempStr.length()>0){
            map.put(tempStr.toString(), tempStr.length());
        }

        // Now check individual String length and based on that find out largest String
        int maxLenStr =0;
        String largestString = "";
        for(Map.Entry<String, Integer> en: map.entrySet()){
            if(en.getValue()>maxLenStr){
                maxLenStr= en.getValue();
                largestString = en.getKey();
            }
        }

        return largestString;
    }

    // Find largest word in a string ....Through normal for loop and simplet 
    static String findLargestStr(String s){
        StringBuilder temp = new StringBuilder();
        String largest = "";

        for(int i =0; i<s.length(); i++){

            char ch = s.charAt(i);

            if(ch != ' '){
                temp.append(ch);
            }else {
                if(temp.length()>0 && temp.length() > largest.length()){
                    largest = temp.toString();
                }  
                temp.setLength(0);  
            }
        }

        // check the last word 
        if(temp.length() > largest.length()){
            largest = temp.toString();
        }

        return largest;
    }

    // 20 queeeeeeeee
    // Write a program to sort characters in a string
    // static String sortCharacterInString(String s){

    //     char ChArr[] = s.toCharArray();
    //     for(int i=0; i<=ChArr.length-2; i++){
            
    //         int min = (int) ChArr[i];
    //         for(int j = i; j<=ChArr.length-1; j++){
    //             if((int) (ChArr[j]) < ChArr[min]){
    //                 min = (int) ChArr[j];
    //             }
    //         }

    //         // Swap 
    //         int temp = (char) min;
    //         ChArr[i]= arr[i]; 
    //         arr[i]= temp;


    //     }
    // }


    // Count number of words in a given string
    static int countNumberOfWordsInString(String s){
        if(s.length()==0){
            return 0;
        }
        int count =0;

        for(int i =0 ; i < s.length(); i++){
            char ch = s.charAt(i);

            // check where the word starts ... so if curr ch is not space and previos char was space so it will be word and if i==0 so it means it's first word so that also we need to count ..
            if(ch != ' ' && (i ==0 || s.charAt(i-1) == ' ')){
                count ++;
            }
        }

        return count;
    }

    // Write a program to find a word in a given string which has the highest number of repeated letters
    static int highestNumberOfRepeatedLetters(String s){
        Set<Character> st = new HashSet<>();
        int count =0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch !=' '){
                if(!st.contains(ch)){
                    st.add(ch);
                }else{
                    count ++;
                }
            }else{
                count =0;
            }

            
        }

        return -1;
    }
    
    // Change case of each character in a string
    static String changeCaseOfEachString(String s){
        StringBuilder newString = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isLowerCase(ch)){
                newString.append(Character.toUpperCase(ch));
            }else if(Character.isUpperCase(ch)){
                newString.append(Character.toLowerCase(ch));
            }else{
                // keep other character unchanged
                newString.append(ch);
            }
        }
        return newString.toString();
    }


    // Concatenate one string to another
    static String concatenateString(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s2);
        return sb.toString();
    }


    // Write a program to find a substring within a string. If found display its starting position
    static int findSubStringWithinAString(String s1, String s2){
        
        return -1;
    }

    // Reverse words in a string
    static String reverseStringInString(String s){
        Stack<String> st = new Stack<>();
        StringBuilder temp = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch != ' '){
                temp.append(ch);
            }else{
                st.add(temp.toString());
                temp.setLength(0);
            }
        }
        // add last word 
        if(temp.length()>0){
            st.add(temp.toString());
        }

        // Get the reversed order word in a String
        StringBuilder finalStr = new StringBuilder();
        while(!st.isEmpty()){
            finalStr.append(st.pop());
            // after adding if stack becomes empty then no need to add space .... so
            if(!st.isEmpty()){
                finalStr.append(" ");
            }
        }
        
        return finalStr.toString();
    }

    // SelectionSort
    static String selectionSort(int arr[]){
        for(int i=0; i<=arr.length-2; i++){

            int min = i;
            for(int j=i; j<=arr.length-1; j++){
                if(arr[j]< arr[min]){
                    min =j;
                }
            }

            int temp = arr[min];
            arr[min]= arr[i];
            arr[i]= temp;
        }

        return Arrays.toString(arr);
    }

    // ******************************************************************************************* //
    // Previous year question solving ............................************************..........
    // 1. Selection Sorting
    static String selectionSorting(int arr[]){

        for(int i=0; i<=arr.length-2; i++){
            int min = i;

            for(int j= i; j<=arr.length-1; i++){
                if(arr[j]<arr[min]){
                    min =j;
                }
            }

            // swap 
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        return Arrays.toString(arr);
    }

    // Given a String word, return true if the usage of capitals in it is right.
    static boolean checkUsageOfCapitalsBasedOnCondition(String s){

        // case 1 : All upercase
        if(s.equals(s.toUpperCase())){
            return true;
        }

        // case 2 : All lowercase
        if(s.equals(s.toLowerCase())){
            return true;
        }

        // case 3 : First letter capitals, rest is not capitals
        if(Character.isUpperCase(s.charAt(0)) && s.substring(1).equals(s.substring(1).toLowerCase())){
            return true;
        }


        return false;
    }

    // Return number of columns that you will delete
    static int minDeleteColumns(String [] strs){
        int deletionCount =0;

        for(int col =0; col<strs[0].length(); col++){
            for(int row =0; row<strs.length-1; row++){

                if(strs[row].charAt(col) > strs[row+1].charAt(col)){  // Wrong condition means not in lexicographical order so deletioncount will be incremented by 1.
                    deletionCount++;
                    break;
                }
            }
        }

        return deletionCount;
    }

    // Binary string is given .......find number Of Substring With All Char 1'ss
    static int numberOfSubstringWithAllChar1s(String s){

        int count =0;
        int result =0;

        for(char ch : s.toCharArray()){
            if(ch == '1'){
                count ++;
                result += count;
            }else{
                count=0;  // make it resset 
            }
        }
        return result;

    }

    // same abouve with formula     
    static int numberOfSubstringWithAll(String s){

        int count =0;
        int result =0;

        for(char ch : s.toCharArray()){
            if(ch == '1'){
                count ++;
            }else{
                result += count *(count +1)/2;
                count=0;  // make it resset 
            }
        }

        // check last one 
        if(count>0){
            result += count*(count +1)/2;
        }
        return result;

    }

    // A gym offers membership plans based on the number of months a customer wants to enroll.
    static String gymMembershipCost(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int months = sc.nextInt();

        if(months<=0){
            return "Invalid Input";
        }else if(months ==1){
            return "Cost: ₹2000";
        }else if(months>=2 && months<=3){
            return "Cost: ₹5000";
        }else if(months>=4 && months <=6){
            return "Cost: ₹9000";
        }

        return "Cost: ₹15000";
    }

    // Transaction Monitoring systems
    static void transactionManagementSystem(){

        // check duplicacy if sender and receiver is same in previous transcation 
        Set<String> seen = new HashSet<>();

        int prevTime = -1;

        Scanner sc = new Scanner(System.in);
        int n = 5 ;


        for(int i =0; i<n; i++){
            String sender = sc.next();
            String receiver = sc.next();
            int timestamp = sc.nextInt();
            int amount = sc.nextInt();

            // case 1: Dupplicate found 
            String key = sender + "-" + receiver;

            if(!seen.contains(key)){
                seen.add(key);
            }else{
                System.out.println("Error: Duplicate Transaction");
                return;
            }


            // case 2: Fraud case 
            if(prevTime!=-1 && (timestamp-prevTime) > 60 ){
                System.out.println("Fraud Detected");
                return;
            }

            // update prevtrans
            prevTime = timestamp;

            
            
        }

        // Else we are saying all transactions are valid
        System.out.println("All Transactions Valid");
        sc.close();
    }

    // Maximum subset with limit maxsum 
    static int maxSubArrSub(int arr[], int idx, int curr, int max){

        // base case 1 
        if(curr>max){
            return 0;
        }

        // base case 2
        if(idx== arr.length){
            return curr;
        }

        int inc = maxSubArrSub(arr, idx+1, curr+ arr[idx], max);

        int exc = maxSubArrSub(arr, idx+1, curr, max);


        return Math.max(inc, exc);

    }




    public static void main(String[] args) {

        int arr[] = {2,3,5,7};

        System.out.println(maxSubArrSub(arr, 0, 0, 10));
        // transactionManagementSystem();

        // System.out.println(gymMembershipCost());

        // System.out.println(numberOfSubstringWithAllChar1s("01101111"));
        // System.out.println(numberOfSubstringWithAll("00110001111"));
        // System.out.println(checkUsageOfCapitalsBasedOnCondition("gfdhdU"));
        // String strs[] = {"abc", "bca", "cee"};
        // System.out.println(minDeleteColumns(strs));
        // // System.out.println(checkPalindromeString("NITIN", 0));
        // countVowelsConsonantesSpace("TAKE U FORWARD IS AWESOME");
        // char c = 'A';
        // System.out.println(findASCIIValue('D'));
        // System.out.println(removeVowels("TAKE U FORWARD IS AWESOME"));
        // System.out.println(removeSpace("TAKE U FORWARD IS AWESOME"));
        // System.out.println(removeCharacterExceptAlphabets("take12% *&u ^$#forward"));
        // System.out.println(reverseString("I am iron man")); 
        // System.out.println(removeBrackets("a+((b-c)+d)"));
        // System.out.println(sumOfNumbersInString("123xyz2s5"));
        // System.out.println(capitalizeFirstAndLastLetter("hello world example"));
        // countFreqOfAllChar("programming");
        // countFreq("programming");
        // nonRepeatingCharInString("yahoo");
        // nonRepeatingch("yahoo");
        // System.out.println(checkIfAnagramsOfEachOther("cat", "act"));
        // System.out.println(maximumCharacterInString("takeuforward"));
        // System.out.println(removeAllDuplicates("bcabefcccc"));
        // printAllDuplicateCharInString("sinstriiintng");
        // printDuplicate("sinstriiintng");
        // System.out.println(removeCharacterFromFirstStringPersentInSecond("abzcdef", "cebbbfz"));
        // System.out.println(changeEveryLetterWithNextLexicographicAlph("abcdxyz"));
        // String st = "this is somethign differrent";
        // System.out.println(findLargestWordInString(st));
        // System.out.println(findLargestStr(st));
        // System.out.println(countNumberOfWordsInString("this      is"));
        // System.out.println(changeCaseOfEachString("jAVA"));
        // System.out.println(reverseStringInString("This side Shivam"));
    
        // int arr[] = {23,43,52,2,-2,78,56,4,2};
        // System.out.println(selectionSort(arr));
    }
}
