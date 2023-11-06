package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constans.ErrorMessage;
import lotto.io.OutputView;

public class User {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    public int inputWantBuyAmount(String wantBuyAmount) {
        int wantBuyAmountToInt = validateIsNumber(wantBuyAmount);
        validateWantBuyAmount(wantBuyAmountToInt);

        return wantBuyAmountToInt;
    }

    public List<Integer> inputWinningNumber(String winningNumber) {
        validateWinningNumberIsNumber(winningNumber);
        validateWinningNumberLength(winningNumber);
        validateWinningNumberRange(winningNumber);
        validateWinningNumberIsDuplicated(winningNumber);

        return Arrays.stream(winningNumber.split(",")).map(Integer::parseInt).toList();
    }

    public int inputBonusNumber(String bonusNumber, List<Integer> winningNumber) {
        validateIsNumber(bonusNumber);
        validateNumberRange(bonusNumber);
        validateBonusNumberContainWinningNumber(winningNumber,bonusNumber);

        return Integer.parseInt(bonusNumber);
    }

    private void validateWinningNumberIsNumber(String winningNumber) {
        String[] split = winningNumber.split(",");

        for (String s : split) {
            validateIsNumber(s);
        }
    }

    private void validateWantBuyAmount(int wantBuyAmount) {
        if (wantBuyAmount % 1000 != 0) {
            OutputView.printMessage(ErrorMessage.WANT_BUY_AMOUNT_EXCEPTION.getMessage());
            throw new IllegalArgumentException(ErrorMessage.WANT_BUY_AMOUNT_EXCEPTION.getMessage());
        }
    }

    private void validateWinningNumberLength(String winningNumber) {
        if (winningNumber.split(",").length != 6) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_LENGTH_EXCEPTION.getMessage());
        }
    }

    private int validateIsNumber(String userInput) {
        if (!NUMBER_PATTERN.matcher(userInput).matches()) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMBER.getMessage());
        }

        return Integer.parseInt(userInput);
    }

    private void validateWinningNumberRange(String userInput) {
        String[] split = userInput.split(",");
        for (String s : split) {
            validateNumberRange(s);
        }
    }

    private void validateWinningNumberIsDuplicated(String userInput) {
        List<Integer> list = Arrays.stream(userInput.split(",")).map(Integer::parseInt).toList();
        for (Integer i : list) {
            if (Collections.frequency(list, i) > 1) {
                throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATED_EXCEPTION.getMessage());
            }
        }
    }

    private void validateNumberRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    private void validateBonusNumberContainWinningNumber(List<Integer> winningNumber, String bonusNumber) {
        if (winningNumber.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_IS_CONTAIN_WINNING_NUMBER.getMessage());
        }
    }
}
