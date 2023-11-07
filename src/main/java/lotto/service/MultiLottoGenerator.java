package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.io.write.OutputWriter;

public class MultiLottoGenerator {

    private final SingleLottoGenerator singleLottoGenerator;
    private final int lottoCount;

    public MultiLottoGenerator(SingleLottoGenerator singleLottoGenerator, int lottoCount) {
        this.singleLottoGenerator = singleLottoGenerator;
        this.lottoCount = lottoCount;
    }

    public List<Lotto> generate() {
        OutputWriter.showPurchaseLottoCount(this.lottoCount);
        List<Lotto> lottos = doGenerateLottos();
        OutputWriter.showLottos(lottos);
        return lottos;
    }

    private List<Lotto> doGenerateLottos() {
        return IntStream.range(0, this.lottoCount)
                .mapToObj(count -> singleLottoGenerator.generate())
                .toList();
    }
}
