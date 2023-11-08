package lotto;

import lotto.prize.*;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;
    public Lottos() {
        lottos = new ArrayList<>();
    }
    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    public List<MatchResult> calculateResults(Jackpot jackpot) {
        return lottos.stream()
                .map(lotto -> {
                    int matchCount = jackpot.countNumberOfHits(lotto);
                    boolean bonusMatch = jackpot.isBonusBallHit(lotto);
                    Rank rank = Rank.valueOf(matchCount, bonusMatch);
                    return new MatchResult(rank);
                })
                .collect(Collectors.toList());
    }
}
