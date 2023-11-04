package lotto.bonus;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @DisplayName("보너스 번호를 정수로 입력하지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"12.1", "abc"})
    @ParameterizedTest
    void createBonusNumberByNotInteger(String number) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 1 ~ 45인 숫자가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"-1", "0", "46"})
    @ParameterizedTest
    void createBonusNumberByWrongRangeNumber(String number) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
