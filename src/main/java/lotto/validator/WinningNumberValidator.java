package lotto.validator;

import lotto.constant.Constant;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoNumConstant;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningNumberValidator extends Validator {
    private static final Pattern VALID_LOTTO_NUMBER_REGEXP = Pattern.compile("[0-9]+");

    @Override
    public void validate(String winningNumber) {
        validateEmptyInput(winningNumber);
        validateSeparator(winningNumber);
        validateInvalidWinningNumbers(winningNumber);
        validateWinningNumber(parsingWinningNumber(winningNumber));
    }

    private void validateSeparator(String winningNumber) {
        if (!winningNumber.contains(Constant.NUMBER_SEPARATOR.getMessage())) {
            throw new IllegalArgumentException(ErrorMessage.SEPARATOR_ERROR.getMessage());
        }
    }

    private void validateInvalidWinningNumbers(String winningNumber) {
        String[] winningLottoNumbers = winningNumber.split(Constant.NUMBER_SEPARATOR.getMessage());
        for (String winningNumberStr : winningLottoNumbers) {
            if (!isValidWinningNumber(winningNumberStr)) {
                throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR.getMessage());
            }
        }
    }

    private boolean isValidWinningNumber(String lottoNumber) {
        Matcher matcher = VALID_LOTTO_NUMBER_REGEXP.matcher(lottoNumber);
        return matcher.matches();
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        validateWinningLottoNumber(winningNumbers);
        validateWinningNumberBound(winningNumbers);
        validateDupleWinningNumber(winningNumbers);
    }

    private List<Integer> parsingWinningNumber(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(Constant.NUMBER_SEPARATOR.getMessage()))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateWinningNumberBound(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> !isValidNumberBound(number))) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_BOUND_ERROR.getMessage());
        }
    }

    private boolean isValidNumberBound(int winningNumber) {
        if (winningNumber < LottoNumConstant.MIN_LOTTO_NUMBER_BOUND.getValue() || winningNumber > LottoNumConstant.MAX_LOTTO_NUMBER_BOUND.getValue()) {
            return false;
        }
        return true;
    }

    private void validateWinningLottoNumber(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoNumConstant.VALID_LOTTO_NUMBER_NUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NUM_ERROR.getMessage());
        }
    }

    private void validateDupleWinningNumber(List<Integer> winningNumbers) {
        if (countNotDupleLottoNumber(winningNumbers) != LottoNumConstant.VALID_LOTTO_NUMBER_NUM.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLE_NUM_ERROR.getMessage());
        }
    }

    private int countNotDupleLottoNumber(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().distinct().count();
    }
}
