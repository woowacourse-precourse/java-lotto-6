package lotto;

import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @DisplayName("숫자가 아닌 문자가 포함되어 있을 때 예외가 발생한다.")
    @Test
    void typeTest() {
        assertThatThrownBy(() ->
                WinningLotto.of("hi,1,2,3,4,5", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1보다 작거나 45보다 큰 수가 포함되어 있을 때 예외가 발생한다.")
    @Test
    void rangeTest() {
        assertThatThrownBy(() ->
                WinningLotto.of("1,2,3,4,5,6", "48"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있을 때 예외가 발생한다.")
    @Test
    void dupTest() {
        assertThatThrownBy(() ->
                WinningLotto.of("1,2,3,4,5,6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
