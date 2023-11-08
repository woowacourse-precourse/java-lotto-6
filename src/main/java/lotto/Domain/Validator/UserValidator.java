package lotto.Domain.Validator;

import static lotto.Util.Constants.LOTTO_PRICE_UNIT;

import java.util.List;
import lotto.Domain.Lotto;
import lotto.Util.ExceptionMessageFormatter;
import lotto.Util.LottoGameException;

public class UserValidator {
    private UserValidator() {

    }

    public static void doValidate(int money, List<Lotto> lottos) {
        if (!isMoneyOverLottoPrice(money)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.LOWER_THAN_LOTTO_PRICE.getMessage()));
        }
        if (!isMoneyDividedByLottoPriceUnit(money)) {
            throw new IllegalArgumentException(
                    ExceptionMessageFormatter.makeMessage(LottoGameException.NOT_DIVIDED_BY_LOTTO_UNIT.getMessage()));
        }
        if (!isLottoCountSameUnitOfMoney(money, lottos)) {
            throw new IllegalArgumentException(ExceptionMessageFormatter.makeMessage(
                    LottoGameException.NOT_COINCIDE_LOTTO_WITH_MONEY.getMessage()));
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
