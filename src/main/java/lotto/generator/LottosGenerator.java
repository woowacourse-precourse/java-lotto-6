package lotto.generator;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;

public class LottosGenerator {

    private LottoNumbersGenerator lottoNumbersGenerator;

    private LottosGenerator(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
    }

    public static LottosGenerator create(LottoNumbersGenerator lottoNumbersGenerator) {
        return new LottosGenerator(lottoNumbersGenerator);
    }

    public List<Lotto> generate(int ticketCount) {
        return Stream.generate(this::createLotto)
                .limit(ticketCount)
                .toList();
    }

    private Lotto createLotto() {
        return new Lotto(lottoNumbersGenerator.generate());
    }
}
