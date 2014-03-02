import java.util.*;
import java.io.*;
public class week3_3//這裡要打檔名
{
	public static void main(String args[]) throws IOException
	{
		HashMap<Integer,Token> hashMap=new HashMap<Integer,Token>();
		//用來儲存英文的分割字串

		//--------讀寫檔案所使用的物件
		FileReader fr;
		FileWriter fw;
		BufferedReader bfr;
		BufferedWriter bfw;
		//-------------------------
		Scanner scan=new Scanner(System.in);		
		int sel,key=1,i;//key用來當hashMap的關鍵值
		String inputString="";
		String strarr[],s;
		Token t;//自定義的類別
		
		//-------------這裡是讀檔的部分
		fr=new FileReader("week3_3.txt");
		bfr=new BufferedReader(fr);
		while((s=bfr.readLine())!=null)
		{
			strarr=s.split("[ ,.:;]+");
			t=new Token(strarr[0]);
			t.count=Integer.parseInt(strarr[1]);
			hashMap.put(key,t);
			key++;
			
			System.out.println("字串: "+t.text+"次數: "+t.count);
		}
		fr.close();
		//---------------------------------------------------
		
		while(true)
		{
			System.out.print("1)輸入資料 2)查詢 3)離開:");
			sel=scan.nextInt();
			if(sel<1 || sel>3)
				System.out.println("\nERROR!!!\n");
			if(sel==1)
			{				
				//-------------字串的輸入與分割
				inputString=scan.nextLine();
				System.out.println("請輸入一行有標點符號的英文:");
				inputString=scan.nextLine();		
				inputString=inputString.toLowerCase();		
				strarr=inputString.split("[ ,.:;]+");
				//--------------------------------------
				
				for(String str:strarr)
				{					
					for(i=1;i<=hashMap.size();i++)//判斷是否出現過
					{
						if(hashMap.get(i).text.equals(str))
						{
							hashMap.get(i).count++;
							break;
						}
					}
					if(i>hashMap.size())//若沒出現過則加入到HASHMAP
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
				System.out.print("請輸入被分割的字串:");
				s=scan.nextLine();
				for(i=1;i<=hashMap.size();i++)
				{
					if(hashMap.get(i).text.equals(s))
					{
						System.out.println("字串:"+hashMap.get(i).text+"\n出現次數:"+hashMap.get(i).count+"\n");
						break;
					}
				}
				if(i>hashMap.size())
				{
					System.out.println("\n查無字串"+s+"!!!\n");
				}
			}
			else if(sel==3)
			{
				//----------------這裡是寫入檔案的部分
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