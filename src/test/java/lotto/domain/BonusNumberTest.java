package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @ParameterizedTest(name = "입력 값 : {0}")
    @ValueSource(ints = {46, 47, 48, 49, 50})
    @DisplayName("범위 밖의 보너스 번호 입력을 하면 예외가 발생한다.")
    void 범위_밖_보너스_번호_입력_테스트(int bonusNumber) {
        //when, then
        Assertions.assertThatThrownBy(() -> new BonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 ~ 45사이의");
    }
}
