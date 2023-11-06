package lotto.utils;

import static lotto.utils.Constant.LOTTO_SIZE;
import static lotto.utils.Constant.MAX_LOTTO;
import static lotto.utils.Constant.MIN_LOTTO;
import static lotto.utils.Constant.MIN_MONEY;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConstantTest {
    @DisplayName("상수 값을 테스트 합니다.")
    @Test
    public void testConstantValues() {
        assertThat(MIN_MONEY.getValue()).isEqualTo(1000);
        assertThat(MIN_LOTTO.getValue()).isEqualTo(1);
        assertThat(MAX_LOTTO.getValue()).isEqualTo(45);
        assertThat(LOTTO_SIZE.getValue()).isEqualTo(6);
    }
}