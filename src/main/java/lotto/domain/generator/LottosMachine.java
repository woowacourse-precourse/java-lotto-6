package lotto.domain.generator;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMoney;
import lotto.domain.lotto.Lottos;

public class LottosMachine {

    public static final int START_INCLUSIVE = 0;
    private final LottoGenerator lottoGenerator;

    public LottosMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos buy(LottoMoney lottoMoney) {
        int count = lottoMoney.calculatePurchasableCount();
        List<Lotto> lottos = IntStream.range(START_INCLUSIVE, count)
                .mapToObj(i -> lottoGenerator.create())
                .toList();

        return new Lottos(lottos);
    }


}
