package lotto.domain.lotto;

import lotto.domain.lotto.random.LottoNumberCreator;

import java.util.List;
import java.util.stream.IntStream;

public class LottoMachine {

    private final LottoNumberCreator lottoNumberCreator;

    public LottoMachine(LottoNumberCreator lottoNumberCreator) {
        this.lottoNumberCreator = lottoNumberCreator;
    }

    public LottoCount getTotalCount(Price price) {
        return new LottoCount(price);
    }

    public Lottos createLottoNumbers(LottoCount count) {
        List<Lotto> lottos = IntStream.range(0, count.getCount())
                .mapToObj(i -> lottoNumberCreator.createLotto())
                .toList();
        return new Lottos(lottos);
    }

}
