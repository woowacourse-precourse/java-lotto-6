package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.io.write.LottoOutputWriter;
import lotto.number.Lotto;

public class MultiLottoGenerator {

    private final SingleLottoGenerator singleLottoGenerator;
    private final int lottoCount;

    public MultiLottoGenerator(SingleLottoGenerator singleLottoGenerator, int lottoCount) {
        this.singleLottoGenerator = singleLottoGenerator;
        this.lottoCount = lottoCount;
    }

    public List<Lotto> generate() {
        LottoOutputWriter.showPurchaseLottoCount(this.lottoCount);
        List<Lotto> lottos = doGenerateLottos();
        LottoOutputWriter.showLottos(lottos);
        return lottos;
    }

    private List<Lotto> doGenerateLottos() {
        return IntStream.range(0, lottoCount)
                .mapToObj(count -> singleLottoGenerator.generate())
                .toList();
    }
}
