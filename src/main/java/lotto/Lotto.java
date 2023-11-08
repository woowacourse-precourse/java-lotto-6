package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        this.numbers.sort(Integer::compareTo);
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.sizeValidate(numbers);
        LottoValidator.rangeValidateFromList(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public LottoRank match(WinningLotto winningLotto) {
        int matchCount = 0;
        for (Integer number : numbers) {
            if (winningLotto.getWinningLotto().contains(number)) {
                matchCount++;
            }
        }
        boolean isBonusMatch = numbers.contains(winningLotto.getBonusNumber());
        return LottoRank.valueOf(matchCount, isBonusMatch);
    }
}
