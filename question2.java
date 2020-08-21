/*java program to replace given words in a paragraph as happy->h**** (both paragraph and words are taken input from user)   */
import java.util.*;
public class WordReplacer 
{
	public static void replace(String[] para,int n1,String[] words,int n2)
	{
		for(int i=0;i<n2;i++)
		{
			for(int j=0;j<n1;j++)
			{
				if(words[i].equals(para[j]))
				{
					String temp=para[j].substring(0,1);
					for(int k=1;k<para[j].length();k++)
						temp=temp+'*';
				    para[j]=temp;
				}
			}
		}
	}
    public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String[] para=new String[1000000];
		System.out.print("Enter the paragraph and terminate the input by entering $$: ");
		String s=sc.next();
		int i=0;
		while(s.charAt(0) != '$' && s.charAt(1) != '$')
		{   
			para[i]=s;
			s=sc.next();
			i++;
		}
		String[] words=new String[1000000];
		System.out.print("Enter the words to be replaced and terminate the input by entering $$: ");
		String temp=sc.next();
		int j=0;
		while(temp.charAt(0) != '$' && temp.charAt(1) != '$')
		{   
			words[j]=temp;
			temp=sc.next();
			j++;
		}
		replace(para,i,words,j);
		System.out.println("Changed paragraph is: ");
		for(int k=0;k<i;k++)
		{
			System.out.print(para[k]+" ");
		}
	}
}

