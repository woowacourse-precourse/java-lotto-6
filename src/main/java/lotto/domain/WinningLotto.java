package lotto.domain;

import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public void storeWinningLottos(List<Integer> winningLottoNumbers) {
        winningLotto = new Lotto(winningLottoNumbers);
    }

    public void storeBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
