package lotto.Model;

import java.util.List;
import lotto.Model.VO.LottoData;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public LottoData getData(){
        return new LottoData(numbers);
    }
}
