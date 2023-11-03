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

    private int comparePlayerLottoNumbers(Lotto playerLotto) {
        int matchNumber = 0;
        List<Integer> playerLottoNumbers = playerLotto.getNumbers();

        for (Integer playerLottoNumber : playerLottoNumbers) {
            if (winningNumbers.contains(playerLottoNumber))
                matchNumber++;
        }

        return matchNumber;
    }

    private boolean isCorrectBonusNumber(Lotto playerLotto) {
        return playerLotto.isCorrectBonusNumber(bonusNumber);
    }

    public Rank getRank(Lotto playerLotto) {
        int matchNumber = comparePlayerLottoNumbers(playerLotto);
        boolean isCorrectBonusNumber = isCorrectBonusNumber(playerLotto);

        return Rank.getRank(matchNumber, isCorrectBonusNumber);
    }
}