package lotto.view;

import lotto.io.InputViewReader;
import lotto.util.validator.Validator;

public class InputView {

	private static final InputViewReader READER = new InputViewReader();

	public String inputMoney() {
		String inputValue = READER.readLine();

		validateInputNumber(inputValue);

		return inputValue;
	}

	public int inputAnswerLottoNumbers() {
		String inputValue = READER.readLine();

		validateInputNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	public int inputBonusNumber() {
		String inputValue = READER.readLine();

		validateInputNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	private void validateInputNumber(String inputValue) {
		Validator.validateIsEmpty(inputValue);
		Validator.validateNumberFormat(inputValue);
	}
}
