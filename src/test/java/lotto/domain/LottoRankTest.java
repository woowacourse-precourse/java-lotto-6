package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRankTest {
    @Test
    @DisplayName("보너스 번호 없이 올바른 등수 반환")
    void 보너스_번호_없이_올바른_등수_반환() {
        assertEquals(LottoRank.FIRST, LottoRank.valueOf(6, false));
    }

    @Test
    @DisplayName("보너스 번호가 있는 경우 올바른 등수 반환")
    void 보너스_번호가_있는_경우_올바른_등수_반환() {
        assertEquals(LottoRank.SECOND, LottoRank.valueOf(5, true));
    }

    @Test
    @DisplayName("일치하는 번호가 없는 경우 NONE 반환")
    void 일치하는_번호가_없는_경우_NONE_반환() {
        assertEquals(LottoRank.NONE, LottoRank.valueOf(0, false));
    }
}