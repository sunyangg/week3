import java.util.*;
import java.io.*;
public class week3_3//�o�̭n���ɦW
{
	public static void main(String args[]) throws IOException
	{
		HashMap<Integer,Token> hashMap=new HashMap<Integer,Token>();
		//�Ψ��x�s�^�媺���Φr��

		//--------Ū�g�ɮשҨϥΪ�����
		FileReader fr;
		FileWriter fw;
		BufferedReader bfr;
		BufferedWriter bfw;
		//-------------------------
		Scanner scan=new Scanner(System.in);		
		int sel,key=1,i;//key�Ψӷ�hashMap�������
		String inputString="";
		String strarr[],s;
		Token t;//�۩w�q�����O
		
		//-------------�o�̬OŪ�ɪ�����
		fr=new FileReader("week3_3.txt");
		bfr=new BufferedReader(fr);
		while((s=bfr.readLine())!=null)
		{
			strarr=s.split("[ ,.:;]+");
			t=new Token(strarr[0]);
			t.count=Integer.parseInt(strarr[1]);
			hashMap.put(key,t);
			key++;
			
			System.out.println("�r��: "+t.text+"����: "+t.count);
		}
		fr.close();
		//---------------------------------------------------
		
		while(true)
		{
			System.out.print("1)��J��� 2)�d�� 3)���}:");
			sel=scan.nextInt();
			if(sel<1 || sel>3)
				System.out.println("\nERROR!!!\n");
			if(sel==1)
			{				
				//-------------�r�ꪺ��J�P����
				inputString=scan.nextLine();
				System.out.println("�п�J�@�榳���I�Ÿ����^��:");
				inputString=scan.nextLine();		
				inputString=inputString.toLowerCase();		
				strarr=inputString.split("[ ,.:;]+");
				//--------------------------------------
				
				for(String str:strarr)
				{					
					for(i=1;i<=hashMap.size();i++)//�P�_�O�_�X�{�L
					{
						if(hashMap.get(i).text.equals(str))
						{
							hashMap.get(i).count++;
							break;
						}
					}
					if(i>hashMap.size())//�Y�S�X�{�L�h�[�J��HASHMAP
					{						
						t=new Token(str);
						t.count++;
						hashMap.put(key,t);
						key++;
					}
				}
			}
			else if(sel==2)
			{
				s=scan.nextLine();
				System.out.print("�п�J�Q���Ϊ��r��:");
				s=scan.nextLine();
				for(i=1;i<=hashMap.size();i++)
				{
					if(hashMap.get(i).text.equals(s))
					{
						System.out.println("�r��:"+hashMap.get(i).text+"\n�X�{����:"+hashMap.get(i).count+"\n");
						break;
					}
				}
				if(i>hashMap.size())
				{
					System.out.println("\n�d�L�r��"+s+"!!!\n");
				}
			}
			else if(sel==3)
			{
				//----------------�o�̬O�g�J�ɮת�����
				fw=new FileWriter("week3_3.txt");
				bfw=new BufferedWriter(fw);
				for(i=1;i<=hashMap.size();i++)
				{
					bfw.write(hashMap.get(i).text+" "+hashMap.get(i).count);
					bfw.newLine();
				}
				bfw.flush();
				fw.close();
				//------------------------------------
				
				return ;
			}
		}		
	}
}
class Token
{
	String text;
	int count=0;
	Token(String text)
	{
		this.text=text;		
	}
}