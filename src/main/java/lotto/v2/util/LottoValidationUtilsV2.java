package lotto.v2.util;

import java.util.List;
import lotto.v2.util.LottoConstantsV2;
public class LottoValidationUtilsV2 {

    public static void checkValidLottoNumbers(List<Integer> numbers) {
        if (numbers.size() != LottoConstantsV2.LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " +
                    LottoConstantsV2.LOTTO_NUMBERS_SIZE.getValue() + "개여야 합니다.");
        }
        if (numbers.stream().anyMatch(num -> num < LottoConstantsV2.LOTTO_NUMBER_MIN.getValue() || num > LottoConstantsV2.LOTTO_NUMBER_MAX.getValue())) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " +
                    LottoConstantsV2.LOTTO_NUMBER_MIN.getValue() + "에서 " +
                    LottoConstantsV2.LOTTO_NUMBER_MAX.getValue() + " 사이의 숫자여야 합니다.");
        }
    }

    public static void checkValidBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < LottoConstantsV2.LOTTO_NUMBER_MIN.getValue() || bonusNumber > LottoConstantsV2.LOTTO_NUMBER_MAX.getValue()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 " +
                    LottoConstantsV2.LOTTO_NUMBER_MIN.getValue() + "에서 " +
                    LottoConstantsV2.LOTTO_NUMBER_MAX.getValue() + " 사이의 숫자여야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}

