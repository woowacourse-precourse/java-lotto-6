package lotto.generator;

import lotto.model.Lotto;

import java.util.List;
import java.util.stream.IntStream;

public class LottoGenerator {

    public List<Lotto> generateLottoByCount(int lottoCount) {
        return IntStream.range(0, lottoCount)
                .mapToObj(i -> Lotto.createLotto())
                .toList();
    }

}
