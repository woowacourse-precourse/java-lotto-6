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
            throwDivisionExceptionMessage(ExceptionMessage.IS_NOT_ZERO.getMessage());
        }
    }

    private int validateDivision(String input) throws ArithmeticException {
        int purchase = Integer.parseInt(input);
        if (purchase % PURCHASE_AMOUNT_COND.getNumber() != ZERO) {
            throwDivisionExceptionMessage(ExceptionMessage.PURCHASE_ERROR.getMessage());
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
            throwNumFormatExceptionMessage(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    private void validateDuplicate(List<String> inputNums) throws IllegalArgumentException {
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
                throwArgExceptionMessage(ExceptionMessage.NUMBER_RANGE.getMessage());
            }
            return num;
        } catch (NumberFormatException e) {
            throwNumFormatExceptionMessage(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
        return -1;
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

    private void throwDivisionExceptionMessage(String errorMessage) {
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
