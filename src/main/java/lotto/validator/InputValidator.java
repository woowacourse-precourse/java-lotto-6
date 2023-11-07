package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.util.TypeConversionUtil.StringToInt;
import static lotto.util.TypeConversionUtil.StringToIntegerList;

public class InputValidator {

    private static final String DIGIT_VALIDATE_REGEX = "-?[0-9]+";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "^[0-9,]+$";
    private static final int CORRECT_WINNER_NUMBER_SIZE = 6;
    private static final String NOT_DIGIT_ERROR_MESSAGE = "숫자로 이루어져야 합니다.";
    private static final String CAN_NOT_DIVIDE_BY_THOUSAND_ERROR_MESSAGE = "구매금액은 1000단위로 입력해야 합니다.";
    private static final String WRONG_TYPE_ERROR_MESSAGE = "형식에 맞게 입력해 주세요. ex) 1,2,3,4,5,6";
    private static final String NOT_CORRECT_SIZE_ERROR_MESSAGE = "숫자 6개를 입력해 주세요.";
    private static final String NOT_CORRECT_RANGE_SIZE_ERROR_MESSAGE = "1~45 사이의 값을 입력해 주세요.";
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "중복 되지 않는 값을 입력해 주세요.";
    private static final int NUMBER_MIN_RANGE = 1;
    private static final int NUMBER_MAX_RANGE = 45;
    private static final int CORRECT_SIZE = 6;
    private static final int THOUSAND_VALUE = 1000;
    private static final int ZERO_VALUE = 0;

    public void validatePurchaseMoney(String inputPurchaseMoney) {
        if (isNotDigit(inputPurchaseMoney)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_DIGIT_ERROR_MESSAGE);
        }
        if (isWrongNumberCanNotDivideByThousand(inputPurchaseMoney)) {
            throw new IllegalArgumentException(ERROR_PREFIX + CAN_NOT_DIVIDE_BY_THOUSAND_ERROR_MESSAGE);
        }
    }

    public void validateWinnerNumber(String inputWinnerNumber) {
        if (isWrongWinningNumberType(inputWinnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + WRONG_TYPE_ERROR_MESSAGE);
        }
        List<Integer> winnerNumber = StringToIntegerList(inputWinnerNumber);
        if (isNotCorrectSize(winnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_CORRECT_SIZE_ERROR_MESSAGE);
        }
        if (isNotCorrectRange(winnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_CORRECT_RANGE_SIZE_ERROR_MESSAGE);
        }
        if (isDuplicateWinningNumber(winnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateBonusNumber(String inputBonusNumber) {
        if (isNotDigit(inputBonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_DIGIT_ERROR_MESSAGE);
        }
        int bonusNumber = StringToInt(inputBonusNumber);
        if (isNotCorrectRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + NOT_CORRECT_RANGE_SIZE_ERROR_MESSAGE);
        }
    }

    private boolean isDuplicateWinningNumber(List<Integer> winnerNumber) {
        long distinctCountWinnerNumber = winnerNumber.stream()
                .distinct()
                .count();

        return distinctCountWinnerNumber != CORRECT_SIZE;
    }

    private boolean isNotCorrectRange(List<Integer> winnerNumber) {
        long winningNumberCount = winnerNumber.stream()
                .filter(number -> number >= NUMBER_MIN_RANGE && number <= NUMBER_MAX_RANGE)
                .count();

        return winningNumberCount != CORRECT_SIZE;
    }

    private boolean isNotCorrectRange(int number) {
        return !(number >= NUMBER_MIN_RANGE && number <= NUMBER_MAX_RANGE);
    }

    private boolean isNotCorrectSize(List<Integer> winnerNumber) {
        return winnerNumber.size() != CORRECT_WINNER_NUMBER_SIZE;
    }

    private boolean isNotDigit(String inputPurchaseMoney) {
        return !Pattern.compile(DIGIT_VALIDATE_REGEX).matcher(inputPurchaseMoney).matches();
    }

    private boolean isWrongNumberCanNotDivideByThousand(String inputPurchaseMoney) {
        int purchaseMoney = Integer.parseInt(inputPurchaseMoney);
        return purchaseMoney % THOUSAND_VALUE != ZERO_VALUE;
    }

    private boolean isWrongWinningNumberType(String inputWinningNumber) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(inputWinningNumber).matches();
    }
}
