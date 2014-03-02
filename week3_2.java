import java.util.*;
public class week3_2//這裡要打檔名
{
	public static void main(String args[])
	{
		HashMap<Integer,String> hashMapName=new HashMap<Integer,String>();
		//用來儲存學生姓名
		
		HashMap<Integer,String> hashMapScore=new HashMap<Integer,String>();	
		//用來儲存學生分數
		
		Scanner scan=new Scanner(System.in);		
		int sel,count=1,id;
		String score,name;//name,score分別用來暫存學生姓名和分數
		while(true)
		{
			System.out.print("1)輸入資料 2)查詢 3)離開:");
			sel=scan.nextInt();
			if(sel<1 || sel>3)
				System.out.println("\nERROR!!!\n");
			if(sel==1)
			{
				name=scan.nextLine();	
				System.out.print("請輸入學生"+count+"的姓名:");				
				name=scan.nextLine();	
				System.out.print("請輸入學生"+count+"的分數:");
				score=scan.nextLine();	
				hashMapName.put(count,name);//將輸入的姓名丟到HASHMAP裡
				hashMapScore.put(count,score);//將輸入的分數丟到HASHMAP裡
				count++;
			}
			else if(sel==2)
			{
				System.out.print("請輸入學生ID: ");
				id=scan.nextInt();
				if(hashMapName.containsKey(id))
				{
					System.out.println("姓名: "+hashMapName.get(id));
					System.out.println("分數: "+hashMapScore.get(id)\n);
				}
				else
					System.out.println("找不到該有ID的學生!\n\n");
			}
			else if(sel==3)
			{
				return ;
			}
		}
	}
}