package lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult() {
        result = new EnumMap<Rank, Integer>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> result.put(rank, 0));
    }

    public void resultLogic(WinningLottoNumbers winningLottoNumbers, GroupLotto groupLotto) {
        for (Lotto lotto : groupLotto.getLottos()) {
            Rank rank = Rank.getRank(lotto.getCountMatchNumbers(winningLottoNumbers),
                    lotto.numberContain(winningLottoNumbers.getBonusNumber()));
            rankCount(rank);
        }
    }

    private void rankCount(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Integer getRankCount(Rank rank) {
        return result.get(rank);
    }
}
