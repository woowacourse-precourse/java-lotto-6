package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoSettingTest {
    @DisplayName("로또 숫자 범위 최솟값은 1이다.")
    @Test
    void testNumberRangeStart() {
        assertThat(LottoSetting.NUMBER_RANGE_START.getValue())
                .isEqualTo(1);
    }

    @DisplayName("로또 숫자 범위 최댓값은 45다.")
    @Test
    void testNumberRangeEnd() {
        assertThat(LottoSetting.NUMBER_RANGE_END.getValue())
                .isEqualTo(45);
    }

    @DisplayName("로또 1장은 6개의 숫자를 가진다.")
    @Test
    void testNumberCount() {
        assertThat(LottoSetting.NUMBER_COUNT.getValue())
                .isEqualTo(6);
    }

    @DisplayName("로또 1장 가격은 1000원이다.")
    @Test
    void testPrice() {
        assertThat(LottoSetting.PRICE.getValue())
                .isEqualTo(1000);
    }


    @DisplayName("로또 당첨 종류는 5가지이다.")
    @Test
    void testWinningTypeCount() {
        assertThat(LottoSetting.WINNING_TYPE_COUNT.getValue())
                .isEqualTo(5);
    }
}