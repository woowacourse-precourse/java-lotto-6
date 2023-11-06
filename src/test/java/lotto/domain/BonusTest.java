package lotto.domain;

import static lotto.util.ErrorMessage.INPUT_NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {

    @DisplayName("")
    @ParameterizedTest
    @ValueSource(ints = {0, 47, 46, 100})
    public void validateBonusInRange(int bonusNumber) {
        // when & then
        assertThatThrownBy(() -> new Bonus(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_NOT_IN_RANGE.getMessage());
    }
}
