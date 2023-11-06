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
	
	public static List<Integer> winningNumber(){
		List<Integer> winningNumber = new ArrayList<>();
		String inputData = "";
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				inputData = Console.readLine();
				Validate.validSixNumberInput(inputData);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return winningNumber;
	}
	
}
