package lotto.domain.generator;

import lotto.domain.lotto.Lotto;

public class AutoLottoGenerator implements LottoGenerator{

    private final NumbersGenerator numbersGenerator;

    public AutoLottoGenerator(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    @Override
    public Lotto create() {
        return new Lotto(numbersGenerator.create());
    }
}
