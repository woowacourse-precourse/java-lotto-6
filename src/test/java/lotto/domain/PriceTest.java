package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    @DisplayName("로또 구입 금액은 숫자여야 합니다.")
    public void PriceTest() {
        Assertions.assertThatThrownBy(() -> new Price("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}