package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    
    @Test
    void 보너스_번호를_생성한다() {
        // given
        BonusNumber bonusNumber = new BonusNumber("7");

        // then
        Assertions.assertThat(bonusNumber).isEqualTo(new BonusNumber("7"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "0"})
    void 입력이_잘못되면_예외가_발생한다(String bonusNumber) {
        // when
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
