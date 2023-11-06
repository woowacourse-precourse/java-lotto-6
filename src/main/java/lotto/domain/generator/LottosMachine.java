package lotto.domain.generator;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMoney;
import lotto.domain.lotto.Lottos;

public class LottosMachine {

    private final LottoGenerator lottoGenerator;

    public LottosMachine(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public Lottos buy(LottoMoney lottoMoney) {
        int count = lottoMoney.calculatePurchasableCount();
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> lottoGenerator.create())
                .toList();

        return new Lottos(lottos);
    }




}
