package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("매칭된 숫자 개수에 맞는 랭크 반환.")
    @Test
    void getRankByMatchingNumbersAndBonus() {
        assertThat(Rank.getRankByMatchingNumbersAndBonus(6, true)).isEqualTo(Rank.FIRST);
    }

    @DisplayName("매칭 개수가 5개이고 보너스 넘버가 포함되어 있을 때 2등 랭크 반환.")
    @Test
    void getRankByNumberFiveAndBonus() {
        assertThat(Rank.getRankByMatchingNumbersAndBonus(5, true)).isEqualTo(Rank.SECOND);
    }

    @DisplayName("매칭 개수가 3-6에 해당하는 정수가 아니면 무당첨 랭크 반환.")
    @Test
    void getRankByOutOfRangeMatchingNumber() {
        assertThat(Rank.getRankByMatchingNumbersAndBonus(2, true)).isEqualTo(Rank.NONE);
    }
}