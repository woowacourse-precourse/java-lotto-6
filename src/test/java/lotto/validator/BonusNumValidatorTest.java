package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumValidatorTest {
    @DisplayName("보너스 번호가 정수가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberByCharacter() {
        assertThatThrownBy(() -> BonusNumValidator.validate("보너스 번호"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1에서 45사이의 수가 아니면 예외가 발생한다.")
    @Test
    void createBonusNumberOverRange() {
        assertThatThrownBy(() -> BonusNumValidator.validate("51"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
