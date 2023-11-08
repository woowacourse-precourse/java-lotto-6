package lotto.model;

import java.util.HashMap;
import java.util.Map;

import lotto.model.Judgement.Prize;

public class LottoRankRecorder {
    private Map<Prize, Integer> rankRecord = new HashMap<>();

    public LottoRankRecorder() {
        for (Prize prize : Prize.values()) {
            rankRecord.put(prize, 0);
        }
    }

    public void recordRank(Prize prize) {
        int currentCount = rankRecord.get(prize);
        rankRecord.put(prize, currentCount + 1);
    }

    public Map<Prize, Integer> getRankRecord() {
        return rankRecord;
    }
}
