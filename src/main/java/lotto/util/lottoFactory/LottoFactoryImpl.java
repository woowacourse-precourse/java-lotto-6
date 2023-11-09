package lotto.util.lottoFactory;

import lotto.Lotto;
import lotto.util.generator.LottoNumbersGenerator;

import java.util.List;

public class LottoFactoryImpl implements LottoFactory {
    public LottoFactoryImpl(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    private final LottoNumbersGenerator lottoNumbersGenerator;

    @Override
    public Lotto generateLotto() {
        return new Lotto(lottoNumbersGenerator.generateNumbers().stream().sorted().toList());
    }

    @Override
    public Lotto generateLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
