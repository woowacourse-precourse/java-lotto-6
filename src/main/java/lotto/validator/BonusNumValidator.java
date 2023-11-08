package lotto.validator;

import java.util.List;

public class BonusNumValidator {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NOT_NUMBER_ERROR_MESSAGE = " 숫자만 입력해 주세요.";
    private static final String ONE_NUMBER_ERROR_MESSAGE = " 한 개의 숫자만 입력해 주세요.";
    private static final String RANGE_OVER_MESSAGE = " 1~45사이의 번호를 입력해 주세요.";
    private static final String NULL_ERROR_MESSAGE = " 보너스 번호를 입력해 주세요.";
    private static final String DUPLICATE_ERROR_MESSAGE = " 당첨 숫자들과 다른 숫자를 입력해 주세요.";

    public BonusNumValidator(String number, List<Integer> winningNum) {
        isNull(number);
        isOneNumber(number);
        isNumError(number);
        isRangeOver(number);
        isDuplicate(number, winningNum);
    }

    public void isNull(String number) {
        if (number.equals("")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NULL_ERROR_MESSAGE);
        }
    }

    private void isOneNumber(String number) {
        if (number.split(",").length != 1) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ONE_NUMBER_ERROR_MESSAGE);
        }
    }

    public void isNumError(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void isRangeOver(String number) {
        if (Integer.parseInt(number) > MAX_NUM || Integer.parseInt(number) < MIN_NUM) {
            throw new IllegalArgumentException(ERROR_MESSAGE + RANGE_OVER_MESSAGE);
        }
    }

    public void isDuplicate(String number, List<Integer> winningNum) {
        if (winningNum.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(ERROR_MESSAGE + DUPLICATE_ERROR_MESSAGE);
        }
    }
}
