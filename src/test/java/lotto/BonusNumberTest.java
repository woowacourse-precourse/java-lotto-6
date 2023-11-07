package lotto;

import lotto.model.domain.vo.BonusNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void should_throwException_when_isNotNumeric() {
        Assertions.assertThatThrownBy(() -> BonusNumber.of("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 형식이 아닙니다.");
    }

    @DisplayName("보너스 번호가 1부터 45 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void should_throwException_when_isNotBetween1And45() {
        Assertions.assertThatThrownBy(() -> BonusNumber.of("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1부터 45 사이의 수를 입력해야 합니다.");
    }
}
