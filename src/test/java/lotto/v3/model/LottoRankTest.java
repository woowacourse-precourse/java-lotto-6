package lotto.v3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("보너스 번호 없이 일치하는 개수에 대한 올바른 로또 순위를 반환해야 함")
    void shouldReturnCorrectLottoRankForMatchingCountsWithoutBonus() {
        // given
        int matchCountForThird = 5;
        boolean bonusMatchForThird = false;

        // when
        LottoRank result = LottoRank.valueOf(matchCountForThird, bonusMatchForThird);

        // then
        assertThat(result).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("보너스 번호가 포함된 일치하는 개수에 대한 올바른 로또 순위를 반환해야 함")
    void shouldReturnCorrectLottoRankForMatchingCountsWithBonus() {
        // given
        int matchCountForSecond = 5;
        boolean bonusMatchForSecond = true;

        // when
        LottoRank result = LottoRank.valueOf(matchCountForSecond, bonusMatchForSecond);

        // then
        assertThat(result).isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("해당하는 LottoRank가 없는 매치 카운트에 대해 IllegalArgumentException을 발생시켜야 함")
    void shouldThrowExceptionForInvalidMatchingCount() {
        // given
        int invalidMatchCount = 2;
        boolean bonusMatch = false;

        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoRank.valueOf(invalidMatchCount, bonusMatch))
                .withMessageContaining("[ERROR] 일치하는 로또 순위가 없습니다.");
    }

    @Test
    @DisplayName("매치 카운트가 필요하지 않은 경우 보너스 매치를 고려하지 않아야 함")
    void shouldNotConsiderBonusIfNotRequiredByMatchCount() {
        // given
        int matchCountForFifth = 3;
        boolean bonusMatchForFifth = true;

        // when
        LottoRank result = LottoRank.valueOf(matchCountForFifth, bonusMatchForFifth);

        // then
        assertThat(result).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("최대 일치 횟수에 대해 보너스를 고려하지 않고 FIRST를 반환해야 함")
    void shouldReturnFirstForMaxMatchingCount() {
        // given
        int matchCountForFirst = 6;
        boolean bonusMatchForFirst = false; 

        // when
        LottoRank result = LottoRank.valueOf(matchCountForFirst, bonusMatchForFirst);

        // then
        assertThat(result).isEqualTo(LottoRank.FIRST);
    }

}