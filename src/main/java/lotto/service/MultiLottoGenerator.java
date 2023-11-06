package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.io.write.LottoOutputWriter;

public class MultiLottoGenerator {

    private final SingleLottoGenerator singleLottoGenerator;
    private final int lottoNumberCount;

    public MultiLottoGenerator(SingleLottoGenerator singleLottoGenerator, int lottoNumberCount) {
        this.singleLottoGenerator = singleLottoGenerator;
        this.lottoNumberCount = lottoNumberCount;
    }

    public List<List<Integer>> generate() {
        LottoOutputWriter.showPurchaseLottoCount(this.lottoNumberCount);
        List<List<Integer>> lottos = doGenerateLottos();
        LottoOutputWriter.showLottos(lottos);
        return lottos;
    }

    private List<List<Integer>> doGenerateLottos() {
        return IntStream.range(0, lottoNumberCount)
                .mapToObj(count -> singleLottoGenerator.generate())
                .toList();
    }
}
