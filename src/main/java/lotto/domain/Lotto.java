package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.vo.BonusNumber;
import lotto.vo.WinningNumbers;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("Lotto numbers must be exactly 6.");
        }
    }

    public Rank matchRank(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        int matchCount = calculateMatchCount(winningNumbers);
        boolean matchBonus = containsBonusNumber(bonusNumber);

        return Rank.determineRank(matchCount, matchBonus);
    }

    private int calculateMatchCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isContained)
                .count();
    }

    private boolean containsBonusNumber(BonusNumber bonusNumber) {
        return bonusNumber.isContainedIn(numbers);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
