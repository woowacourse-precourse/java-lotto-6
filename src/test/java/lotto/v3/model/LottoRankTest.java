package lotto.v3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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

}