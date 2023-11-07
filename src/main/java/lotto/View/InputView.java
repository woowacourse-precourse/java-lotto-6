package lotto.View;

import lotto.Utils.*;
import lotto.Exceptions.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class InputView{
	
	public static int Input_Budget() {
		String input = Console.readLine();
		Integer budget;
		Exceptions.Input_Void(input);
		Exceptions.Input_Valid_Number(input);
		System.out.println(input);
		budget = Integer.parseInt(input);
		Exceptions.Budget_Range_Valid(budget);
		Exceptions.Budget_Positive_Error(budget);
		return budget;
	}
	
	public static List<Integer> Lotto_Number() {
		String input = Console.readLine();
		Exceptions.Input_Void(input);
		Exceptions.Input_Valid_Number(input);
		Exceptions.Number_Count_Valid(input);
		//Validate_Lotto_Number(input);
		List<Integer> Lotto_Number = Parse.List_Int(input);
		Exceptions.Numbers_Range_Valid(Lotto_Number);
		Exceptions.Numbers_Redundant(Lotto_Number);
		
		return Lotto_Number;
	}
	
	public static int Lotto_Bonus_Number(List<Integer> Lotto_Number) {
		String input = Console.readLine();
		Integer bonus;
		
		Exceptions.Input_Void(input);
		Exceptions.Input_Valid_Number(input);
		//Validate_Bonus_Number(input);
		bonus = Integer.parseInt(input);
		Lotto_Number.add(bonus);
		Exceptions.Number_Range_Valid(bonus);
		Exceptions.Numbers_Redundant(Lotto_Number);
		return bonus;
	}
}