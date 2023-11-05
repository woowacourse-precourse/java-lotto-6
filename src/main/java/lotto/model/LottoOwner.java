package lotto.model;

import static lotto.constant.ErrorMessage.MONEY_LESS_THAN_ZERO;
import static lotto.constant.ErrorMessage.MONEY_WITH_REMAINDER;

import lotto.dto.LottosInfo;

public class LottoOwner {
    private static final long LOTTO_PRICE = 1000;

    private final long money;
    private final Lottos lottos;

    private LottoOwner(long money) {
        validateMoneyMoreThanZero(money);
        validateDividedByDivisorWithoutRemainder(money);
        this.money = money;
        this.lottos = Lottos.createLottosByLottoCount(getQuotient(money));
    }

    public static LottoOwner from(long money) {
        return new LottoOwner(money);
    }

    private void validateMoneyMoreThanZero(long money) {
        if (money <= 0) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_ZERO.toString());
        }
    }

    private void validateDividedByDivisorWithoutRemainder(long money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_WITH_REMAINDER.toString());
        }
    }

    private long getQuotient(long money) {
        return money / LOTTO_PRICE;
    }

    public LottosInfo getLottoInfos() {
        return lottos.getLottosInfo();
    }
}
