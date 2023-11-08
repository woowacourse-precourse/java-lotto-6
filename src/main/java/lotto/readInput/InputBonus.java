package lotto.readInput;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class InputBonus {
	public static int bonusNumber(List<Integer> winningNumbers) {
		String input = read();
		try {
			ErrorValidation.validateBonus(input, winningNumbers);
			return Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return bonusNumber(winningNumbers);
		}
	}
	
	public static String read() {
		return Console.readLine();
	}
	
	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
