package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import lotto.domain.Lotto;
import lotto.io.InputViewReader;
import lotto.util.message.ErrorMessage;
import lotto.util.validator.Validator;

public class InputView {

	public static final Pattern NUMBER_FORMAT = Pattern.compile("^-?\\d+$");
	public static final Pattern INPUT_ANSWER_LOTTO_NUMBERS_FORMAT =
			Pattern.compile("^" + "-?\\d+,".repeat(Lotto.LOTTO_SIZE - 1) + "-?\\d+$");
	public static final String NUMBERS_DELIMITER = ",";

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

		validateAnswerLottoNumbers(inputValue);

		String[] separtedInputValue = inputValue.split(NUMBERS_DELIMITER);

		return convertStrArrToCollection(separtedInputValue);
	}

	public int inputBonusNumber() {
		String inputValue = reader.readLine();

		validateInputBonusNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	private void validateInputMoney(String inputValue) {
		validateisNumberFormat(inputValue);
	}

	private void validateAnswerLottoNumbers(String inputValue) {
		Validator.validateIsEmpty(inputValue, ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
		validateInputAnswerLottoNumbersFormat(inputValue);
	}

	private void validateInputAnswerLottoNumbersFormat(String inputValue) {
		Validator.validateSpecificFormat(INPUT_ANSWER_LOTTO_NUMBERS_FORMAT, inputValue,
				ErrorMessage.INPUT_ANSWER_LOTTO_NUMBER_ERROR
						.getFormattedMessage(NUMBERS_DELIMITER, Lotto.LOTTO_SIZE));
	}

	private List<Integer> convertStrArrToCollection(String[] strArr) {
		return Arrays.stream(strArr).map(Integer::valueOf).toList();
	}

	private void validateInputBonusNumber(String inputValue) {
		validateisNumberFormat(inputValue);
	}

	private void validateisNumberFormat(String inputValue) {
		Validator.validateIsEmpty(inputValue, ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
		Validator.validateSpecificFormat(NUMBER_FORMAT, inputValue, ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}
}