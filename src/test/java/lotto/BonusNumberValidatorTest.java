package lotto;

import lotto.validator.BonusNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberValidatorTest {
    @DisplayName("보너스 번호가 숫자가 아니면 예외가 발생한다.")
    @Test
    void setBonusNumberByString1() {
        assertThatThrownBy(() -> new BonusNumberValidator(List.of(1,2,3,4,5,6)).validate("x"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 입력 시 아무 입력도 하지 않으면 예외가 발생한다.")
    @Test
    void setBonusNumberByNull() {
        assertThatThrownBy(() -> new BonusNumberValidator(List.of(1,2,3,4,5,6)).validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("보너스 번호 입력 시 공백을 입력하면 예외가 발생한다.")
    @Test
    void setBonusNumberByBlank() {
        assertThatThrownBy(() -> new BonusNumberValidator(List.of(1,2,3,4,5,6)).validate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
