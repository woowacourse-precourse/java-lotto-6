package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("존재하는 보너스 번호를 정수형태로 변환한다.")
    @Test
    void 정수_변환_기능() {
        //given
        BonusNumber bonusNumber = new BonusNumber(26);

        //when
        int convertedNumber = bonusNumber.toInt();

        //then
        assertThat(26).isEqualTo(convertedNumber);
    }

    @DisplayName("46이상의 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void 보너스번호_범위_초과_예외_처리() {
        //given
        final int outRangeNumber = 100;

        //when, then
        assertThatThrownBy(() -> new BonusNumber(outRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR.getErrorMessage());
    }

    @DisplayName("1미만의 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void 보너스번호_범위_미만_예외_처리() {
        //given
        final int outRangeNumber = -80;

        //when, then
        assertThatThrownBy(() -> new BonusNumber(outRangeNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANGE_ERROR.getErrorMessage());
    }

}
