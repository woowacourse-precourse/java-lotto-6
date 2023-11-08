package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;

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
        return amount / LottoConstant.PRICE.getNumber();
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.RANGE_BEGIN.getNumber(),
                LottoConstant.RANGE_END.getNumber(), LottoConstant.SIZE.getNumber());
    }
}
