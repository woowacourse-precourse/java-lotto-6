package lotto.util;

import static lotto.constant.LottoNumber.FIRST_NUMBER;
import static lotto.constant.LottoNumber.LAST_NUMBER;
import static lotto.constant.LottoNumber.MAX_COUNT;
import static lotto.constant.LottoNumber.PURCHASE_AMOUNT_COND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.constant.message.ExceptionMessage;

public class ValidationUtil {
    private final InputUtil inputUtil = new InputUtil();
    private static final int ZERO = 0;
    private static final Pattern checkPattern = Pattern.compile("[0-9]+");

    public int validatePurchase(String money) {
        while (true) {
            try {
                validateNumberType(money);
                return validateDivision(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                money = reInput();
            }
        }
    }

    private void validateNumberType(String input) throws IllegalArgumentException {
        if (!checkPattern.matcher(input).matches()) {
            throwExceptionMessage(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private int validateDivision(String input) throws IllegalArgumentException {
        int purchase = Integer.parseInt(input);
        if (purchase % PURCHASE_AMOUNT_COND.getNumber() != ZERO) {
            throwExceptionMessage(ExceptionMessage.PURCHASE_ERROR.getMessage());
        }
        return purchase;
    }

    public List<Integer> validateWinningNumber(String input) {
        while (true) {
            try {
                List<String> LottoWinningNumber = Arrays.asList(input.split(",", -1));
                validateBlank(LottoWinningNumber);
                validateCount(LottoWinningNumber);
                validateDuplicate(LottoWinningNumber);
                return validateLottoRange(LottoWinningNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                input = reInput();
            }
        }
    }

    public int validateWinningNumberWithBonus(String bonus, List<Integer> lotto) {
        while (true) {
            try {
                int bonusNumber = isValidNumber(bonus);
                isExistedNumber(bonusNumber, lotto);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonus = reInput();
            }
        }
    }

    private void validateCount(List<String> inputs) throws IllegalArgumentException {
        if (inputs.size() != MAX_COUNT.getNumber()) {
            throwExceptionMessage(ExceptionMessage.COUNT_ERROR.getMessage());
        }
    }

    private void validateBlank(List<String> inputNums) throws IllegalArgumentException {
        boolean hasBlank = inputNums.stream()
                .anyMatch(s -> s == null || s.trim().isEmpty() || s.contains(" "));

        if (hasBlank) {
            throwExceptionMessage(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    private void validateDuplicate(List<String> inputNums) throws IllegalArgumentException {
        if (inputNums.stream().distinct().count() != MAX_COUNT.getNumber()) {
            throwExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
        List<Integer> numbers = StringToInteger(inputNums);
        if (numbers.stream().distinct().count() != MAX_COUNT.getNumber()) {
            throwExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private List<Integer> StringToInteger(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            int number = Integer.parseInt(input);
            numbers.add(number);
        }
        return numbers;
    }

    private List<Integer> validateLottoRange(List<String> inputNums) throws IllegalArgumentException {
        List<Integer> inputIntList = new ArrayList<>();
        for (String inputNum : inputNums) {
            int number = isValidNumber(inputNum);
            inputIntList.add(number);
        }
        return inputIntList;
    }

    private int isValidNumber(String number) throws IllegalArgumentException {
        try {
            int num = Integer.parseInt(number);
            if (num < FIRST_NUMBER.getNumber() || num > LAST_NUMBER.getNumber()) {
                throwExceptionMessage(ExceptionMessage.NUMBER_RANGE.getMessage());
            }
            return num;
        } catch (NumberFormatException e) {
            throwExceptionMessage(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
        return -1;
    }

    private void isExistedNumber(int bonus, List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.contains(bonus)) {
            throwExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private void throwExceptionMessage(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    private String reInput() {
        String reInputMessage = "다시 입력해주세요.";
        System.out.println(reInputMessage);
        return inputUtil.getInput();
    }
}
