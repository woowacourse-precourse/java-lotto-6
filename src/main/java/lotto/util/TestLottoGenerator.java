package lotto.util;

import java.util.List;
import lotto.domain.Lotto;

public class TestLottoGenerator implements LottoGenerator{
    private List<Integer> numbers;

    public TestLottoGenerator(List<Integer> numbers){
        this.numbers = numbers;
    }
    @Override
    public Lotto generate() {
        return new Lotto(numbers);
    }
}
