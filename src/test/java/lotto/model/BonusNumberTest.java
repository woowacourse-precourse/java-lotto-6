package lotto.model;

import org.assertj.core.api.Assertions;
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
        Assertions.assertThat(26).isEqualTo(convertedNumber);
    }

}
