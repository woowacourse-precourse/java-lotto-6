package lotto.util;

import java.util.List;
import lotto.domain.generator.LottoNumbersGenerator;

public class FakeNumbersGenerator implements LottoNumbersGenerator {
    private final List<Integer> expectedNumbers;

    public FakeNumbersGenerator(List<Integer> expectedNumbers) {
        this.expectedNumbers = expectedNumbers;
    }

    @Override
    public List<Integer> generate() {
        return expectedNumbers;
    }

}
