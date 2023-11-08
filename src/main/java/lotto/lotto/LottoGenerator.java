package lotto.lotto;

import java.util.List;
import java.util.stream.IntStream;

final class LottoGenerator {
    static List<Lotto> generate(LottoNumberGenerator lottoNumberGenerator, int generateCount) {
        return IntStream.range(0, generateCount)
                .mapToObj(ignore -> lottoNumberGenerator.generate())
                .map(Lotto::new)
                .toList();
    }
}
