package lotto;

import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @DisplayName("보너스 번호가 비거나 문자인 경우 에러가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new BonusNumber(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new BonusNumber("c"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}