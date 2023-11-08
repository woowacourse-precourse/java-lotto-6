package lotto.util;

import java.util.List;
import lotto.domain.Lotto;

public class TestLottoGenerator implements LottoGenerator{
    private List<Integer> numbers;

    @Override
    public Lotto generate() {
        return new Lotto(numbers);
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
