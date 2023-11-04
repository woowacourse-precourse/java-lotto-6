package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validate;

public class InputData {
	public static int playerFinace() {
		int inputData =0;
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				inputData = Integer.parseInt(Console.readLine());
				Validate.isThousandMultiple(inputData);
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return inputData;
	}
	
	
}
