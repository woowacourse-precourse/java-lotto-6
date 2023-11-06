package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    private static final int INIT_RANKS_VALUE = 1;
    private static final int INCREASE_RANKS_VALUE = 1;
    private static final int MIN_NUMBER_RANGE = 1;
    private static final int MAX_NUMBER_RANGE = 45;

    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoManager(List<Integer> lottoNumbers, int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.winningLotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank,Integer> getLottosRanks(List<Lotto> lottos) {
        Map<Rank,Integer> ranks = new HashMap<>();
        for (Lotto lotto : lottos) {
            Rank rank = Rank.decideRank(getSameNumberCount(lotto), isContainBonusNumber(lotto, bonusNumber));
            updateRanksValue(ranks, rank);
        }
        return ranks;
    }

    private int getSameNumberCount(Lotto lotto) {
        return lotto.countSameNumber(winningLotto);
    }

    private boolean isContainBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.isContain(bonusNumber);
    }

    private void updateRanksValue(Map<Rank, Integer> ranks, Rank rank) {
        if (!ranks.containsKey(rank)) {
            ranks.put(rank, INIT_RANKS_VALUE);
            return;
        }
        ranks.put(rank, ranks.get(rank) + INCREASE_RANKS_VALUE);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER_RANGE || bonusNumber > MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
