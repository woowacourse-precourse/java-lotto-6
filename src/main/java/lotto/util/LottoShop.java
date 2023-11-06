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
        validateTicketPurchase(amount);
        return new Lottos(createLottos(amount));
    }

    private static List<Lotto> createLottos(long amount) {
        return Stream.generate(LottoFactory::createLotto)
                .limit(amount / LottoRule.STANDARD.getTicketPrice())
                .toList();
    }

    private static void validateTicketPurchase(long amount) {
        if (isPurchaseTicketPossible(amount)) {
            throw new IllegalStateException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

    private static boolean isPurchaseTicketPossible(long amount) {
        return amount % LottoRule.STANDARD.getTicketPrice() != 0;
    }

}
