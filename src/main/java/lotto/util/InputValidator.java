package lotto.util;

import java.util.List;

public class InputValidator {
    private static final String NOT_A_NUMBER_MESSAGE = "로또 금액은 숫자여야 합니다";
    private static final String BONUS_NUMBER_NOT_A_NUMBER = "보너스 번호는 숫자여야 합니다";
    private static final String MIN_PRICE_1000_MESSAGE = "로또 금액은 1000원 이상이어야 합니다";
    private static final String UNIT_OF_1000_REQUIRED_MESSAGE = "로또 금액은 1000원 단위로 입력되어야 합니다";
    private static final String WINNING_NUMBERS_SIZE_6_REQUIRED = "당첨 번호는 6개여야합니다";
    private static final String WINNING_NUMBERS_RANGE_ERROR = "당첨 번호는 1~45 사이의 숫자여야합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    public void validatePrice(String inputPrice) {
        if (isNumber(inputPrice) == false) {
            throw new IllegalArgumentException(NOT_A_NUMBER_MESSAGE);
        }

        int price = Integer.parseInt(inputPrice);

        if (isUnder1000(price)) {
            throw new IllegalArgumentException(MIN_PRICE_1000_MESSAGE);
        }

        if (isDividedBy1000(price) == false) {
            throw new IllegalArgumentException(UNIT_OF_1000_REQUIRED_MESSAGE);
        }
    }

    private boolean isDividedBy1000(int price) {
        if (price % 1000 == 0) {
            return true;
        }

        return false;
    }

    private boolean isUnder1000(int price) {
        if (price < 1000) {
            return true;
        }

        return false;
    }

    private boolean isNumber(String inputPrice) {
        if (inputPrice.matches(NUMBER_REGEX)) {
            return true;
        }

        return false;
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_6_REQUIRED);
        }

        validateNumberRanges(winningNumbers);

        if (hasDuplicateNumber(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR);
        }
    }

    private void validateNumberRanges(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR);
            }
        }
    }

    private boolean hasDuplicateNumber(List<Integer> winningNumbers) {
        long removeDuplicatedSize = winningNumbers.stream().distinct().count();
        if (winningNumbers.size() != removeDuplicatedSize) {
            return true;
        }

        return false;
    }

    public void validateBonusNumber(String inputBonusNumber) {
        if (isNumber(inputBonusNumber) == false) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_A_NUMBER);
        }
    }
}
