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

    private List<Lotto> generateLottos(long buyingCount) {
        List<Lotto> lottos = new ArrayList<>();
        while (lottos.size() != buyingCount) {
            lottos.add(generateLotto());
        }
        return lottos;
    }
}
