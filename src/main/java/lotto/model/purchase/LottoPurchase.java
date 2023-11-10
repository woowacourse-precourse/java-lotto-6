package lotto.model.purchase;

import java.util.List;
import lotto.common.exception.ErrorMessage;
import lotto.model.lotto.Lotto;

public record LottoPurchase(LottoPurchaseAmount amount, List<Lotto> lottos) {
    public LottoPurchase {
        validatePurchasedLottoSize(amount, lottos);
    }

    private void validatePurchasedLottoSize(LottoPurchaseAmount amount, List<Lotto> lottos) {
        int lottoCount = amount.calculatePurchaseLottoCount();
        if (lottos.size() != lottoCount) {
            throw new IllegalStateException(ErrorMessage.INVALID_LOTTO_PURCHASE.getValue(amount, lottos.size()));
        }
    }
}
