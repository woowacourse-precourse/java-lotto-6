package lotto.domain;

import java.util.Optional;

public record MatchResult(int matchCount, boolean matchBonus) {

    public Optional<LottoRank> getRank() {
        return LottoRank.valueOf(matchCount, matchBonus);
    }

}