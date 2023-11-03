package model;

import java.util.List;
import lotto.Lotto;

public interface LottoJudge {
    public abstract int[] judgeLotto(Lotto userLotto, int bonusNumber);
    public List<Integer[]> getComputerLottos();
}
