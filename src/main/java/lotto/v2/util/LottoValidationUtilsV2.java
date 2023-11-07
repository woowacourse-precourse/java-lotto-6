package lotto.v2.util;

import java.util.List;

public class LottoValidationUtilsV2 {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    public static void checkValidLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < LOTTO_NUMBER_MIN || num > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + LOTTO_NUMBER_MIN + "에서 " + LOTTO_NUMBER_MAX + " 사이의 숫자여야 합니다.");
        }
    }

    public static void checkValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
