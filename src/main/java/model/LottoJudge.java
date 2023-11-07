package model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;

public interface LottoJudge {
    public abstract EnumMap<Rank, Integer> judgeLotto(Lotto userLotto, int bonusNumber);
    public List<Integer[]> getComputerLottos();
}
