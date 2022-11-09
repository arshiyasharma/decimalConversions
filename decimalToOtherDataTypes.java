package conversions;

//Arshiya Sharma F554 PreSc-A
//16th July 2022
//program to convert decimal to binary, octal or hexadecimal
import java.util.Scanner;
public class decimalToOtherDataTypes
{
    int input;
    byte base;
    int toBinaryOrOctal(int dec)
    {
        int finalvalue=0;
        for(int pos=0;dec!=0;pos++)
        {
            finalvalue+=dec%base*Math.pow(10,pos);
            dec/=base;
        }
        return finalvalue;
    }
    String toHexadecimal(int dec)
    {
        int value=0;
        String finalvalue="";
        for(int pos=0;dec!=0;pos++)
        {
            int rem=dec%base;
            if(rem>9)
                finalvalue+=value+(char)(rem+55);      
            else
                finalvalue+=value;
            value=rem*(int)Math.pow(10,pos);
            dec/=base;
        }
        return finalvalue;
    }
    void menu()
    {
        Scanner as=new Scanner(System.in);
        System.out.println("Enter the base of the number you want to convert to:\n2-Binary\n8-Octal\n16-Hexa Decimal\n\nPRESS 0 TO QUIT");
        base=as.nextByte();
        switch(base)
        {
            case 0:
                System.out.println("good bye!");
                System.exit(0);
            case 2:
                System.out.print("Enter the number:");
                int n=as.nextInt();
                System.out.println("Decimal to binary:"+toBinaryOrOctal(n));
                break;
            case 8:
                System.out.print("Enter the number:");
                n=as.nextInt();
                System.out.println("Decimal to octal:"+toBinaryOrOctal(n));
                break;
            case 16:
                System.out.print("Enter the number:");
                n=as.nextInt();
                System.out.println("Hexa Decimal equivalent of the number is:"+toHexadecimal(n));
                break;
            default:
                System.out.println("Wrong Input! Please try again!");
            }
    }
    public static void main(String[]ar)
    {
        decimalToOtherDataTypes obj=new decimalToOtherDataTypes();
        obj.menu();
    }
}