package lotto.domain.dto;

import java.util.Optional;
import lotto.domain.LottoRank;

public record MatchResult(int matchCount, boolean matchBonus) {

    public Optional<LottoRank> getRank() {
        return LottoRank.valueOf(matchCount, matchBonus);
    }

}