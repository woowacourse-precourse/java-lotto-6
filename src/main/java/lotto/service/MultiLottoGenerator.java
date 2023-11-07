package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.number.Lotto;

public class MultiLottoGenerator {

    private final SingleLottoGenerator singleLottoGenerator;
    private final int lottoCount;

    public static MultiLottoGenerator of(SingleLottoGenerator singleLottoGenerator, int lottoCount) {
        return new MultiLottoGenerator(singleLottoGenerator, lottoCount);
    }

    private MultiLottoGenerator(SingleLottoGenerator singleLottoGenerator, int lottoCount) {
        this.singleLottoGenerator = singleLottoGenerator;
        this.lottoCount = lottoCount;
    }

    public List<Lotto> generate() {
        return IntStream.range(0, this.lottoCount)
                .mapToObj(count -> singleLottoGenerator.generate())
                .toList();
    }
}
