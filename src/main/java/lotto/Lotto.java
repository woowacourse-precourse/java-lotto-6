package lotto;

import lotto.model.LottoResult;
import lotto.model.WinningNumbers;

import java.util.List;

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

    public LottoResult toLottoResult(WinningNumbers winningNumbers){
        int count = 0;
        for (int number : numbers) {
            if (winningNumbers.getSixNumbers().contains(number)) {
                count++;
            }
        }
        boolean bonus = numbers.contains(winningNumbers.getBonusNumber());

        return LottoResult.of(count, bonus);
    }

    // TODO: 추가 기능 구현
}
