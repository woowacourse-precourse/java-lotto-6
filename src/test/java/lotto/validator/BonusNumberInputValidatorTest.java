package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.validator.BonusNumberInputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberInputValidatorTest {
    @DisplayName("보너스 번호가 비어있는 입력값일 때 예외가 발생한다.")
    @Test
    void insertBonusNumberWithBlankValue() {
        assertThatThrownBy(() -> new BonusNumberInputValidator().validate(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자 형식의 입력이 아닐 때 예외가 발생한다.")
    @Test
    void insertBonusNumberWithNotNumericValue() {
        assertThatThrownBy(() -> new BonusNumberInputValidator().validate("asda"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 입력값의 상한을 초과하면 예외가 발생한다.")
    @Test
    void insertBonusNumberExceedInputUpperLimit() {
        assertThatThrownBy(() -> new BonusNumberInputValidator().validate("1231294120123"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 숫자가 입력값의 하한 미만일 시 예외가 발생한다.")
    @Test
    void insertBonusNumberLowerThanInputLowerLimit() {
        assertThatThrownBy(() -> new BonusNumberInputValidator().validate("-123718294981243"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}