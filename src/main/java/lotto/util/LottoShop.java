package lotto.util;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.message.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

public class LottoShop {

    private static final int DENOMINATION = 1000;

    private LottoShop() {
    }

    public static Lottos buyLottos(long amount) {
        validateMultipleOfDenomination(amount);
        return new Lottos(createLottos(amount));
    }

    private static List<Lotto> createLottos(long amount) {
        return Stream.generate(LottoFactory::createLotto)
                .limit(amount / DENOMINATION)
                .toList();
    }

    private static void validateMultipleOfDenomination(long amount) {
        if (amount % DENOMINATION != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_AMOUNT.getMessage());
        }
    }

}
