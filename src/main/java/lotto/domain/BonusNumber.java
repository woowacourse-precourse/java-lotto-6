package lotto.domain;

import java.util.List;

public class BonusNumber {

    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "[ERROR] 보너스 볼은 로또 번호와 중복될 수 없습니다.";
    private final int bonusNumber;

    public BonusNumber(List<Integer> numbers, int bonusNumber) {
        validateDuplicate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> numbers, int bonusNumber) {
        boolean isDuplicated = numbers.stream()
                .filter(number -> number.equals(bonusNumber))
                .findFirst().isPresent();
        if (isDuplicated) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
