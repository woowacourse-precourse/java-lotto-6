package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;

public class LottosGenerator {
    private final int MINIMUM_LOTTOS_QUANTITY = 1;
    LottoGenerator lottoGenerator = new LottoGenerator();
    public LottosGenerator(int purchaseQuntity) {
        generateLottos(purchaseQuntity);
    }

    public List<Lotto> generateLottos(int purchaseQuntity) {
        return IntStream.range(MINIMUM_LOTTOS_QUANTITY, purchaseQuntity)
                .mapToObj(i -> lottoGenerator.generateNumber())
                .collect(Collectors.toList());
    }
}
