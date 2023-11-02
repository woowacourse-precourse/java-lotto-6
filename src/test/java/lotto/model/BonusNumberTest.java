package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("생성 테스트 : 보너스 숫자가 1보다 작으면 예외가 발생한다.")
    @Test
    void createBonusNumberByBelowMinRange() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("생성 테스트 : 보너스 숫자가 45보다 크면 예외가 발생한다.")
    @Test
    void createBonusNumberByOverMaxRange() {
        assertThatThrownBy(() -> new BonusNumber(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("생성 테스트 : int형 필드를 가지는 보너스 숫자를 생성한다.")
    @Test
    void createBonusNumber() {
        assertThatCode(() -> new BonusNumber(5))
                .doesNotThrowAnyException();
    }
}