package lotto.Domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final static LottoNumberException lottoNumberException = new LottoNumberException();
    private final static BonusNumberException bonusNumberException = new BonusNumberException();
    private final static int BONUS_NUMBER_POSITION = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
