import java.util.*;
public class Substring
{
  public static int count(String str,String t)
  {
	  int a[]=new int[256];
	  int b[]=new int[256];
	  for(int i=0;i<str.length();i++)
	  {   char c=str.charAt(i);
          int k=Character.getNumericValue(c);
		  a[k]++;
	  }
	  int count1=1,count2=1;
      for(int i=0;i<t.length();i++)
	  {   char c=t.charAt(i);
          int k=Character.getNumericValue(c);
		  b[k]++;
	  }
	  for(int i=0;i<t.length();i++)
	  {   
          char c=t.charAt(i);
          int k=Character.getNumericValue(c);
		  count1=count1*a[k];
		  count2=count2*b[k];
	  }
	  return (count1/count2);
  }
  public static void main(String [] args)
  {
    System.out.print("Enter a word(string): ");
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	System.out.print("Enter substring that is to be found: ");
	String t=sc.next();
	System.out.print("No. of occurrence "+count(str,t));
  }
}