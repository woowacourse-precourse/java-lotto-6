package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    @DisplayName("보너스 번호가 당첨 번호 중 하나와 중복이라면 예외가 발생한다.")
    @Test
    void save() {
        assertThatThrownBy(() -> new Bonus().save("1", List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate() {
    }

    @Test
    void removeEmpty() {
    }

    @Test
    void translateToValueType() {
    }
}
