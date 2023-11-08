package lotto.domain.number;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.utils.Constants.*;

public class BonusNumber {
    private static final String DUPLICATE_BONUS_NUMBER_ERROR = ERROR_PREFIX + "보너스 번호가 이미 로또 번호 목록에 포함되어 있습니다.";

    public BonusNumber(Lotto winningNumbers, int bonusNumber) {
        validateBonus(winningNumbers, bonusNumber);
    }

    //1~45 숫자범위 검증 + 이미 numbers에 포함되어있는지 검증
    private static void validateBonus(Lotto winningNumbers, int bonusNumber) {
        validateBonusRange(bonusNumber);
        validateBonusDuplicate(winningNumbers, bonusNumber);
    }

    private static void validateBonusRange(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            System.out.println(INVALID_NUMBER_RANGE_ERROR);
            throw new IllegalArgumentException();
        }
    }

    private static void validateBonusDuplicate(Lotto numbers, int bonusNumber) {
        List<Integer> numberList = numbers.getNumbers();

        if (numberList.contains(bonusNumber)) {
            System.out.println(DUPLICATE_BONUS_NUMBER_ERROR);
            throw new IllegalArgumentException();
        }
    }
}
