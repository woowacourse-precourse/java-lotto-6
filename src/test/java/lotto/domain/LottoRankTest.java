package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoRank 클래스")
class LottoRankTest {

    @DisplayName("로또 순위 반환 테스트")
    @Test
    void testLottoRank() {
        // given & when
        LottoRank first = LottoRank.of(6, false);
        LottoRank second = LottoRank.of(5, true);
        LottoRank third = LottoRank.of(5, false);
        LottoRank fourth = LottoRank.of(4, false);
        LottoRank fifth = LottoRank.of(3, false);
        LottoRank none = LottoRank.of(2, true);

        // then
        assertThat(first).isEqualTo(LottoRank.FIRST);
        assertThat(second).isEqualTo(LottoRank.SECOND);
        assertThat(third).isEqualTo(LottoRank.THIRD);
        assertThat(fourth).isEqualTo(LottoRank.FOURTH);
        assertThat(fifth).isEqualTo(LottoRank.FIFTH);
        assertThat(none).isEqualTo(LottoRank.NONE);
    }

    @DisplayName("로또 순위 상세 정보 확인 테스트")
    @Test
    void testLottoRankDetails() {
        // given
        LottoRank rank = LottoRank.FIRST;

        // then
        assertThat(rank.getMatchCount()).isEqualTo(6);
        assertThat(rank.hasBonusNumber()).isFalse();
        assertThat(rank.getPrize()).isEqualTo(2_000_000_000L);
    }
}
