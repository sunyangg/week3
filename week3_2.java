import java.util.*;
public class week3_2//�o�̭n���ɦW
{
	public static void main(String args[])
	{
		HashMap<Integer,String> hashMapName=new HashMap<Integer,String>();
		//�Ψ��x�s�ǥͩm�W
		
		HashMap<Integer,String> hashMapScore=new HashMap<Integer,String>();	
		//�Ψ��x�s�ǥͤ���
		
		Scanner scan=new Scanner(System.in);		
		int sel,count=1,id;
		String score,name;//name,score���O�ΨӼȦs�ǥͩm�W�M����
		while(true)
		{
			System.out.print("1)��J��� 2)�d�� 3)���}:");
			sel=scan.nextInt();
			if(sel<1 || sel>3)
				System.out.println("\nERROR!!!\n");
			if(sel==1)
			{
				name=scan.nextLine();	
				System.out.print("�п�J�ǥ�"+count+"���m�W:");				
				name=scan.nextLine();	
				System.out.print("�п�J�ǥ�"+count+"������:");
				score=scan.nextLine();	
				hashMapName.put(count,name);//�N��J���m�W���HASHMAP��
				hashMapScore.put(count,score);//�N��J�����ƥ��HASHMAP��
				count++;
			}
			else if(sel==2)
			{
				System.out.print("�п�J�ǥ�ID: ");
				id=scan.nextInt();
				if(hashMapName.containsKey(id))
				{
					System.out.println("�m�W: "+hashMapName.get(id));
					System.out.println("����: "+hashMapScore.get(id)\n);
				}
				else
					System.out.println("�䤣��Ӧ�ID���ǥ�!\n\n");
			}
			else if(sel==3)
			{
				return ;
			}
		}
	}
}