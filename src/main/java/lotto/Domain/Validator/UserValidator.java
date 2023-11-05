package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_PRICE_UNIT;

import java.util.List;
import lotto.Domain.Lotto;

public class UserValidator {
    public static void doValidate(int money, List<Lotto> lottos) {
        if (!isMoneyOverLottoPrice(money)) {
            throw new IllegalArgumentException();
        }
        if (!isMoneyDividedByLottoPriceUnit(money)) {
            throw new IllegalArgumentException();
        }
        if (!isLottoCountSameUnitOfMoney(money, lottos)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isMoneyOverLottoPrice(int money) {
        return money >= LOTTO_PRICE_UNIT;
    }

    private static boolean isMoneyDividedByLottoPriceUnit(int money) {
        return money % LOTTO_PRICE_UNIT == 0;
    }

    private static boolean isLottoCountSameUnitOfMoney(int money, List<Lotto> lottos) {
        return lottos.size() == (money / LOTTO_PRICE_UNIT);
    }
}
