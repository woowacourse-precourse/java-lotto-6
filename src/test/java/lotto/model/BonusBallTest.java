package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.common.exception.ErrorMessage;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusBallTest {
    @Nested
    class 보너스볼_생성시 {

        @Test
        void 성공적으로_생성한다() {
            //given
            int number = 1;
            //when
            BonusBall bonusBall = new BonusBall(number);
            //then
            assertThat(bonusBall.getNumber()).isEqualTo(number);
        }

        @ValueSource(ints = {0, 46})
        @ParameterizedTest
        void 번호가_1부터_45가_아니라면_예외가_발생한다(int number) {
            //given
            //when then
            assertThatThrownBy(() -> new BonusBall(number))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue());
        }
    }
}