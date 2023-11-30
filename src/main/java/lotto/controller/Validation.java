package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.model.Constants;

public class Validation {

    public static void prizeNumberCount(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("서로 다른 로또 번호가 6개가 아님");
        }

        for (int num : numbers) {
            lottoNumberRange(num);
        }
    }

    public static void lottoNumberRange(int num) {
        if (num < Constants.LOTTO_RANGE_START || Constants.LOTTO_RANGE_END < num) {
            throw new IllegalArgumentException("로또 번호의 범위가 유효하지 않음");
        }
    }

    public static void isBonusNumberExceptPrizeNumber(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호 중 보너스 번호와 중복되는 번호가 있음");
        }
    }

    public static void buyingMoneyMoreThenZero(int money) {
        if (money < 1) {
            throw new IllegalArgumentException("구매에 쓸 비용은 1원 이상이어야 함");
        }
    }

}
