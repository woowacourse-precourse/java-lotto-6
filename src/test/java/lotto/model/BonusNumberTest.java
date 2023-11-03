package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class BonusNumberTest {

    @DisplayName("보너스 번호가 포함되어 있는지 테스트 : List에 보너스 번호가 포함되어 있지 않으면 false를 반환한다.")
    @Test
    void notExistInt() {
        BonusNumber bonusNumber = new BonusNumber(6);

        boolean result = bonusNumber.existIn(List.of(1, 2, 3, 4, 5, 7));

        assertThat(result).isFalse();
    }

    @DisplayName("보너스 번호가 포함되어 있는지 테스트 : List에 보너스 번호가 포함되어 있으면 true를 반환한다.")
    @Test
    void existIn() {
        BonusNumber bonusNumber = new BonusNumber(6);

        boolean result = bonusNumber.existIn(List.of(1, 2, 3, 4, 5, 6));

        assertThat(result).isTrue();
    }

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