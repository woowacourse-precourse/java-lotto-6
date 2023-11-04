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
    private static final int ZERO = 0;
    private static final Pattern checkPattern = Pattern.compile("[0-9]+");

    public int validatePurchase(String money) {
        validateNumberType(money);
        return validateDivision(money);
    }

    private void validateNumberType (String input) {
        if(checkPattern.matcher(input).matches()){
            throwExceptionMessage(ExceptionMessage.IS_NOT_NUMBER.getMessage());
        }
    }

    private int validateDivision (String input) {
        int purchase = Integer.parseInt(input);
        if (purchase%PURCHASE_AMOUNT_COND.getNumber()!=ZERO){
            throwExceptionMessage(ExceptionMessage.PURCHASE_ERROR.getMessage());
        }
        return purchase;
    }

    public List<Integer> validateWinningNumber(String input) {
        List<String> LottoWinningNumber = Arrays.asList(input.split(",",-1));
        validateCount(LottoWinningNumber);
        validateBlank(LottoWinningNumber);
        validateDuplicate(LottoWinningNumber);
        return validateLottoRange(LottoWinningNumber);
    }

    private void validateCount(List<String> inputs) {
        if (inputs.size() != MAX_COUNT.getNumber()) {
            throwExceptionMessage(ExceptionMessage.COUNT_ERROR.getMessage());
        }
    }

    private void validateBlank(List<String> inputNums) {
        boolean hasBlank = inputNums.stream()
                .anyMatch(s -> s == null || s.trim().isEmpty() || s.contains(" "));

        if (hasBlank) {
            throwExceptionMessage(ExceptionMessage.NUMBER_BLANK.getMessage());
        }
    }

    private void validateDuplicate(List<String> inputNums) {
        if (inputNums.stream().distinct().count() != MAX_COUNT.getNumber()) {
            throwExceptionMessage(ExceptionMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private List<Integer> validateLottoRange(List<String> inputNums) {
        List<Integer> inputIntList = new ArrayList<>();
        for (String inputNum : inputNums) {
            int number = isValidNumber(inputNum);
            inputIntList.add(number);
        }
        return inputIntList;
    }

    private int isValidNumber(String number) {
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

    private void throwExceptionMessage(String errorMessage){
        throw new IllegalArgumentException(errorMessage);
    }

}
