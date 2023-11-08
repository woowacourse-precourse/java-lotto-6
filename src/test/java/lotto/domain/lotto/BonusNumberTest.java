package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BonusNumber 클래스")
class BonusNumberTest {

    @DisplayName("번호가 1 미만 45 초과라면 예외를 발생한다")
    @Test
    void createNumberByOutOfRange() {
        assertThatThrownBy(() -> BonusNumber.from(0))
            .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BonusNumber.from(46))
            .isInstanceOf(IllegalArgumentException.class);
    }
}