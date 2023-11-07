package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    void 잘못된_count와_boolean값_전달하면_오류발생() {
        assertThatThrownBy(() -> LottoRank.from(-1, true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 알맞은_인수로_count와_boolean값_전달하면_SECOND와_THIRD반환() {
        assertThat(LottoRank.from(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.from(5, false)).isEqualTo(LottoRank.THIRD);
    }

    @Test
    void SECOND_THIRD제외하면_boolean값_상관없이_각각_알맞은LottoRank반환() {
        assertThat(LottoRank.from(6, true)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.from(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.from(0, false)).isEqualTo(LottoRank.LOSE);
        assertThat(LottoRank.from(0, true)).isEqualTo(LottoRank.LOSE);
    }
}
