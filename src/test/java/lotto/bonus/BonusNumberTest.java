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

}
