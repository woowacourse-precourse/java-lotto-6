package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class LottosGenerator {
    private final int MINIMUM_LOTTOS_QUANTITY = 0;
    int purchaseQuntity;
    LottoGenerator lottoGenerator = new LottoGenerator();
    public LottosGenerator(int purchaseQuntity) {
        this.purchaseQuntity = purchaseQuntity;
    }

    public List<Lotto> generateLottos() {
        return IntStream.range(MINIMUM_LOTTOS_QUANTITY, purchaseQuntity)
                .mapToObj(i -> lottoGenerator.generateNumber())
                .collect(Collectors.toList());
    }
}
