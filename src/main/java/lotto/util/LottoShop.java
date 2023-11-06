package lotto.util;

import lotto.constants.LottoRule;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.message.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

public class LottoShop {

    private LottoShop() {
    }

    public static Lottos buyLottos(long amount) {
        validateLottoPurchase(amount);
        return new Lottos(createLottos(amount));
    }

    private static List<Lotto> createLottos(long amount) {
        return Stream.generate(LottoFactory::createLotto)
                .limit(amount / LottoRule.STANDARD.getLottoPrice())
                .toList();
    }

    private static void validateLottoPurchase(long amount) {
        if (isPurchaseLottoPossible(amount)) {
            throw new IllegalStateException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private static boolean isPurchaseLottoPossible(long amount) {
        return amount % LottoRule.STANDARD.getLottoPrice() != 0;
    }

}
