package lotto.domain;

import lotto.constant.LottoRank;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;

    private int bonusNumber;

    public WinningLotto(List<Integer> numbers) {
        this.lotto = new Lotto(numbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculateRank(Lotto lotto) {
        return LottoRank.OUT_RANK;
    }
}
