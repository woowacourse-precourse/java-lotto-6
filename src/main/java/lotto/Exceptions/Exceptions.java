package lotto.Exceptions;

import java.util.*;

import lotto.Utils.*;

public class Exceptions{
	
	public static boolean Number_Count_Valid(String input,Exception e) {
		List<String> Number = Arrays.asList(input.split(Units.Lotto_Length.Delimiter()));
		if(Number.size()!=Units.Lotto_Length.Unit()){
			System.out.println(ErrorMessage.Lotto_Number_Count_Error.Message()+ e.getMessage());
			return true;
		}
		return false;
	}
	
	public static boolean Numbers_Range_Valid(List<Integer> input,Exception e) {
		if(Collections.max(input)>Units.Lotto_Max_Number.Unit() || Collections.min(input)<Units.Lotto_Min_Number.Unit()) {
			System.out.println(ErrorMessage.Lotto_Number_Range_Error.Message()+ e.getMessage());
			return true;
		}
		return false;
	}
	
	public static boolean Numbers_Redundant(List<Integer> input,Exception e) {
		if(input.size() != input.stream().distinct().count()) {
			System.out.println(ErrorMessage.Lotto_Number_Redundant_Error.Message()+ e.getMessage());
			return true;
		}
		return false;
	}
	
	public static boolean Budget_Range_Valid(Integer input) {
		System.out.println("3");
		if(input%1000!=0) {
			throw new IllegalArgumentException(ErrorMessage.Input_Min_Budget_Range_Error.Message());
		}
		return true;
	}
	public static boolean Budget_Positive_Error(Integer input) {
		System.out.println("4");
		if(input<0 ) {
			System.out.println(ErrorMessage.Input_Positive_Budget_Error.Message());
			return false;
		}
		return true;
	}
	
	public static boolean Number_Range_Valid(Integer input,Exception e) {
		if(input>Units.Lotto_Max_Number.Unit() || input<Units.Lotto_Min_Number.Unit()) {
			System.out.println(ErrorMessage.Lotto_Number_Range_Error.Message()+ e.getMessage());
			return false;
		}
		return true;
	}

	public static boolean Input_Valid_Number(String input,Exception e) {
		System.out.println("2");
		try {
			Integer.parseInt(input);
		} catch(Exception e1){
			System.out.println(ErrorMessage.Input_Invalid_Number_Error.Message()+ e1.getMessage());
			return true;
		}
		return false;
	}
	
	public static boolean Input_Void(String input,Exception e) {
		System.out.println("1");
		if(input.isBlank()) {
			System.out.println(ErrorMessage.Input_Void_Error.Message()+ e.getMessage());
			return true;
		}
		return false;
	}
}