package lotto.readInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class InputNumbers {
	public static List<Integer> winningNumbers() {
		String input = read();
		try {
			ErrorValidation.validateWinningNumbersFormat(input);
			List<Integer> winningNumbers = new ArrayList<>();
			winningNumbers = Stream.of(input.split(",")).map(Integer::parseInt).toList();
			ErrorValidation.validateWinningNumbers(winningNumbers);
			return winningNumbers;
		} catch (IllegalArgumentException e) {
			printErrorMessage(e.getMessage());
			return winningNumbers();
		}
	}
	
	public static String read() {
		return Console.readLine();
	}
	
	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
