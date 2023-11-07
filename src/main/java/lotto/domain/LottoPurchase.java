package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constants.IntegerConstants;
import lotto.exceptions.InvalidNumberException;

public class LottoPurchase {
    private final List<Lotto> purchasedLottos = new ArrayList<>();

    public LottoPurchase(int buyPrice) {
        validate(buyPrice);
        for (int i = 0; i < buyPrice / IntegerConstants.LOTTO_PRICE; i++) {
            var randomList = Randoms.pickUniqueNumbersInRange(
                    IntegerConstants.LOTTO_RANGE_START,
                    IntegerConstants.LOTTO_RANGE_END,
                    IntegerConstants.LOTTO_NUMBERS_COUNT
            );
            var lotto = new Lotto(randomList);
            purchasedLottos.add(lotto);
        }
    }

    private void validate(int buyPrice) {
        if (buyPrice % IntegerConstants.LOTTO_PRICE != 0) {
            throw new InvalidNumberException();
        }
    }

    public List<Lotto> getPurchasedLottos() {
        return purchasedLottos;
    }

    public List<LottoMatchType> matchAll(List<Integer> winnings, Integer bonus) {
        return purchasedLottos.stream()
                .map(l -> l.match(winnings, bonus))
                .toList();
    }
}
