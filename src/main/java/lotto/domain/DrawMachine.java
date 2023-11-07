package lotto.domain;

import static lotto.domain.DrawResult.getResult;

public class DrawMachine {
    private final WinningLottoNumbers winningLottoNumbers;

    public DrawMachine(WinningLottoNumbers winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    private DrawResult draw(Lotto userLotto) {
        int matchingCount = winningLottoNumbers.getMatchingCount(userLotto);
        boolean containBonusNumber = winningLottoNumbers.containBonusNumber(userLotto);
        return getResult(matchingCount, containBonusNumber);
    }
}
