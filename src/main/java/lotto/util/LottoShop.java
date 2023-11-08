package lotto.util;

import lotto.domain.lotto.Cash;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;

import java.util.List;
import java.util.stream.Stream;

import static lotto.constants.LottoRule.STANDARD;

public class LottoShop {

    private LottoShop() {
    }

    public static Lottos buyLottos(Cash cash) {
        return new Lottos(createLottos(cash));
    }

    private static List<Lotto> createLottos(Cash amount) {
        return Stream.generate(LottoFactory::createLotto)
                .limit(amount.countPurchasableItems(STANDARD.getLottoPrice()))
                .toList();
    }

}
