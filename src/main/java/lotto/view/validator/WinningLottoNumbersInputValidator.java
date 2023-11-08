package lotto.view.validator;

import java.util.Arrays;
import lotto.constant.LottoConstant;
import lotto.view.constant.InputConstant;
import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class WinningLottoNumbersInputValidator {
    public void validate(final String winningLottoNumbers) {
        isNotEmpty(winningLottoNumbers);
        containsDelimiter(winningLottoNumbers);
        containsSixNumbers(winningLottoNumbers);
        isEachNumberNumeric(winningLottoNumbers);
        isEachNumberNotEmpty(winningLottoNumbers);
        isEachNumberNotExceedInputRange(winningLottoNumbers);
    }

    private void isNotEmpty(final String winningLottoNumbers) {
        if (winningLottoNumbers.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }

    private void containsDelimiter(final String winningLottoNumbers) {
        if (!winningLottoNumbers.contains(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_DELIMITER);
        }
    }

    private void containsSixNumbers(final String winningLottoNumbers) {
        if (!dividedIntoSixNumbers(winningLottoNumbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_DOES_NOT_CONTAIN_SIX_NUMBERS);
        }
    }

    private boolean dividedIntoSixNumbers(final String winningLottoNumbers) {
        return splitNumbersWithDelimiter(winningLottoNumbers).length
                == LottoConstant.LOTTO_ITEM_COUNT.getValue();
    }

    private void isEachNumberNumeric(final String winningLottoNumbers) {
        String[] lottoNumbers = splitNumbersWithDelimiter(winningLottoNumbers);
        for (String lottoNumber : lottoNumbers) {
            throwExceptionIfNotNumeric(lottoNumber);
        }
    }

    private void throwExceptionIfNotNumeric(final String lottoNumber) {
        try {
            Long.parseLong(lottoNumber);
        } catch (NumberFormatException e) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBER_IS_NOT_NUMERIC_TYPE);
        }
    }

    private void isEachNumberNotEmpty(final String winningLottoNumbers) {
        String[] lottoNumbers = splitNumbersWithDelimiter(winningLottoNumbers);
        if (isMoreThanOneNumberEmpty(lottoNumbers)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_CONTAINS_EMPTY_NUMBER);
        }
    }

    private boolean isMoreThanOneNumberEmpty(final String[] lottoNumbers) {
        return Arrays.stream(lottoNumbers)
                .anyMatch(String::isEmpty);
    }

    private void isEachNumberNotExceedInputRange(final String winningLottoNumbers) {
        Arrays.stream(splitNumbersWithDelimiter(winningLottoNumbers))
                .forEach(this::throwExceptionIfExceedInputRange);
    }

    private void throwExceptionIfExceedInputRange(final String lottoNumber) {
        if (exceedInputRange(lottoNumber)) {
            throw LottoInputException.of(LottoInputExceptionMessage.WINNING_LOTTO_NUMBERS_INPUT_EXCEED_INPUT_RANGE);
        }
    }

    private boolean exceedInputRange(final String lottoNumber) {
        return Long.parseLong(lottoNumber) > Integer.MAX_VALUE || Long.parseLong(lottoNumber) < Integer.MIN_VALUE;
    }

    private String[] splitNumbersWithDelimiter(final String winningLottoNumbers) {
        return winningLottoNumbers.split(InputConstant.WINNING_LOTTO_NUMBERS_DELIMITER);
    }
}