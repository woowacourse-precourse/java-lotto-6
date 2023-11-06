package lotto.domain;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import lotto.constants.Prize;

public class Lottos {

    List<Lotto> lottos;
    HashMap<String, Integer> gameResult = new HashMap<>();

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void calculateGameResult(BitSet winningNumberBitSet, BonusNumber bonusNumber) {
        lottos.forEach(lotto -> {
            Prize prize = matchRank(lotto.getWinningCount(winningNumberBitSet), lotto.containsBonus(bonusNumber));
            gameResult.put(prize.name(), gameResult.getOrDefault(prize.name(), 0) + 1);
        });
    }

    public Prize matchRank(int winningCount, boolean isBonusNumber) {
        return Arrays.stream(Prize.values())
            .filter(prize -> prize.match(winningCount, isBonusNumber))
            .findFirst()
            .orElse(Prize.NONE);
    }

    public int getPrizeCount(Prize prize) {
        return gameResult.getOrDefault(prize.name(), 0);
    }

    public int getPrizeMoney() {
        return Arrays.stream(Prize.values())
            .mapToInt(prize -> prize.getPrize() * getPrizeCount(prize))
            .sum();
    }


}
