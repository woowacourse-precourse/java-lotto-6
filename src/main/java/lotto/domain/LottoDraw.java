package lotto.domain;

import java.util.List;

public class LottoDraw {
    private final Lotto winningLotto;
    private final Bonus winningBonus;

    private LottoDraw(Lotto lotto, Bonus bonus) {
        this.winningLotto = lotto;
        this.winningBonus = bonus;
    }

    public static LottoDraw of(Lotto lotto, Bonus bonus) {
        return new LottoDraw(lotto, bonus);
    }

    public int countMatchingNumbersWith(Lotto lotto) {
        List<Integer> winningNumbers = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();

        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean hasMatchingBonusNumberWith(Lotto lotto) {
        int bonusNumber = winningBonus.getNumber();
        List<Integer> lottoNumbers = lotto.getNumbers();

        return lottoNumbers.stream()
                .anyMatch(number -> number == bonusNumber);
    }
}
