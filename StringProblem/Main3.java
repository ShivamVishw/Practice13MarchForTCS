package StringProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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



    public static void main(String[] args) {
        // System.out.println(checkPalindromeString("NITIN", 0));
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
        System.out.println(removeCharacterFromFirstStringPersentInSecond("abzcdef", "cebbbfz"));
    }
}
