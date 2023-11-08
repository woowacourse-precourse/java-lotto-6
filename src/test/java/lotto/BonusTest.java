package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusTest {

    private Bonus bonus;

    @BeforeEach
    void init() {
        bonus = new Bonus();
    }

    @DisplayName("보너스 번호가 당첨 번호 중 하나와 중복이라면 예외가 발생한다.")
    @Test
    void save() {
        assertThatThrownBy(() -> bonus.save("1", List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate() {
    }

    @DisplayName("보너스 번호에 공백이 존재할 시 무시한다.")
    @Test
    void removeEmpty() {
        String EmptyContained = new String("1 2");
        String noEmptyContained = bonus.removeEmpty(EmptyContained);
        Assertions.assertThat(noEmptyContained).isEqualTo("12");
    }

    @Test
    void translateToValueType() {
    }
}
