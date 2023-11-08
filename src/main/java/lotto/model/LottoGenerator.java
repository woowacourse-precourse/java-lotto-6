package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;

public class LottoGenerator {
    private final LottoNumbersGenerator lottoNumbersGenerator;

    public LottoGenerator(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public Lottos generateLottos(int count) {
        List<Lotto> lottos = IntStream.range(0, count)
                .mapToObj(i -> generateLotto())
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public Lotto generateLotto() {
        List<Integer> numbers = lottoNumbersGenerator.generate();
        return new Lotto(numbers);
    }
}
