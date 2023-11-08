package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottosPurchase {
    private final List<Lotto> lottos;

    public LottosPurchase(int amount) {
        lottos = new ArrayList<>();
        int countsOfPurchasing = calculateCountsOfPurchasing(amount);

        for (int i = 0; i < countsOfPurchasing; i++) {
            lottos.add(new Lotto(generateRandomNumbers()));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private int calculateCountsOfPurchasing(int amount) {
        return amount / LottoConstants.PRICE.getNumber();
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstants.RANGE_BEGIN.getNumber(),
                LottoConstants.RANGE_END.getNumber(), LottoConstants.SIZE.getNumber());
    }
}
