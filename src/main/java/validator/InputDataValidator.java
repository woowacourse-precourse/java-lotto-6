package validator;

import enums.Constants;
import enums.Message;
import java.util.Arrays;
import java.util.regex.Pattern;


public class InputDataValidator {

    public void validLottoCostInput(String data) {
        validIntegerInput(data);
        isDivideBy1000(data);
    }

    public void validWinningNumberInput(String[] data) {
        validWinningNumberSize(data);
        validMaxMinWinningNumber(data);
        validDuplicateWinningNumber(data);
        for (String singleWinningNum : data) {
            validIntegerInput(singleWinningNum);
        }
    }

    public void validBonusNumberInput(String data, String[] splitWinningData) {
        validMaxMinBonusNumber(data);
        validDuplicateBonusNumberWithWinningNumber(data, splitWinningData);
        validIntegerInput(data);
    }

    public void validIntegerInput(String data) {
        isNull(data);
        isNumeric(data);
    }

    public void isNull(String data) {
        if (data == null) {
            throw new NullPointerException();
        }
    }

    public void isNumeric(String data) {
        if (!Pattern.matches(Message.NUMERIC_REGEX.getMessage(), data)) {
            throw new IllegalArgumentException();
        }
    }

    public void isDivideBy1000(String data) {
        if (Integer.parseInt(data) % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validWinningNumberSize(String[] data) {
        int size = Constants.LOTTO_NUMBER_SIZE;
        if (data.length != size) {
            throw new IllegalArgumentException();
        }
    }

    public void validMaxMinWinningNumber(String[] data) {
        for (String number : data) {
            if (Integer.parseInt(number) > Constants.MAX_LOTTO_NUMBER
                || Integer.parseInt(number) < Constants.MIN_LOTTO_NUMBER) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validDuplicateWinningNumber(String[] data) {
        if (data.length != Arrays.stream(data).distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    public void validMaxMinBonusNumber(String data) {
        if (Integer.parseInt(data) > Constants.MAX_LOTTO_NUMBER
            || Integer.parseInt(data) < Constants.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void validDuplicateBonusNumberWithWinningNumber(String data, String[] splitWinningData) {
        for (String winningNumber : splitWinningData) {
            if (winningNumber.equals(data)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
