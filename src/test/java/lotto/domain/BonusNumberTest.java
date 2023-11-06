package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @ParameterizedTest
    @DisplayName("보너스 번호가 1부터 45사이의 숫자가 아니라면 예외 발생")
    @ValueSource(ints = {66})
    void bonusNumberOutOfRange(int bonusNumber) {
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}