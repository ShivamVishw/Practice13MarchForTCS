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



    public static void main(String[] args) {
        System.out.println(checkPalindromeString("NITIN", 0));
        countVowelsConsonantesSpace("TAKE U FORWARD IS AWESOME");
    }
}
