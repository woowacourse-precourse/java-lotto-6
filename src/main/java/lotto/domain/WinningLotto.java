package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningLotto extends Lotto {

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        super(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int comparePlayerLottoNumbers(List<Integer> playerLottoNumbers) {
        int matchNumber = 0;

        for (Integer playerLottoNumber : playerLottoNumbers) {
            if (winningNumbers.contains(playerLottoNumber))
                matchNumber++;
        }

        return matchNumber;
    }

    public boolean isCorrectBonusNumber(List<Integer> playerLottoNumbers) {
        return playerLottoNumbers.contains(bonusNumber);
    }
}
