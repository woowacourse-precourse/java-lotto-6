package lotto.validator;

import lotto.constant.LottoValue;
import lotto.constant.Prize;

import java.util.Arrays;
import java.util.List;

public class InputValidator {

    public static StringBuilder sb = new StringBuilder(ErrorMessage.ERROR_MESSAGE_PREFIX);

    public static String validInputPurchaseAmount(String input) {
        initStringBuilder();
        if (isNumberFormat(input) && isUnit(input)) {
            return input;
        }
        throw new IllegalArgumentException(sb.toString());

    }

    public static String validInputWinningNumbers(String input) {
        initStringBuilder();
        if (isSixNumber(input) && isWinningRange(input)) {
            return input;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public static String validInputBonus(List<Integer> winningNumbers, String input) {
        initStringBuilder();
        if (isNumberFormat(input) && isContain(winningNumbers, input) && isRange(input)) {
            return input;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public static boolean isContain(List<Integer> winningNumbers, String input) {
        if (winningNumbers.contains(Integer.parseInt(input))) {
            sb.append(ErrorMessage.ERROR_WINNING_CONTAIN_BONUS);
            return false;
        }
        return true;
    }

    public static boolean isRange(String input) {
        if (LottoValue.MIN_RANGE_NUMBER > Integer.parseInt(input) || LottoValue.MAX_RANGE_NUMBER < Integer.parseInt(input)) {
            sb.append(ErrorMessage.ERROR_RANGE_LOTTO_NUMBER);
            return false;
        }
        return true;
    }

    public static boolean isNumberFormat(String input) {
        if (input.matches("[0-9]+")) {
            return true;
        }
        sb.append(ErrorMessage.ERROR_NOT_NUMERIC);
        return false;
    }

    public static boolean isUnit(String input) {
        if (Integer.parseInt(input) >= LottoValue.UNIT && Integer.parseInt(input) % LottoValue.UNIT == 0) {
            return true;
        }
        sb.append(ErrorMessage.ERROR_PURCHASE_AMOUNT_UNIT);
        return false;
    }

    public static boolean isSixNumber(String input) {
        List<String> numbers = Arrays.stream(input.split(",")).distinct().toList();
        if (numbers.size() == LottoValue.LOTTO_NUMBER_SIZE) {
            return true;
        }
        sb.append(ErrorMessage.ERROR_INPUT_SIX_LOTTO_NUMBER);
        return false;
    }

    public static boolean isWinningRange(String input) {
        List<String> numbers = Arrays.stream(input.split(",")).distinct().toList();
        for (String number : numbers) {
            if (!isNumberFormat(number) || !isRange(number)) {
                return false;
            }
        }
        return true;
    }

    public static void initStringBuilder() {
        sb = new StringBuilder(ErrorMessage.ERROR_MESSAGE_PREFIX);
    }
}
