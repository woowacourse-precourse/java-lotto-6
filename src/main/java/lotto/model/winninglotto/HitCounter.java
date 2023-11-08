package lotto.model.winninglotto;

import java.util.Set;

record HitCounter(Set<Integer> winningNumbers, int bonusNumber) {

    HitResult countHit(Set<Integer> numbers) {
        int hitCount = (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
        return new HitResult(hitCount, numbers.contains(bonusNumber));
    }
}
