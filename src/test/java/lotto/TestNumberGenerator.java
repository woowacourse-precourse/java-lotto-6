package lotto;

import java.util.List;
import lotto.domain.NumbersGenerator;

public class TestNumberGenerator implements NumbersGenerator {

    private final List<Integer> expectedNumbers;

    public TestNumberGenerator(List<Integer> expectedNumbers) {
        this.expectedNumbers = expectedNumbers;
    }

    @Override
    public List<Integer> generateNumbers() {
        return expectedNumbers;
    }

}
