package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DrawingMachine {
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public DrawingMachine(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public DrawResult compare(Lottos lottos) {
        Map<LottoRank, Integer> rankMap = new LinkedHashMap<>();
        InitiateMap(rankMap);
        for (Lotto lotto : lottos.getLottos()) {
            int count = winningLotto.compare(lotto);
            boolean hasBonus = lotto.contains(bonusNumber.getNumber());
            LottoRank lottoRank = LottoRank.from(count, hasBonus);
            rankMap.replace(lottoRank, rankMap.get(lottoRank) + 1);
        }
        return new DrawResult(rankMap);
    }

    private static void InitiateMap(Map<LottoRank, Integer> rankMap) {
        for (LottoRank value : LottoRank.values()) {
            rankMap.put(value, 0);
        }
    }
}
