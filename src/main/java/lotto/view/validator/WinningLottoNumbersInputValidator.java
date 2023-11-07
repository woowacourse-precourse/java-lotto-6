package lotto.view.validator;

import java.util.Arrays;
import lotto.domain.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class WinningLottoNumbersInputValidator {

    public void validate(String winningLottoNumbers) {
        isNotEmpty(winningLottoNumbers);
        containsDelimiter(winningLottoNumbers);
        containsSixNumbers(winningLottoNumbers);
        isEachNumberNotEmpty(winningLottoNumbers);
        isEachNumberNotExceedInputRange(winningLottoNumbers);
        isNotEndWithDelimiter(winningLottoNumbers);
    }

    private void isNotEmpty(String winningLottoNumbers) {
        if (winningLottoNumbers.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void containsDelimiter(String winningLottoNumbers) {
        if (!winningLottoNumbers.contains(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_DELIMITER);
        }
    }

    private void containsSixNumbers(String winningLottoNumbers) {
        if (!dividedIntoSixNumbers(winningLottoNumbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_SIX_NUMBERS);
        }
    }

    private boolean dividedIntoSixNumbers(String winningLottoNumbers) {
        return splitNumbersWithDelimiter(winningLottoNumbers).length
                == LottoConstant.LOTTO_ITEM_COUNT.getValue();
    }

    private void isEachNumberNotEmpty(String winningLottoNumbers) {
        String[] numbers = splitNumbersWithDelimiter(winningLottoNumbers);
        if (isMoreThanOneNumberEmpty(numbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_CONTAINS_EMPTY_NUMBER);
        }
    }

    private boolean isMoreThanOneNumberEmpty(String[] numbers) {
        return Arrays.stream(numbers)
                .anyMatch(String::isEmpty);
    }

    private void isEachNumberNotExceedInputRange(String winningLottoNumbers) {
        Arrays.stream(splitNumbersWithDelimiter(winningLottoNumbers))
                .forEach(this::throwExceptionIfExceedInputRange);
    }

    private void throwExceptionIfExceedInputRange(String number) {
        if (exceedInputRange(number)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_INPUT_EXCEED_INPUT_RANGE);
        }
    }

    private boolean exceedInputRange(String number) {
        return Long.parseLong(number) > Integer.MAX_VALUE || Long.parseLong(number) < Integer.MIN_VALUE;
    }


    private void isNotEndWithDelimiter(String winningLottoNumbers) {
        if (winningLottoNumbers.endsWith(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_ENDS_WITH_DELIMITER);
        }
    }

    private String[] splitNumbersWithDelimiter(String winningLottoNumbers) {
        return winningLottoNumbers.split(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER);
    }
}