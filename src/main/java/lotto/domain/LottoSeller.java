package lotto.domain;

import lotto.domain.lotto.Lottos;
import lotto.util.LottoConstants;

public class LottoSeller {
    public int calculateNumberOfLottos(int money) {
        int LottosAmount = money / LottoConstants.LOTTO_PRICE.getValue();

        return LottosAmount;
    }

    public Lottos getLottos(PurchaseAmount purchaseAmount) {
        int money = purchaseAmount.getPurchaseAmount();
        int numberOfLottos = calculateNumberOfLottos(money);

        return Lottos.createLottos(numberOfLottos);
    }
}
