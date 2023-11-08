package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningTest {

    @DisplayName("입력한 번호 중 숫자가 아닌 번호가 있다면 예외가 발생한다.")
    @Test
    void constructorNonMumericTest() {
        assertThatThrownBy(() -> new Winning("1,2,3,4,5,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호 중 45보다 큰 숫자가 있다면 예외가 발생한다.")
    @Test
    void constructorOverTest() {
        assertThatThrownBy(() -> new Tickets("1,2,3,4,5,46"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호 중 1보다 작은 숫자가 있다면 예외가 발생한다.")
    @Test
    void constructorUnderTest() {
        assertThatThrownBy(() -> new Tickets("0,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호 중 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void constructorDuplicateTest() {
        assertThatThrownBy(() -> new Tickets("1,1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 번호가 6개가 아니면 예외가 발생한다.")
    @Test
    void constructorNumberTest() {
        assertThatThrownBy(() -> new Tickets("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
