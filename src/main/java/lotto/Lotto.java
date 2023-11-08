package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoGameValidator.validateLotteNumber(numbers);
        this.numbers = numbers;
    }

}
