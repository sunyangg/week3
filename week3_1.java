import java.util.Scanner;
public class week3_1
{
	public static void main(String args[])
	{
		String strarr[];
		String inputString="";
		Scanner scan=new Scanner(System.in);
		System.out.println("請輸入一行有標點符號的英文:");
		inputString=scan.nextLine();		
		inputString=inputString.toLowerCase();		
		strarr=inputString.split("[ ,.:;]+");
		for(String s:strarr)
		{
			System.out.println(s);
		}
	}
}
