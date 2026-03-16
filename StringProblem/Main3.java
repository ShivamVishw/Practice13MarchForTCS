package StringProblem;

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

    // Sum of the numbers in a String
    



    public static void main(String[] args) {
        System.out.println(checkPalindromeString("NITIN", 0));
        countVowelsConsonantesSpace("TAKE U FORWARD IS AWESOME");
        char c = 'A';
        System.out.println(findASCIIValue('D'));
        System.out.println(removeVowels("TAKE U FORWARD IS AWESOME"));
        System.out.println(removeSpace("TAKE U FORWARD IS AWESOME"));
        System.out.println(removeCharacterExceptAlphabets("take12% *&u ^$#forward"));
        System.out.println(reverseString("I am iron man")); 
        System.out.println(removeBrackets("a+((b-c)+d)"));
    }
}
