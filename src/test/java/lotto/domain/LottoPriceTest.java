package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoPriceTest {

    @DisplayName("로또 금액에 문자가 입력될 경우 예외가 발생한다.")
    @Test
    void createLottoPriceByString() {
        assertThatThrownBy(() -> new LottoPrice("Nbowow"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 금액이 1000의 배수가 아닐경우 예외가 발생한다.")
    @Test
    void createLottoPriceByMultiple() {
        assertThatThrownBy(() -> new LottoPrice("2400"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 금액이 양수가 아닌 값이 입력 될 경우 예외가 발생한다.")
    @Test
    void createLottoPriceByNotPositiveNumber() {
        assertThatThrownBy(() -> new LottoPrice("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
