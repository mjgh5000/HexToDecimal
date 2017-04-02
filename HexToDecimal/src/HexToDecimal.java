//Created by Matthew Hoinacki. Final version; 2017/25/03 @00:02. Initial Version; 2017/23/03 @??:??.
import java.util.Scanner;
public class HexToDecimal {
    private static String HexToBinary (String hexNum) {
        switch (hexNum.length()) {
            case 8:
                break;
            case 9:
                hexNum = hexNum.substring(0,4) + hexNum.substring(5,9);
                break;
            case 11:
                hexNum = hexNum.substring(0,2) + hexNum.substring(3,5) + hexNum.substring(6,8) + hexNum.substring(9,11);
                break;
            case 1:
                if (hexNum.equals("Q") || hexNum.equals("q")) {
                return hexNum; }
            default:
                return "error1";
        }
        String binNum = "";
        for (int i=0;i<8;i++) {
            String subString = hexNum.substring(i,i + 1);
            switch (subString) {
                case "F":
                case "f":
                    binNum += "1111";
                    break;
                case "E":
                case "e":
                    binNum += "1110";
                    break;
                case "D":
                case "d":
                    binNum += "1101";
                    break;
                case "C":
                case "c":
                    binNum += "1100";
                    break;
                case "B":
                case "b":
                    binNum += "1011";
                    break;
                case "A":
                case "a":
                    binNum += "1010";
                    break;
                case "9":
                    binNum += "1001";
                    break;
                case "8":
                    binNum += "1000";
                    break;
                case "7":
                    binNum += "0111";
                    break;
                case "6":
                    binNum += "0110";
                    break;
                case "5":
                    binNum += "0101";
                    break;
                case "4":
                    binNum += "0100";
                    break;
                case "3":
                    binNum += "0011";
                    break;
                case "2":
                    binNum += "0010";
                    break;
                case "1":
                    binNum += "0001";
                    break;
                case "0":
                    binNum += "0000";
                    break;
                default:
                    return "error2";
            }
            if (i%2==1&&i<7){
                binNum += " ";
            }
        }
        return binNum;
    }

    private static long BinaryToDec (String binNum) {
        int twoPow = 1073741824;
        long decNum = 0;
        String bigBoi = binNum.substring(0,1);
        if (bigBoi.equals("1")) {
            decNum += 2147483648L;
        }
        for (int i=1;i<32;i++) {
            String subString = binNum.substring(i + (i/8), i + 1 + (i/8));
            if (subString.equals("1")){
                decNum += twoPow;
            }
            twoPow = twoPow/2;
        }
        return decNum;
    }

    public static void main(String[] args) {
        Scanner uIn= new Scanner(System.in);
        String binNum;
        long decNum;
        System.out.println("(Accepted forms: XXXXXXXX, XXXX XXXX, or XX XX XX XX. Input is case insensitive)");
        System.out.print("Enter a hex string to be converted: ");
        while (true) {
            validInput:
            while (true) {
                binNum = HexToBinary(uIn.nextLine());
                switch (binNum) {
                    case "error1":
                        System.out.println("Make sure your input follows one of three accepted formats: XXXXXXXX, XXXX XXXX, or XX XX XX XX.");
                        break;
                    case "error2":
                        System.out.println("Make sure input is within hexadecimal value range: 0-9, A-F");
                        break;
                    case "Q":
                    case "q":
                        System.out.print("Goodbye.");
                        System.exit(0);
                        break;
                    default:
                        break validInput;
                }
            }
            System.out.println(binNum);
            decNum = BinaryToDec(binNum);
            System.out.println(decNum);
            System.out.print("Enter another hex to be converted, or send q to exit: ");
        }
    }
}