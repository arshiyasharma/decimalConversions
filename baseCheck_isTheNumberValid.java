package conversions;

//Arshiya Sharma F554 PreSc-A
//Program to check what base can the decimal be converted to and if its binary convert it to octal.
import java.util.Scanner;
public class baseCheck_isTheNumberValid
{
    String input;
    Scanner as=new Scanner(System.in);
    void input()
    {
        System.out.print("Enter a number:");
        input=as.next();
    }
    String findBase()
    {
        String finalanswer="";
        boolean ckBi = true; boolean ckDec = true;
        boolean ckOct = true; boolean ckHex = true;
        String num=input;
        for(int i=0;i<num.length();i++)
        {
            char ch=num.charAt(i);
            if(ch=='A'||ch=='B'||ch=='C'||ch=='D'||ch=='E'||ch=='F')
            {
                ckDec=false;
                ckBi=false;
                ckOct=false;
            }
           
            else if((int)ch>49)
            {
                ckBi=false;
                if((int)ch>56)
                {
                    ckOct=false;
                    if((int)ch>57)
                    {
                        ckDec=false;
                        if((int)ch>70)
                        {
                            ckHex=false;
                        }
                    }
                }
            }
        }
        if(ckBi==true)
        {
            finalanswer+="2";
            System.out.println("\nIf base was 2(binary number), its octal value would be="+toOctal(Integer.parseInt(num)));
        }
        if(ckOct==true)
        {
            finalanswer+=",8";
        }
        if(ckHex==true)
        {
            finalanswer+=",16";
        }
        if(ckDec==true)
        {
            finalanswer+=",10";
        }
        return finalanswer;
    }
    int toOctal(int bin)
    {
        int octalvalue=0;
        int p=0,mod=0,sum=0;
        while(bin>0)
        {
            mod=bin%1000;
            bin/=1000;
            for(int num=mod,pos=0;num>0;num/=10)
            {
                int digit=num%10;
                sum+=digit*Math.pow(2,pos++);
            }
            octalvalue+=sum*(int)Math.pow(10,p++);
            sum=0;
        }
        return octalvalue;
    }
    public static void main(String[]ar)
    {
        baseCheck_isTheNumberValid obj=new baseCheck_isTheNumberValid();
        obj.input();
        System.out.print("\nIts base can be:"+obj.findBase());
    }
}


/*
OUTPUT:
1.
Enter a number:111111111

If base was 2(binary number), its octal value would be=777

Its base can be:2,8,16,10

2.
Enter a number:345

Its base can be:,8,16,10
*/