package lotto;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    public int check(int[] num) {
    	int cnt=0;
    	boolean[] flagHolder = new boolean[1];
    	for(int i=0; i<this.numbers.size(); i++)
    	{
    		cnt+=check2(num,i,flagHolder);
    	}
    	if(cnt==6&&flagHolder[0]==true)
    	{
    		cnt++;
    	}//bonusball 맞춘 경우cnt==7
    	
    	 
    	return cnt;
    }
    public int check2(int[] num,int index,boolean[] flag)
    {
    	int cnt=0;
    	
    	for(int j=0; j<num.length; j++)
		{
			if(check3(num[j],this.numbers.get(index))==1&&j!=num.length-1)
			{
				cnt++;
			}
			if(check3(num[j],this.numbers.get(index))==1&&j==num.length-1)
			{
				flag[0]=true;
				cnt++;
			}
		}
    	
    	return cnt;
    }
    public int check3(int a, int b)
    {
    	if(a==b)
    	{
    		return 1;
    	}
    	return 0;
    }
    // TODO: 추가 기능 구현
}
