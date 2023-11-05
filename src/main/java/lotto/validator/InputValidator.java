package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ErrorConstant.ERROR_PREFIX;
import static lotto.util.TypeConversionUtil.StringToIntegerList;

public class InputValidator {

    private static final String DIGIT_VALIDATE_REGEX = "-?[0-9]+";
    private static final String LOTTO_WINNING_NUMBERS_REGEX = "^[0-9,]+$";
    private static final int CORRECT_WINNER_NUMBER_SIZE = 6;

    public void validatePurchaseMoney(String inputPurchaseMoney) {
        if (isNotDigit(inputPurchaseMoney)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매금액은 숫자로 이루어져야 합니다.");
        }
        if (isWrongEndNumber(inputPurchaseMoney)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "구매금액은 1000단위로 입력해야 합니다.");
        }
    }

    public void validateWinnerNumber(String inputWinnerNumber) {
        if (isWrongWinningNumberType(inputWinnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "형식에 맞게 입력해 주세요. ex) 1,2,3,4,5,6");
        }
        List<Integer> winnerNumber = StringToIntegerList(inputWinnerNumber);
        if (isNotCorrectSize(winnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "숫자 6개를 입력해 주세요.");
        }
        if (isNotCorrectRange(winnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "1~45 사이의 값을 입력해 주세요.");
        }
        if (isDuplicateWinningNumber(winnerNumber)) {
            throw new IllegalArgumentException(ERROR_PREFIX + "중복 되지 않는 값을 입력해 주세요.");
        }
    }

    private boolean isDuplicateWinningNumber(List<Integer> winnerNumber) {
        long distinctCountWinnerNumber = winnerNumber.stream()
                .distinct()
                .count();

        return distinctCountWinnerNumber != 6;
    }

    private boolean isNotCorrectRange(List<Integer> winnerNumber) {
        long winningNumberCount = winnerNumber.stream()
                .filter(number -> number >= 1 && number <= 45)
                .count();

        return winningNumberCount != 6;
    }

    private boolean isNotCorrectSize(List<Integer> winnerNumber) {
        return winnerNumber.size() != CORRECT_WINNER_NUMBER_SIZE;
    }

    private boolean isNotDigit(String inputPurchaseMoney) {
        return !Pattern.compile(DIGIT_VALIDATE_REGEX).matcher(inputPurchaseMoney).matches();
    }

    private boolean isWrongEndNumber(String inputPurchaseMoney) {
        int purchaseMoney = Integer.parseInt(inputPurchaseMoney);
        return purchaseMoney % 1000 != 0;
    }

    private boolean isWrongWinningNumberType(String inputWinningNumber) {
        return !Pattern.compile(LOTTO_WINNING_NUMBERS_REGEX).matcher(inputWinningNumber).matches();
    }
}
