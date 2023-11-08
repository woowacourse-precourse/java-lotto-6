package lotto.domain.generator;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;

public class AutoLottoGenerator implements LottoGenerator {

    private final NumbersGenerator numbersGenerator;

    public AutoLottoGenerator(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
    }

    @Override
    public Lotto create() {
        List<LottoNumber> numbers = numbersGenerator.create().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        return new Lotto(numbers);
    }
}
