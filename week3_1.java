import java.util.Scanner;
public class week3_1
{
	public static void main(String args[])
	{
		String strarr[];
		String inputString="";
		Scanner scan=new Scanner(System.in);
		System.out.println("�п�J�@�榳���I�Ÿ����^��:");
		inputString=scan.nextLine();		
		inputString=inputString.toLowerCase();		
		strarr=inputString.split("[ ,.:;]+");
		for(String s:strarr)
		{
			System.out.println(s);
		}
	}
}
