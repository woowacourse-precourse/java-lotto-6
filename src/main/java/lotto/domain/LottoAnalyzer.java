package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.List;

public class LottoAnalyzer {
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoAnalyzer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void addWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void addBonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
        }
    }

    public void analyzeLotto() {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int match = (int) winningNumbers.stream().filter(lottoNumbers::contains)
                    .distinct()
                    .count();
            boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);
            LottoRank lottoRank = LottoRank.getRank(match, hasBonusNumber);
        }
    }
}
