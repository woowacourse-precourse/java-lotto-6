package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Checker {
    private static final Integer UNIT = 1000;
    private static final Integer MINIMUM_RANGE = 1;
    private static final Integer MAXIMUM_RANGE = 45;

    public static void priceCorrect(Integer price) {
        if (price % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
        }
    }

    public static void winningNotDuplicated(List<Integer> winningNumbers) {
        HashMap<Integer, Boolean> duplication = new HashMap<>();

        for (Integer winningNumber : winningNumbers) {
            if (duplication.containsKey(winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자일 수 없습니다.");
            }

            duplication.put(winningNumber, true);
        }
    }

    public static void winningAndBonusNotDuplicated(List<Integer> winningNumbers, Integer bonusNumber) {
        winningNumbers.forEach((value) -> {
            if (bonusNumber == value) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");
            }
        });
    }

    private static Boolean inRange(Integer number) {
        if (MINIMUM_RANGE <= number && number <= MAXIMUM_RANGE) {
            return true;
        }

        return false;
    }

    public static void winningInRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (!inRange(winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 수여야 합니다.");
            }
        }
    }

    public static void bonusInRange(Integer bonusNumber) {
        if (!inRange(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 수여야 합니다.");
        }
    }
}
