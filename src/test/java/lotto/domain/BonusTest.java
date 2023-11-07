package lotto.domain;

import static lotto.util.ErrorMessage.NOT_IN_RANGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.lotto.Bonus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {

    @DisplayName("보너스 타입에 1-45 가 아닌 숫자가 들어오면 에러 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 47, 46, 100})
    public void validateBonusInRange(int bonusNumber) {
        // when & then
        assertThatThrownBy(() -> new Bonus(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_RANGE.getMessage());
    }
}
