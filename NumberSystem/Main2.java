
public class Main2 {
    
    // Convert Binary to Decimal
    static int binaryToDecimal(int binary){

        int decimal = 0;
        int power = 0;

        while(binary>0){
            // get last digit 
            int digit = binary %10;
            decimal = decimal + digit* (int)Math.pow(2, power);

            binary = binary /10;
            power ++;
        }

        return decimal;
    }


    public static void main(String[] args) {
        System.out.println(binaryToDecimal(11001));
        
    }


}
