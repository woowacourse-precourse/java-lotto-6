package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three", "yoon", "su"})
    void 보너스_번호가_숫자가_아니면_IllegalArgumentException_예외처리_검증(String bonusNumberInput) {
        assertThatThrownBy(() ->BonusNumber.from(bonusNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자여야 합니다.");

    }
}
