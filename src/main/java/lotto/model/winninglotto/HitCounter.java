package lotto.model.winninglotto;

import java.util.Set;

public class HitCounter {

    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    protected HitCounter(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    protected HitResult countHit(Set<Integer> numbers) {
        int hitCount = (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
        return new HitResult(hitCount, numbers.contains(bonusNumber));
    }
}
