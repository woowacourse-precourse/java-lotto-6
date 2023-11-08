package lotto.model;

import lotto.Lotto;
import lotto.utils.Validator;

public class WinningNumbers {
    private final Lotto winningNumbers;
    private final int bonus;

    public WinningNumbers(Lotto winningLotto, int bonus) {
        validateParameters(winningLotto, bonus);

        this.winningNumbers = winningLotto;
        this.bonus = bonus;
    }

    private void validateParameters(Lotto winningLotto, int bonus) {
        if (winningLotto.isContain(bonus)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
        }
        Validator.validateLottoNumberRange(bonus);
    }

    public Rank oneCompare(Lotto lotto) {
        return Rank.getRankByMatchCount(lotto.matchCount(winningNumbers), lotto.isContain(bonus));
    }

    @Override
    public String toString() {
        return "WinningLottoNumbers{" +
                "winningLotto=" + winningNumbers +
                ", bonus=" + bonus +
                '}';
    }
}
