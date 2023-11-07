package lotto.util;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constants.LottoRule.STANDARD;
import static lotto.message.ErrorMessage.INVALID_LOTTO_AMOUNT;

public class LottoShop {

    private LottoShop() {
    }

    public static Lottos buyLottos(long amount) {
        validateLottoPurchase(amount);
        return new Lottos(createLottos(amount));
    }

    private static List<Lotto> createLottos(long amount) {
        return Stream.generate(LottoFactory::createLotto)
                .limit(amount / STANDARD.getLottoPrice())
                .toList();
    }

    private static void validateLottoPurchase(long amount) {
        if (isPurchaseLottoPossible(amount)) {
            throw new IllegalStateException(INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private static boolean isPurchaseLottoPossible(long amount) {
        return amount % STANDARD.getLottoPrice() != 0;
    }

}
