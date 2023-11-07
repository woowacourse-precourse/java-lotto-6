package lotto.domain;

import java.util.List;

public class BonusNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final String DUPLICATE_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 번호는 입력할 수 없습니다.";
    private static final String OUT_OF_RANGE_NUMBER_ERROR_MESSAGE = "[ERROR] 번호는 1~45 사이의 숫자여야합니다.";

    public static int getBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateRange(int bonusNumber) {
        if ((bonusNumber < MIN_LOTTO_NUMBER) || (bonusNumber > MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR_MESSAGE);
        }
    }
}
