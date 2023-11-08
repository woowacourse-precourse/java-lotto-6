package lotto;

import consts.Rank;

import java.util.List;

public class LottoAnswer {
    private final Lotto lottoAnswer;
    private int bonusNumber;

    public LottoAnswer(List<Integer> numbers, int bonusNumber) {
        this.lottoAnswer = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank compareAndReturnRank(Lotto lotto) {
        return Rank.of(this.countOfMatch(lotto), this.isContainBonusNumber(lotto));
    }

    private int countOfMatch(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this::isContain).count();
    }

    private boolean isContainBonusNumber(Lotto lotto) {
        return lotto.isContain(bonusNumber);
    }

    private boolean isContain(int number) {
        return lottoAnswer.isContain(number);
    }
}
