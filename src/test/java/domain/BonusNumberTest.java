package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class BonusNumberTest {
    @ParameterizedTest
    @DisplayName("보너스번호을 올바르게 입력한 경우 예외가 발생하지 않는다.")
    @CsvSource("40")
    void givenNormalBonus_thenSuccess(final int bonusNumber) {
        Assertions.assertThat(BonusNumber.create(bonusNumber))
                .isInstanceOf(BonusNumber.class);

        assertThatCode(() -> BonusNumber.create(bonusNumber))
                .doesNotThrowAnyException();
    }
}
