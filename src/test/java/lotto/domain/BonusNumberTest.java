package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("보너스 번호의 범위가 맞지않으면 예외가 발생한다.")
    @Test
    void 보너스_번호_범위_테스트() {
        assertThatThrownBy(() -> new BonusNumber("60"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 입력 형태가 숫자가 아니면 예외가 발생한다.")
    @Test
    void 보너스_번호_입력_타입_테스트() {
        assertThatThrownBy(() -> new Money("Hello"))
                .isInstanceOf(IllegalArgumentException.class);
    }


}