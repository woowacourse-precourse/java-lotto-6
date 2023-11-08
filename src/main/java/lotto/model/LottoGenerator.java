package lotto.model;

import lotto.model.lottonumbersgenerator.LottoNumbersGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    private Lotto generateLotto() {
        List<Integer> numbers = lottoNumbersGenerator.generate();
        return new Lotto(numbers);
    }
}
