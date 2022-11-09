package conversions;

//Arshiya Sharma F554 PreSc-A
//Program to convert fractional decimal to binary and hexadecimal
import java.util.*;
public class fractionalDecimalConversions
{
    double input;
    Scanner as=new Scanner(System.in);
    void input()
    {
        System.out.println("Enter a value:");
        input=as.nextDouble();
    }
    String toBinary(double dec)
    {
        int beforedec=0,bin1=0,bin2=0;
        double afterdec=0;
        beforedec=(int)dec;
        afterdec=dec-beforedec;
        for(int pos=0;beforedec!=0;pos++)
        {
            bin1+=beforedec%2*(int)Math.pow(10,pos);
            beforedec/=2;
        }
        for(int pos=0;afterdec!=0;pos++)
        {
            double product=2*afterdec;//multiplies the decimal value by 2 for conversion
            int answerDec=(int)product;
            afterdec=product-answerDec;
            bin2=answerDec+(bin2*(int)Math.pow(10,pos));
        }
        String result=bin1+"."+bin2;
        return result;
    }
    String toHexaD(double dec)
    {
        int beforedec=0,hex1=0,hex2=0;
        double afterdec=0;
        beforedec=(int)dec;
        afterdec=dec-beforedec;
        for(int pos=0;beforedec!=0;pos++)
        {
            hex1+=beforedec%16*(int)Math.pow(10,pos);
            beforedec/=16;
        }
        for(int pos=0;afterdec!=0;pos++)
        {
            double product=2*afterdec;//multiplies the decimal value by 2 for conversion
            int answerDec=(int)product;
            afterdec=product-answerDec;
            hex2=answerDec+(hex2*(int)Math.pow(10,pos));
        }
        String result=hex1+"."+hex2;
        return result;
    }
    void menu()
    {
        System.out.println("Enter your choice:\n1.Fractional Decimal to Binary\n2.Fractional Decimal to Hexadecimal");
        byte choice=as.nextByte();
        switch(choice)
        {
            case 1:
                input();
                System.out.println("Answer:"+toBinary(input));
                break;
            case 2:
                input();
                System.out.println("Answer:"+toHexaD(input));
                break;
            default:
                System.out.println("Wrong Input! Please try again!");
        }
    }
    public static void main(String[]ar)
    {
        fractionalDecimalConversions obj=new fractionalDecimalConversions();
        obj.menu();
    }
}