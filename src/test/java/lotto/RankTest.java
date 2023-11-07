package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RankTest {
    @DisplayName("MatchCount = 3, matchBonus = false 이면 Rank.FIFTH 가 반환된다.")
    @Test
    void getRankFIFTH() {
        assertThat(Rank.FIFTH).isEqualTo(Rank.getRank(3, false));
    }

    @DisplayName("MatchCount = 4, matchBonus = false 이면 Rank.FOURTH 가 반환된다.")
    @Test
    void getRankFOURTH() {
        assertThat(Rank.FOURTH).isEqualTo(Rank.getRank(4, false));
    }

    @DisplayName("MatchCount = 5, matchBonus = false 이면 Rank.THIRD 가 반환된다.")
    @Test
    void getRankTHIRD() {
        assertThat(Rank.THIRD).isEqualTo(Rank.getRank(5, false));
    }

    @DisplayName("MatchCount = 3, matchBonus = false 이면 Rank.FIFTH가 반환된다.")
    @Test
    void getRankSECOND() {
        assertThat(Rank.SECOND).isEqualTo(Rank.getRank(5, true));
    }

    @DisplayName("MatchCount = 6, matchBonus = false 이면 Rank.FIRST 가 반환된다.")
    @Test
    void getRankFIRST() {
        assertThat(Rank.FIRST).isEqualTo(Rank.getRank(6, false));
    }

    @DisplayName("MatchCount가 어디에도 속하지 않으면 EMPTY가 반환된다.")
    @Test
    void getRankEMPTY() {
        assertThat(Rank.EMPTY).isEqualTo(Rank.getRank(1, false));
    }

    @DisplayName("MatchCount = 4, matchBonus = true 이면 Rank.FOURTH가 반환된다.")
    @Test
    void getRankFOURTHWithBonus() {
        assertThat(Rank.FOURTH).isEqualTo(Rank.getRank(4, true));
    }

    @DisplayName("MatchCount = 3, matchBonus = true 이면 Rank.FIFTH가 반환된다.")
    @Test
    void getRankFIFTHWithBonus() {
        assertThat(Rank.FIFTH).isEqualTo(Rank.getRank(3, true));
    }
}
