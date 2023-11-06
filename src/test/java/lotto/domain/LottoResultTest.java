package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {
    @Test
    @DisplayName("1등 확인")
    void _1등_확인() {
        LottoResult result = LottoResult.valueOf(6, false);
        assertThat(result).isEqualTo(LottoResult.FIRST);
    }

    @Test
    @DisplayName("2등 확인")
    void _2등_확인() {
        LottoResult result = LottoResult.valueOf(5, true);
        assertThat(result).isEqualTo(LottoResult.SECOND);
    }

    @Test
    @DisplayName("3등 확인")
    void _3등_확인() {
        LottoResult result = LottoResult.valueOf(5, false);
        assertThat(result).isEqualTo(LottoResult.THIRD);
    }

    @Test
    @DisplayName("4등 확인")
    void _4등_확인() {
        LottoResult result = LottoResult.valueOf(4, false);
        assertThat(result).isEqualTo(LottoResult.FOURTH);
    }

    @Test
    @DisplayName("5등 확인")
    void _5등_확인() {
        LottoResult result = LottoResult.valueOf(3, false);
        assertThat(result).isEqualTo(LottoResult.FIFTH);
    }

    @Test
    @DisplayName("꼴등 확인")
    void _꼴등_확인_1() {
        LottoResult result = LottoResult.valueOf(2, false);
        assertThat(result).isEqualTo(LottoResult.MISS);
    }

    @Test
    @DisplayName("꼴등 확인")
    void _꼴등_확인_2() {
        LottoResult result = LottoResult.valueOf(1, false);
        assertThat(result).isEqualTo(LottoResult.MISS);
    }

    @Test
    @DisplayName("꼴등 확인")
    void _꼴등_확인_3() {
        LottoResult result = LottoResult.valueOf(0, false);
        assertThat(result).isEqualTo(LottoResult.MISS);
    }
}