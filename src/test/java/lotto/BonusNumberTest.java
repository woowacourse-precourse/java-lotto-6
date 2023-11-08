package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @DisplayName("보너스 번호 공백 입력 시 예외가 발생한다.")
    @Test
    void inputBonusNumberIsBlank() {
        assertThatThrownBy(() -> new BonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 문자 입력 시 예외가 발생한다.")
    @Test
    void inputBonusNumberIsNotNumeric() {
        assertThatThrownBy(() -> new BonusNumber("100a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 숫자가 범위를 초과하면 예외가 발생한다.")
    @Test
    void inputBonusNumberOutOfRange() {
        assertThatThrownBy(() -> new BonusNumber("47"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
