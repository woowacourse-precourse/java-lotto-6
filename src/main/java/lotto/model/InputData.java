package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validate;

public class InputData {
	public static int playerFinance() {
		int inputData =0;
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				inputData = Integer.parseInt(Console.readLine());
				Validate.isMinimumAmount(inputData);//최소금액검사
				Validate.isThousandMultiple(inputData);//1000단위인지
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return inputData;
	}
	
	
}
