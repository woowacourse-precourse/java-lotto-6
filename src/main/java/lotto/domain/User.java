package lotto.domain;

import lotto.exception.InputException;
import java.util.List;

import static lotto.configuration.GameConfiguration.LOTTO_PRICE_PER_UNIT;
import static lotto.exception.errorcode.InputErrorCode.MISMATCH_PURCHASE_PRICE_AND_LOTTO_COUNT;

public class User {
    private final List<Lotto> lottos;
    private final Purchase purchase;

    public User(final List<Lotto> lottos, final Purchase purchase) {
        validateLottoSizeEqualPurchasePrice(lottos, purchase.getPrice());
        this.lottos = lottos;
        this.purchase = purchase;
    }

    public Lotto getLottoFromIndex(final int index) {
        return lottos.get(index);
    }

    public double getProfitRate(final long revenue) {
        return purchase.getProfitRate(revenue);
    }

    public int getPurchaseCount() {
        return (int) (purchase.getPrice() / LOTTO_PRICE_PER_UNIT);
    }

    private void validateLottoSizeEqualPurchasePrice(final List<Lotto> lottos, final long purchasePrice) {
        if (lottos.size() != purchasePrice / LOTTO_PRICE_PER_UNIT) {
            throw new InputException(MISMATCH_PURCHASE_PRICE_AND_LOTTO_COUNT);
        }
    }
}
