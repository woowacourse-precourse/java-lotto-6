package lotto.service;

import java.util.List;
import lotto.config.WiningRank;

public interface Judgement {
    public int judgeWiningNumber(List<Integer> lotto, List<Integer> winingNumber);

    public boolean judgeBonusNumber(List<Integer> lotto, int bonusNumber);

    public WiningRank judgeRanking(int winingNumberCount, boolean bonusNumCount);
}
