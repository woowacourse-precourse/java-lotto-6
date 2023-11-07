package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final List<Lotto> lottos;

    public LottoGenerator(long buyingPrice) {
        long buyingCount = calculateBuyingCount(buyingPrice);
        this.lottos = generateLottos(buyingCount);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
