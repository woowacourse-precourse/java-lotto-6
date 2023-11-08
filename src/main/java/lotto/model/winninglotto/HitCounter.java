package lotto.model.winninglotto;

import java.util.List;

record HitCounter(List<Integer> winningNumbers, int bonusNumber) {

    HitResult countHit(List<Integer> numbers) {
        int hitCount = (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
        return new HitResult(hitCount, numbers.contains(bonusNumber));
    }
}
