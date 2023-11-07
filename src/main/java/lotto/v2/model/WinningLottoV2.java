package lotto.v2.model;

import java.util.List;

public class WinningLottoV2 {
    private final LottoV2 lotto;
    private final int bonusNumber;

    public WinningLottoV2(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = new LottoV2(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoV2 getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}

