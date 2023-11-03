package lotto.domain.Utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public static void validateInputCash(int cash) {
        if (cash <= 0) {
            throw new IllegalArgumentException("[ERROR] 0보다 작은 값을 입력했습니다.");
        } else if (cash % Constant.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 구매 금액은 "
                            + Constant.LOTTO_PRICE
                            + "원 단위로 입력해 주세요."
            );
        }
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.size() != Constant.LOTTO_PICK_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + Constant.LOTTO_PICK_NUMBER + "자리를 입력해 주세요.");
        }

        Map<Integer, Integer> sameNumberCheck = new HashMap<>();

        for (int num :
                winningNumbers) {
            if (num < Constant.LOTTO_START_NUMBER || num > Constant.LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(
                        "[ERROR] 당첨 숫자를 "
                                + Constant.LOTTO_START_NUMBER
                                + " ~ "
                                + Constant.LOTTO_END_NUMBER
                                + "중에서 선택해야 합니다."
                );
            } else if (sameNumberCheck.containsKey(num)) {
                throw new IllegalArgumentException("[ERROR] 동일한 숫자를 입력했습니다.");
            }
            sameNumberCheck.put(num, sameNumberCheck.getOrDefault(num, 0) + 1);
        }
    }

    public static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < Constant.LOTTO_START_NUMBER || bonusNumber > Constant.LOTTO_END_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 숫자를 "
                            + Constant.LOTTO_START_NUMBER
                            + " ~ "
                            + Constant.LOTTO_END_NUMBER
                            + "중에서 선택해야 합니다."
            );
        } else if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자가 당첨 숫자와 겹칩니다.");
        }
    }
}
