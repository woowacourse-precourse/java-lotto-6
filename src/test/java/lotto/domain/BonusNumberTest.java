package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.util.ErrorMessage.NEGATIVE_NUMBER_ERROR;
import static lotto.util.ErrorMessage.NUMBER_RANGE_ERROR;
import static org.assertj.core.api.Assertions.*;

public class BonusNumberTest {

    @Test
    @DisplayName("올바른 보너스 숫자 테스트")
    void bonusNumberTest() {
        //given
        int validNumber = 1;

        //when
        BonusNumber bonusNumber = new BonusNumber(validNumber);

        //then
        assertThat(bonusNumber.value()).isEqualTo(validNumber);
    }

    @Test
    @DisplayName("로또 내에 보너스 숫자가 있는지 확인하는 테스트")
    void isInTest() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber numberInLotto = new BonusNumber(1);
        BonusNumber numberNotInLotto = new BonusNumber(7);

        //when
        boolean isIn = numberInLotto.isIn(lotto);
        boolean isNotIn = numberNotInLotto.isIn(lotto);

        //then
        assertThat(isIn).isTrue();
        assertThat(isNotIn).isFalse();
    }

    @Test
    @DisplayName("음수로 생성하면 예외 처리")
    void negativeNumberTest() {
        //given
        int negativeNumber = -1;

        //when & then
        assertThatThrownBy(() -> new BonusNumber(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NEGATIVE_NUMBER_ERROR.getMessage());
    }

    @Test
    @DisplayName("1보다 작은 숫자로 생성하면 예외 처리")
    void rangeNumberTest1() {
        //given
        int lowNumber = 0;

        //when & then
        assertThatThrownBy(() -> new BonusNumber(lowNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_ERROR.getMessage());
    }

    @Test
    @DisplayName("45보다 큰 숫자로 생성하면 예외 처리")
    void rangeNumberTest2() {
        //given
        int highNumber = 46;

        //when & then
        assertThatThrownBy(() -> new BonusNumber(highNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(NUMBER_RANGE_ERROR.getMessage());
    }
}
