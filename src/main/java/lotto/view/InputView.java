package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.util.InputValidator;

import java.util.Arrays;
import java.util.List;

public class InputView {
	private final OutputView outputView;

	public InputView(OutputView outputView) {
		this.outputView = outputView;
	}

	public int inputPrice() {
		String input;

		while (true) {
			try {
				outputView.printPriceInputMessage();
				input = Console.readLine();
				InputValidator.validatePrice(input);
				break;
			} catch (IllegalArgumentException exception) {
				outputView.printErrorMessage(exception);
			}
		}

		return Integer.parseInt(input);
	}

	public List<Integer> inputNumbers() {
		String input;

		while (true) {
			try {
				outputView.printNumbersInputMessage();
				input = Console.readLine();
				InputValidator.validateNumbers(input);
				break;
			} catch (IllegalArgumentException exception) {
				outputView.printErrorMessage(exception);
			}
		}

		return Arrays.stream(input.split(","))
					 .map(Integer::parseInt).toList();
	}

	public int inputBonusNumber() {
		String input;

		while (true) {
			try {
				outputView.printBonusNumberInputMessage();
				input = Console.readLine();
				InputValidator.validateBonusNumber(input);
				break;
			} catch (IllegalArgumentException exception) {
				outputView.printErrorMessage(exception);
			}
		}

		return Integer.parseInt(input);
	}
}