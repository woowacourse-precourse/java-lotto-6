package lotto.constant;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.constant.ErrorMessage.ENTER_PROPER_SAME_COUNT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @Test
    @DisplayName("로또 순위를 올바르게 반환하는지 테스트")
    void getRank() {
        LottoRank result1 = LottoRank.getRank(6, false); //1등
        LottoRank result2 = LottoRank.getRank(5, false); //3등
        LottoRank result3 = LottoRank.getRank(2, true); //꽝

        assertThat(result1).isEqualTo(LottoRank.FIRST);
        assertThat(result2).isEqualTo(LottoRank.THIRD);
        assertThat(result3).isEqualTo(LottoRank.NO_LUCK);

        Assertions.assertThatThrownBy(() -> LottoRank.getRank(80, false))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ENTER_PROPER_SAME_COUNT);
    }
}