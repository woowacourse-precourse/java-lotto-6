package lotto.Exceptions;

import java.util.*;

import lotto.Utils.*;

public class Exceptions{
	
	public void Number_Check(String input) {
		List<String> Number = Arrays.asList(input.split("Units.Lotto_Length.Delimiter()"));
		if(Number.size()!=6){
			//error
		}
		
		
	}
}