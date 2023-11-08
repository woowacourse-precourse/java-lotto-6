package lotto.domain;

import java.util.List;

public class LottoAnswer {
    private final Lotto winningNumbers;
    private final BonusNumber bounsNumber;

    public LottoAnswer(Lotto winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers.getNumbers(), bonusNumber.getValue());
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복됩니다.");
        }
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBounsNumber() {
        return bounsNumber;
    }
}
