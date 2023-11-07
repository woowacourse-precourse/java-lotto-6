package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Lotto 
{
    private final List<Integer> numbers;
    private Boolean[] check = new Boolean[46];
    Prints p = new Prints();
    
    
    public Lotto(List<Integer> numbers) 
    {
        validate(numbers);
        duplicationNum(numbers);
        this.numbers = numbers;
    }
    
    public int getLotsNum(int i)
    {
    	return numbers.get(i);
    }
    
    public void printNumbers()
    {
    	System.out.print(p.printLotStart);
    	for(int i = 0; i < numbers.size(); i++)
    	{
    		System.out.print(numbers.get(i));
    		if(i != numbers.size()-1)
    		{
    			System.out.print(p.printLotSpace);
    		}
    	}
    	System.out.println(p.printLotEnd);
    }


    private void validate(List<Integer> numbers) 
    {
        if (numbers.size() != 6) 
        {
        	System.out.println(p.ErrMsgOverBound);
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < numbers.size(); i++)
        {
        	if(i < 1 && i > 45)
        	{
        		System.out.println(p.ErrMsgOverRange);
        		throw new IllegalArgumentException();
        	}
        }
    }
    private void duplicationNum(List<Integer> numbers)
    {
    	for(int i = 0; i < check.length; i++)
    	{
    		check[i] = false;
    	}
    	for(int i = 0; i < numbers.size(); i++)
    	{
    		if(check[numbers.get(i)])
    		{
    			System.out.println(p.ErrMsgDuplicationRange);
                throw new IllegalArgumentException();
    		}
    		check[numbers.get(i)] = true;
    	}
    }
}
