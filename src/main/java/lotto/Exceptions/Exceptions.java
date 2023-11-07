package lotto.Exceptions;

import java.util.*;

import lotto.Utils.*;

public class Exceptions{
	
	public static void Number_Count_Valid(String input) {
		List<String> Number = Arrays.asList(input.split(Units.Lotto_Length.Delimiter()));
		if(Number.size()!=Units.Lotto_Length.Unit()){
			throw new IllegalArgumentException(ErrorMessage.Lotto_Number_Count_Error.Message());
		}
	}
	
	public static void Numbers_Range_Valid(List<Integer> input) {
		if(Collections.max(input)>Units.Lotto_Max_Number.Unit() || Collections.min(input)<Units.Lotto_Min_Number.Unit()) {
			throw new IllegalArgumentException(ErrorMessage.Lotto_Number_Range_Error.Message());
		}
	}
	
	public static void Numbers_Redundant(List<Integer> input) {
		if(input.size() != input.stream().distinct().count()) {
			throw new IllegalArgumentException(ErrorMessage.Lotto_Number_Redundant_Error.Message());
		}
	}
	
	public static void Budget_Range_Valid(Integer input) {
		if(input%1000!=0) {
			throw new IllegalArgumentException(ErrorMessage.Input_Min_Budget_Range_Error.Message());
		}
	}
	public static void Budget_Positive_Error(Integer input) {
		if(input<0 ) {
			throw new IllegalArgumentException(ErrorMessage.Input_Positive_Budget_Error.Message());
		}
	}
	
	public static void Number_Range_Valid(Integer input) {
		if(input>Units.Lotto_Max_Number.Unit() || input<Units.Lotto_Min_Number.Unit()) {
			throw new IllegalArgumentException(ErrorMessage.Lotto_Number_Range_Error.Message());
		}
	}
	

	public static void Input_Valid_Number(String input) {
		try {
			Parse.List_Int(input);
		} catch(Exception e1){
			throw new IllegalArgumentException(ErrorMessage.Input_Invalid_Number_Error.Message());
		}
	}
	
	public static void Input_Void(String input) {
		if(input.isBlank()) {
			throw new IllegalArgumentException(ErrorMessage.Input_Void_Error.Message());
		}
	}
}