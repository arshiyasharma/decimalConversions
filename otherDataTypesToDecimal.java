package conversions;

//Arshiya Sharma F554 PreSc-A
//program to convert binary, octal or hexadecimal to decimal
import java.util.*;
public class otherDataTypesToDecimal
{
    byte base=1;
    String num,output;
    Scanner as=new Scanner(System.in);
    void menu()
    {
        while(base!=0)
        {
            System.out.println("\n\nEnter the base of the number you want to convert:\n2-Binary\n8-Octal\n16-Hexa Decimal\n\nPRESS 0 TO QUIT");
            base=as.nextByte();
            switch(base)
            {
                case 0:
                    System.out.println("good bye!");
                    break;
                case 2:
                    System.out.println("Binary to Decimal:"+fromBinary());
                    break;
                case 8:
                    fromOctal();
                    break;
                case 16:
                    System.out.println("Enter the hexadeecimal number:");
                    num=as.next();
                    System.out.println("Decimal equivalent of  the number is:"+fromHexadecimal(num));
                    break;
                default:
                    System.out.println("\nWrong Input, try again:");
            }
        }
    }
    int fromBinary()
    {
        System.out.println("Enter the Binary number:");
        num=as.next();
        int binin=Integer.parseInt(num), binout=0;
        for(int num=binin,pos=0;num>0;num/=10)
        {
            int digit=num%10;
            binout+=digit*Math.pow(base,pos++);
        }
        return binout;
    }
    void fromOctal()  
    {
        System.out.println("Enter the Octal number:");
        num=as.next();
        int octin=Integer.parseInt(num), octout=0;
        for(int number=octin,pos=0;number>0;number/=10)
        {
            int digit=number%10;
            octout+=digit*Math.pow(base,pos++);
        }
        System.out.println("Octal to Decimal:"+octout);
    }
    int fromHexadecimal(String num)
    {
        String hexin=num.toUpperCase();
        int hexout=0;
        for(int i=0,pow=hexin.length()-1;i<hexin.length();i++,pow--)
        {
            char ch=hexin.charAt(i);
            int chartoint=0;
            if(Character.isDigit(ch))
                chartoint=(int)ch-48;
            else if(Character.isLetter(ch))
                chartoint=(int)ch-55;
            hexout+=chartoint*(int)Math.pow(base,pow);
        }
        return hexout;
    }
    public static void main(String[]args)
    {
        otherDataTypesToDecimal obj=new otherDataTypesToDecimal();
        obj.menu();
    }
}