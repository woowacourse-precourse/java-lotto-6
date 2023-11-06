package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validate;
import java.util.*;

public class InputData {
	public static int playerFinance() {
		int inputData =0;
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				inputData = Integer.parseInt(Console.readLine());
				Validate.minimumAmount(inputData);//최소금액검사
				Validate.thousandMultiple(inputData);//1000단위인지
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return inputData;
	}
	private static List<Integer> parseIntegers(String str){
		List<Integer> numberList = new ArrayList<>();
		for(String num : str.split(",")) numberList.add(Integer.parseInt(num));
		return numberList;
	}
	
	public static List<Integer> winningNumber(){
		List<Integer> winningNumber = new ArrayList<>();
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				String inputData = Console.readLine();
				Validate.validateFormat(inputData);
				Validate.numberInRange(inputData);
				Validate.validSixNumberInput(inputData);
				winningNumber = parseIntegers(inputData);
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return winningNumber;
	}
	
	public static int bonusNumber() {
		int bonusNumber = 0;
		boolean isValidInput = false;
		while(!isValidInput){
			try {
				String inputData = Console.readLine();
				Validate.numericInput(inputData);
				bonusNumber = Integer.parseInt(inputData);
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return bonusNumber;
	}
	
}
