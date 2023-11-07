package lotto.utils.generator;

import java.util.List;
import lotto.domain.Lotto;

public class FixedLottosGenerator implements LottsGenerator {
    private final List<Lotto> lottos;

    public FixedLottosGenerator(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    @Override
    public List<Lotto> generateLottos(int purchaseAmount) {
        // purchaseAmount는 무시
        return lottos;
    }
}
