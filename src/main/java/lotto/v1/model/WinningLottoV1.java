package lotto.v1.model;

import java.util.List;

public class WinningLottoV1 {
    private final LottoV1 lotto;
    private final int bonusNumber;

    public WinningLottoV1(List<Integer> winningNumbers, int bonusNumber) {
        this.lotto = new LottoV1(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoV1 getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    // TODO : 당첨 확인 로직 추가.
}

