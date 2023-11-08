package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import lotto.enums.Rank;

public class LottoGame {

    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoGame() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void play(WinningLotto winningLotto, LottoTickets lottoTickets) {
        Lotto winning = winningLotto.getLotto();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            addResult(winning.matchCount(lotto), lotto.contains(bonusNumber));
        }
    }

    private void addResult(int matchCount, boolean isBonus) {
        if (matchCount == 3) {
            result.put(Rank.FIFTH, result.get(Rank.FIFTH) + 1);
        }
        if (matchCount == 4) {
            result.put(Rank.FOURTH, result.get(Rank.FOURTH) + 1);
        }
        if (matchCount == 5) {
            if (isBonus) {
                result.put(Rank.SECOND, result.get(Rank.SECOND) + 1);
            }
            if (!isBonus) {
                result.put(Rank.THIRD, result.get(Rank.THIRD) + 1);
            }
        }
        if (matchCount == 6) {
            result.put(Rank.FIRST, result.get(Rank.FIRST) + 1);
        }
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
