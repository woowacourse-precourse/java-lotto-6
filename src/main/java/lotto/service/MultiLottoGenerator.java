package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.number.Lotto;

public class MultiLottoGenerator {

    private final int lottoCount;

    public static MultiLottoGenerator of(int lottoCount) {
        return new MultiLottoGenerator(lottoCount);
    }

    private MultiLottoGenerator(int lottoCount) {
        this.lottoCount = lottoCount;
    }

    public List<Lotto> generate() {
        return IntStream.range(0, this.lottoCount)
                .mapToObj(count -> SingleLottoGenerator.generate())
                .toList();
    }
}
