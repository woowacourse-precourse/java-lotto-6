package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Lotto;
import lotto.LottoGenerator;

public class LottoService {

    LottoGenerator lottoGenerator = new LottoGenerator();

    public List<Lotto> generateLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> lottoGenerator.lottoGenerate())
                .collect(Collectors.toList());
    }

}
