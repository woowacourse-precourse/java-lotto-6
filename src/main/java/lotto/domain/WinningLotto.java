package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }


    public Rank getRank(Lotto playerLotto) {
        int matchNumber = playerLotto.compareWinningLottoNumbers(winningNumbers);
        boolean isCorrectBonusNumber = playerLotto.isCorrectBonusNumber(bonusNumber);

        return Rank.getRank(matchNumber, isCorrectBonusNumber);
    }
}