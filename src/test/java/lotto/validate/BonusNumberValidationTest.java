package lotto.validate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BonusNumberValidationTest {
    private final LottoValidation lottoValidation = new BonusNumberValidation();

    @DisplayName("입력한 보너스 번호가 1~45 사이의 번호가 아니라면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "46", "0"})
    void bonusNumberValidationTest(String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("입력한 값이 숫자가 아니라면 false를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"가", "a", " "})
    void bonusNumberValidationTest2(String value) {
        // when
        boolean result = lottoValidation.validate(value);
        // then
        assertThat(result).isFalse();
    }
}