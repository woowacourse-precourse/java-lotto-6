package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoBuyer;
import lotto.model.LottoNumberGenerator;
import lotto.model.NumberGenerator;

public class LottoShop {
    private int sellCount;
    public LottoShop(int sellCount) {
        this.sellCount = sellCount;
    }

    public LottoBuyer sell() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        List<Lotto> lottos = IntStream.range(0, sellCount)
                .mapToObj(i -> numberGenerator.generate())
                .map(Lotto::new)
                .toList();

        return new LottoBuyer(lottos);
    }
}
