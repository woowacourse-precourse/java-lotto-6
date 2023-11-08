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

    @Test
    @DisplayName("로또 구입 금액은 숫자여야 합니다.")
    public void PriceTest2() {
        Assertions.assertThatThrownBy(() -> new Price("+"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액은 숫자여야 합니다.")
    public void PriceTest3() {
        Assertions.assertThatThrownBy(() -> new Price("?"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 구입 금액은 숫자여야 합니다.")
    public void PriceTest4() {
        Assertions.assertThatThrownBy(() -> new Price("100"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("로또 구입 금액은 숫자여야 합니다.")
    public void PriceTest5() {
        new Price("1000");
    }
}