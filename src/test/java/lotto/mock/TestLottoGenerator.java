package lotto.mock;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;

public class TestLottoGenerator implements LottoGenerator {
    private final List<Integer> numbers;

    public TestLottoGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Lotto generate() {
        return new Lotto(numbers);
    }
}
