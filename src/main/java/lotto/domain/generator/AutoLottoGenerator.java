package lotto.domain.generator;

import java.util.List;
import lotto.domain.lotto.Lotto;

public class AutoLottoGenerator implements LottoGenerator {

    private final NumbersGenerator numbersGenerator;

    public AutoLottoGenerator(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    @Override
    public Lotto create() {
        List<Integer> integers = numbersGenerator.create();
        return new Lotto(integers);
    }
}
