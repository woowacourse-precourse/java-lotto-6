package lotto.view;

import java.util.Arrays;
import java.util.List;

import lotto.domain.Lotto;
import lotto.io.InputViewReader;
import lotto.util.message.ErrorMessage;
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
		
		validateAnswerLottoNumbers(separatedNumbers);
		
		return Arrays.stream(separatedNumbers).map(Integer::valueOf)
						.toList();
	}

	public int inputBonusNumber() {
		String inputValue = READER.readLine();

		validateInputNumber(inputValue);

		return Integer.parseInt(inputValue);
	}

	private void validateInputNumber(String inputValue) {
		Validator.validateIsEmpty(inputValue, ErrorMessage.INPUT_EMPTY_ERROR.getMessage());
		Validator.validateNumberFormat(inputValue, ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}

	private void validateAnswerLottoNumbers(String[] separatedNumbers) {
		Validator.validateStrArrLength(separatedNumbers, Lotto.LOTTO_SIZE, 
					ErrorMessage.INPUT_ANSWER_LOTTO_NUMBER_ERROR.getForMatMessage(Lotto.LOTTO_SIZE));

		for (String number : separatedNumbers) {
			Validator.validateNumberFormat(number, ErrorMessage.INPUT_LETTER_ERROR.getMessage());
		}
	}
}
