package lotto.domain;

import java.util.List;

public class BonusNumber {
    private final int number;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final String VALIDATE_RANGE_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private BonusNumber(int number, List<Integer> winningNumbers) {
        validateNumberInRange(number);
        validateNotInWinningNumbers(number, winningNumbers);
        this.number = number;
    }


    private void validateNumberInRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(VALIDATE_RANGE_MESSAGE);
        }
    }

    private void validateNotInWinningNumbers(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }
    }
}
