package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {

    Winning winning = new Winning("1,2,3,4,5,6");

    @DisplayName("입력한 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void constructorNonNumericTest() {
        assertThatThrownBy(() -> new Bonus(winning, "pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 45보다 크면 예외가 발생한다.")
    @Test
    void constructorOverTest() {
        assertThatThrownBy(() -> new Bonus(winning, "50"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1보다 작으면 예외가 발생한다.")
    @Test
    void constructorUnderTest() {
        assertThatThrownBy(() -> new Bonus(winning, "0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다.")
    @Test
    void constructorDuplicateTest() {
        assertThatThrownBy(() -> new Bonus(winning, "1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
