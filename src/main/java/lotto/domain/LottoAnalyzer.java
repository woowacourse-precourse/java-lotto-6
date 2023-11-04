package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.List;

public class LottoAnalyzer {
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;

    public LottoAnalyzer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void addBonusNumber(int bonusNumber) {
        validate(bonusNumber);
    }

    private void validate(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
        }
    }
}
