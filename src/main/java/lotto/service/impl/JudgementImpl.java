package lotto.service.impl;

import static lotto.config.WiningRank.NOTHING;
import static lotto.config.WiningRank.RANK1;
import static lotto.config.WiningRank.RANK2;
import static lotto.config.WiningRank.RANK3;
import static lotto.config.WiningRank.RANK4;
import static lotto.config.WiningRank.RANK5;

import java.util.List;
import lotto.config.WiningRank;
import lotto.service.Judgement;

public class JudgementImpl implements Judgement {
    @Override
    public int judgeWiningNumber(List<Integer> lotto, List<Integer> winingNumber) {
        int count = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if (lotto.contains(winingNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean judgeBonusNumber(List<Integer> lotto, int bonusNumber) {
        return lotto.contains(bonusNumber);
    }

    @Override
    public WiningRank judgeRanking(int winingNumberCount, boolean bonusNumCount) {
        if (winingNumberCount == 6) {
            return RANK1;
        }
        if (winingNumberCount == 5 && bonusNumCount) {
            return RANK2;
        }
        if (winingNumberCount == 5) {
            return RANK3;
        }
        if (winingNumberCount == 4) {
            return RANK4;
        }
        if (winingNumberCount == 3) {
            return RANK5;
        }
        return NOTHING;
    }
}
