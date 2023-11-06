package lotto.View;

import lotto.Utils.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputView{
	
	private static int Input_Budget() {
		String input = Console.readLine();
		//Validate_Budget(input);
		return Integer.parseInt(input);
	}
	
	private static List<Integer> Lotto_Number() {
		String input = Console.readLine();
		//Validate_Lotto_Number(input);
		List<Integer> Lotto_Number = Parse.List_Int(input);
		
		return Lotto_Number;
	}
	
	private static int Lotto_Bonus_Number() {
		String input = Console.readLine();
		//Validate_Bonus_Number(input);
		
		return Integer.parseInt(input);
	}
}