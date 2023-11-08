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
    public static final String RE_INPUT = "다시 입력해주세요. : ";

    public int validatePurchase(String money) {
        while (true) {
            try {
                validateNumberType(money);
                int purchase = validateDivision(money);
                validateAmount(purchase);
                return purchase;
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
                money = reInput();
            }
        }
    }

    private void validateNumberType(String input) throws NumberFormatException {
        if (!checkPattern.matcher(input).matches()) {
            throwNumFormatExceptionMessage(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private void validateAmount(int number) throws ArithmeticException {
        if (number == ZERO) {
            throwAriExceptionMessage(ExceptionMessage.IS_NOT_ZERO.getMessage());
        }
    }

    private int validateDivision(String input) throws ArithmeticException {
        int purchase = Integer.parseInt(input);
        if (purchase % PURCHASE_AMOUNT_COND.getNumber() != ZERO) {
            throwAriExceptionMessage(ExceptionMessage.PURCHASE_ERROR.getMessage());
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
            } catch (IllegalArgumentException | IllegalStateException e) {
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
            throwArgExceptionMessage(ExceptionMessage.COUNT_ERROR.getMessage());
        }
    }

    private void validateBlank(List<String> inputNums) throws IllegalArgumentException {
        boolean hasBlank = inputNums.stream()
                .anyMatch(s -> s == null || s.trim().isEmpty() || s.contains(" "));

        if (hasBlank) {
            throwArgExceptionMessage(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    private void validateDuplicate(List<String> inputNums) throws IllegalStateException {
        if (inputNums.stream().distinct().count() != MAX_COUNT.getNumber()) {
            throwStateExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
        List<Integer> numbers = StringToInteger(inputNums);
        if (numbers.stream().distinct().count() != MAX_COUNT.getNumber()) {
            throwStateExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private List<Integer> StringToInteger(List<String> inputs) {
        List<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            int number = isValidNumber(input);
            numbers.add(number);
        }
        return numbers;
    }

    private List<Integer> validateLottoRange(List<String> inputNums) throws NumberFormatException {
        List<Integer> inputIntList = new ArrayList<>();
        for (String inputNum : inputNums) {
            try {
                int number = Integer.parseInt(inputNum);
                isValidRangeNumber(number);
                inputIntList.add(number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return inputIntList;
    }


    private void isValidRangeNumber(int num) throws IllegalArgumentException {
        if (num < FIRST_NUMBER.getNumber() || num > LAST_NUMBER.getNumber()) {
            throwArgExceptionMessage(ExceptionMessage.NUMBER_RANGE.getMessage());
        }
    }

    private int isValidNumber(String input) throws NumberFormatException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private void isExistedNumber(int bonus, List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.contains(bonus)) {
            throwArgExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private void throwArgExceptionMessage(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);
    }

    private void throwNumFormatExceptionMessage(String errorMessage) {
        throw new NumberFormatException(errorMessage);
    }

    private void throwAriExceptionMessage(String errorMessage) {
        throw new ArithmeticException(errorMessage);
    }

    private void throwStateExceptionMessage(String errorMessage) {
        throw new IllegalStateException(errorMessage);
    }

    private String reInput() {
        System.out.print(RE_INPUT);
        return inputUtil.getInput();
    }
}
