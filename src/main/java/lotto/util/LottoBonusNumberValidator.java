package lotto.util;

import java.util.List;

public class LottoBonusNumberValidator {

    private static final int MIN_BONUS_NUM = 1;
    private static final int MAX_BONUS_NUM = 45;

    public static void validateBonusNumber(int bonusNumber, List<Integer> lottoNumbers) {
        validateIsBetween(bonusNumber);
        validateIsNotOverlap(bonusNumber, lottoNumbers);
    }

    private static void validateIsNotOverlap(int bonusNumber, List<Integer> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (bonusNumber == lottoNumbers.get(i)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호는 중복될 수 없습니다.");
            }
        }
    }

    private static void validateIsBetween(int bonusNumber) {
        if (bonusNumber < MIN_BONUS_NUM || bonusNumber > MAX_BONUS_NUM) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }
}
