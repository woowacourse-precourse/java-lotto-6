package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.io.InputViewReader;
import lotto.util.message.ErrorMessage;
import lotto.util.validator.Validator;

public class InputView {

	private static final String DELIMITER = ",";

	private final InputViewReader reader;

	public InputView() {
		reader = new InputViewReader();
	}

	public int inputMoney() {
		String inputValue = reader.readLine();

		validateInputMoney(inputValue);

		return Integer.parseInt(inputValue);
	}

	public List<Integer> inputAnswerLottoNumbers() {
		String inputValue = reader.readLine();
		String[] inputValues = inputValue.split(DELIMITER);

		validateAnswerLottoNumbers(inputValues);

		return convertStrArrToCollection(inputValues);
	}

	public int inputBonusNumber() {
		String inputValue = reader.readLine();

		validateInputBonusNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	private void validateInputMoney(String inputValue) {
		validateisNumberFormat(inputValue);
	}

	private void validateAnswerLottoNumbers(String[] inputValues) {
		for (String inputValue : inputValues) {
			validateisNumberFormat(inputValue);
		}
	}

	private List<Integer> convertStrArrToCollection(String[] strArr) {
		return Arrays.stream(strArr).map(Integer::valueOf).toList();
	}

	private void validateInputBonusNumber(String inputValue) {
		validateisNumberFormat(inputValue);
	}

	private void validateisNumberFormat(String inputValue) {
		Validator.validateIsEmpty(inputValue, ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
		Validator.validateNumberFormat(inputValue, ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}
}
