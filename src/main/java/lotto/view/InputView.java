package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.util.Parser;

public class InputView {
	private static final String INPUT_LOTTO_AMOUNT = "구입금액을 입력해 주세요.";
	private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
	private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

	public int inputAmount() {
		printInstructions(INPUT_LOTTO_AMOUNT);
		String userInput = readLine();
		return Parser.parseInteger(userInput);
	}

	public List<Integer> inputWinningNumbers() {
		printInstructions(INPUT_WINNING_NUMBERS);
		String userInput = readLine();
		return Parser.parseWinningNumber(userInput);
	}

	public int inputBonusNumber() {
		printInstructions(INPUT_BONUS_NUMBER);
		String userInput = readLine();
		return Parser.parseInteger(userInput);
	}

	private void printInstructions(String instruction) {
		System.out.println(instruction);
	}
}
