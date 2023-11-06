package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ExceptionMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, -1})
    void createBonusNumberByOutOfRange(int bonusNumber) {
        assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.OUT_OF_RANGE_NUMBER_EXCEPTION.getMessage());
    }

    @DisplayName("보너스 번호가 1 ~ 45 사이의 숫자이면 보너스 번호가 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 23})
    void createBonusNumberByInRange(int bonusNumber) {
        BonusNumber bonusNumberObject = new BonusNumber(bonusNumber);
        Assertions.assertThat(bonusNumberObject).isNotNull();
    }
}
