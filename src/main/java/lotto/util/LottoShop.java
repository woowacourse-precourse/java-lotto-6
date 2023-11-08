package lotto.util;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constants.LottoRule.STANDARD;
import static lotto.message.ErrorMessage.INVALID_LOTTO_AMOUNT;

public class LottoShop {

    private LottoShop() {
    }

    public static Lottos buyLottos(Cash cash) {
        validateLottoPurchase(cash);
        return new Lottos(createLottos(cash));
    }

    private static List<Lotto> createLottos(Cash amount) {
        return Stream.generate(LottoFactory::createLotto)
                .limit(amount.countPurchasableItems(STANDARD.getLottoPrice()))
                .toList();
    }

    private static void validateLottoPurchase(Cash amount) {
        if (amount.isPurchaseLottoPossible(STANDARD.getLottoPrice())) {
            throw new IllegalStateException(INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

}
