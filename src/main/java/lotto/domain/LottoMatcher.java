package lotto.domain;

import java.util.List;

public class LottoMatcher {
    public LottoMatcher() {
    }

    public long calculateCorrectWinning(List<Integer> userNumbers, List<Integer> winningNumbers) {
        long correctCount = userNumbers.stream()
                .filter(userNumber -> winningNumbers.contains(userNumber))
                .count();

        return correctCount;
    }

    public boolean calculateCorrectBonus(List<Integer> userNumbers, int bonusNumber) {
        return userNumbers.contains(bonusNumber);
    }
}
