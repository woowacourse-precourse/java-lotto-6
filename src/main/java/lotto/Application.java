package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
public class Application {
	public void check1(int number)
	{
		if(number%1000!=0)
		{
			throw new IllegalArgumentException("구매가격이 1000으로 나누어 떨어져야합니다.");
		}
	}
	public void check2(String lottonumber)
	{
		if(!lottonumber.contains(","))
		{
			throw new IllegalArgumentException(",로 파싱되어야합니다.");
		}
	}
	
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    	Application exception=new Application();
    	System.out.println("구입금액을 입력해 주세요.");
    	String price=Console.readLine();
   	 int lottoprice=Integer.parseInt(price);
    	
    	while(lottoprice%1000!=0)
    	{
    		
    		try {
    			exception.check1(lottoprice);
    		}catch(IllegalArgumentException e) {
    			System.out.println("[ERROR] "+e.getMessage());
    			System.out.println("구입금액을 입력해 주세요.");
    			price=Console.readLine();
           	 lottoprice=Integer.parseInt(price);
    		}
    	}
    	int n=lottoprice/1000;
    	System.out.println();
    	System.out.println(n+"개를 구매했습니다.");
    	//List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    	Lotto[] lottoarray=new Lotto[n];
    	for(int i=0; i<n; i++)
    	{
    		List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    		Collections.sort(numbers);
    		lottoarray[i]=new Lotto(numbers);
    		System.out.println(numbers);
    	}
    	
    	System.out.println("\n당첨 번호를 입력해 주세요.");
    	String temp=Console.readLine();
    	while(!temp.contains(","))
    	{
    		try {
    			exception.check2(temp);
    			
    		}
    		catch(IllegalArgumentException e) {
    			System.out.println("[ERROR] "+e.getMessage());
    			System.out.println("\n당첨 번호를 입력해 주세요.");
    			 temp=Console.readLine();
    	}
    	}
    	String[] temp_arr=temp.split(",");
    	 int[] winningnumbers = new int[temp_arr.length+1];
         for (int i = 0; i < temp_arr.length; i++) {
             winningnumbers[i] = Integer.parseInt(temp_arr[i]);
         }
    	System.out.println("\n보너스 번호를 입력해 주세요.");
    	String bonus=Console.readLine();
    	int bonusnumber=Integer.parseInt(bonus);
    	long [] winning=new long  [5];
    	winningnumbers[temp_arr.length]=bonusnumber;
    	for(int i=0; i<n; i++)
    	{
    		int result=0;
    		result=lottoarray[i].check(winningnumbers);
    		if(result==3)
    		{
    			winning[0]+=1;
    		}
    		if(result==4)
    		{
    			winning[1]+=1;
    		}
    		if(result==5)
    		{
    			winning[2]+=1;
    		}
    		if(result==7)
    		{
    			winning[3]+=1;
    		}
    		if(result==6)
    		{
    			winning[4]+=1;
    		}
    		
    		
    		
    		
    	}
    	String statistics="당첨 통계\n"+"---\n"+"3개 일치 (5,000원) - "+winning[0]+"개\n"+"4개 일치 (50,000원) - "+winning[1]+"개\n"+"5개 일치 (1,500,000원) - "+
    	winning[2]+"개\n"+"5개 일치, 보너스 볼 일치 (30,000,000원) - "+winning[3]+"개\n"+"6개 일치 (2,000,000,000원) - "+winning[4]+"개\n";
    	System.out.println(statistics);
    	long income=0;
    	income=winning[0]*5000+winning[1]*50000+winning[2]*1500000+winning[3]*30000000+winning[4]*2000000000;
    	double finalresult=(double)income/lottoprice;
    	System.out.println("총 수익률은 "+100*finalresult+"%입니다.");
    	
    }
}
