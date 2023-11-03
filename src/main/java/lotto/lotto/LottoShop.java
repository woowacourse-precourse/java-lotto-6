package lotto.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoShop {
    private int lottoCount;

    public LottoShop(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public LottoBuyer sell() {
        NumberGenerator numberGenerator = new LottoNumberGenerator();

        List<Lotto> lottos = IntStream.range(0, lottoCount)
                .mapToObj(i -> numberGenerator.generate())
                .map(Lotto::new)
                .toList();

        return new LottoBuyer(lottos);
    }


}
