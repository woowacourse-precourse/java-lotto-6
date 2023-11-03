package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.io.InputViewReader;
import lotto.util.validator.Validator;

public class InputView {

	private static final InputViewReader READER = new InputViewReader();
	private static final String DELIMITER = ",";

	public int inputMoney() {
		String inputValue = READER.readLine();

		validateInputNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	public List<Integer> inputAnswerLottoNumbers() {
		String inputValue = READER.readLine();

		String[] separatedNumbers = inputValue.split(DELIMITER);

		return Arrays.stream(separatedNumbers).map(Integer::new)
						.toList();
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
